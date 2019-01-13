
package InningSim

import breeze.stats.distributions
import breeze.linalg.DenseVector

abstract class Player(id: String, name: String)

case class ParkEffect(hit_prob_factors: Array[Double]) {
  val probs = BatEvents.value zip hit_prob_factors toMap
}

case class Park(id: String, name: String, park_effect: ParkEffect) {

}


case class RunEnvironment(hit_probs: Array[Double]) {
  val probs: Map[BatEvent, Double] = {
    val p0 = 1 - hit_probs.sum;
    BatEvents.value zip (hit_probs ++ Array(p0)) toMap
  }

  def adjustForPark(park_effect: ParkEffect): Unit = {
    val x = for ((ev, f) <- park_effect.probs;
                 p <- probs.get(ev)
    ) yield (ev, 1) // TODO: implement properly
  }

}

class Batter(id: String, name: String,
             hit_probs: Array[Double])
  extends Player(id, name)  {

  val probs: Map[BatEvent, Double] = {
    val p0 = 1 - hit_probs.sum;
    BatEvents.value zip (hit_probs ++ Array(p0)) toMap
  }

}

class Pitcher(id: String, name: String,
             hit_probs: Array[Double])
  extends Player(id, name) {

  val probs: Map[BatEvent, Double] = {
    val p0 = 1 - hit_probs.sum;
    BatEvents.value zip (hit_probs ++ Array(p0)) toMap
  }

}


object SimulateEvent {

  def log_odds_inverse(w: Double): Double = {
    //println(w, w/(1+w))
    w / (1 + w)
  }
  def combine_probs_log_odds(probs: Double*): Double = {
   // println(probs)
    log_odds_inverse(probs.map(x => x / (1-x)).fold(1.0)(_ * _))
  }

  def sim_prob(batter: Batter, pitcher: Pitcher, re: RunEnvironment): Map[BatEvent, Double] = {
    val x = for ((ev, p) <- batter.probs;
                 q <- pitcher.probs.get(ev);
                 e <- re.probs.get(ev)
    ) yield (ev, combine_probs_log_odds(p, q, 1-e))

    return x toMap
  }

  def next_event: BatEvent = {
    // TODO implement
    x1b()

  }

}
