package InningSim

import breeze.linalg.DenseVector

object InningSim {

  def main(args: Array[String]): Unit = {
    println("blah")

    val default_hit_probs = Array(0.08, 0.15, 0.05, 0.005, 0.035)
    val batter_hit_probs = Array(0.25, 0.0, 0.0, 0.25, 0.0)
    val pitcher_hit_probs = Array(0.25, 0.0, 0.0, 0.25, 0.0)
    val b = new Batter("generic001", "generic batter", batter_hit_probs)
    val p = new Pitcher("generic002", "generic pitcher", pitcher_hit_probs)
    val env = new RunEnvironment(default_hit_probs)
    println(b.probs)


    val game_state = GameState()
    var current_outs = 0
    val current_state = game_state

//    while (current_outs < 3) {
//      println("*********************")
//      val event_probs = SimulateEvent.sim_prob(b, p, env)
//      println(event_probs)
//      val x = for (k <- BatEvents.value) yield event_probs.get(k).get
//      val distribution_params = DenseVector[Double](x.toArray)
//      val mult = new breeze.stats.distributions.Multinomial[DenseVector[Double], Int](distribution_params)
//      val ev = BatEvents.value(mult.draw())
//      println(ev)
//      current_state = current_state.evolve_state(ev)
//      println(current_state)
//      current_outs = current_state.base_outs.outs
//    }

          val event_probs = SimulateEvent.sim_prob(b, p, env)
          val x = for (k <- BatEvents.value) yield event_probs.get(k).get
          val distribution_params = DenseVector[Double](x.toArray)
          val mult = new breeze.stats.distributions.Multinomial[DenseVector[Double], Int](distribution_params)
          val ev = BatEvents.value(mult.draw())

    val runs_arr = (1 to 10000).par.map(_ => runs_from_state(current_state, mult)(0))
    val runs_total = runs_arr.sum
    println(runs_total, runs_arr.length, runs_total / (1.0 * runs_arr.length))
  }


  def runs_from_state(game_state: GameState, mult: breeze.stats.distributions.Multinomial[DenseVector[Double], Int]): Array[Int] = {
    // TODO: implement
    game_state.base_outs.outs match {
      case 3 => game_state.score
      case _ => {
        val ev = BatEvents.value(mult.draw())
        val current_state = game_state.evolve_state(ev)
        println(ev, game_state, current_state)
        runs_from_state(current_state, mult)
      }
    }

  }
}
