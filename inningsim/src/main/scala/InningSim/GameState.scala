package InningSim

object Bases {

}

case class BaseState(bases: Map[Int, Int]) {

  override def toString: String = {
    s"1 => ${bases.get(1).get} 2 => ${bases.get(2).get} 3 => ${bases.get(3).get}"
  }
}


case class BaseOutState(bases: BaseState = BaseState(Map(1 -> 0, 2 -> 0, 3 -> 0)),
                        outs: Int = 0) {

  override def toString: String = {
    s"bases: ${bases} outs $outs"
  }

}

case class GameState(base_outs: BaseOutState = BaseOutState(), score: Array[Int] = Array(0, 0)) {

  override def toString: String = {
    s"base out: $base_outs score ${score(0)} to ${score(1)}"
  }

  def evolve_state(ev: BatEvent): GameState = {
    val b1 = this.base_outs.bases.bases.get(1).get
    val b2 = this.base_outs.bases.bases.get(2).get
    val b3 = this.base_outs.bases.bases.get(3).get

    val bo = ev match {
      case xout() => {
        BaseOutState(
          this.base_outs.bases,
          this.base_outs.outs + 1
        )
      }
      case xbb() => {
        val x1 = 1
        val x2: Int = if (b1 == 1) 1 else b2
        val x3: Int = if (b1 == 1 && b2 == 1) 1 else b3
        BaseOutState(
          BaseState(Map(1 -> x1, 2 -> x2, 3 -> x3)), this.base_outs.outs)
      }
      case x1b() => {
        val x1 = 1
        val x2: Int = if (b1 == 1) 1 else 0
        val x3: Int = if (b2 == 1) 1 else 0
        BaseOutState(
          BaseState(Map(1 -> x1, 2 -> x2, 3 -> x3)), this.base_outs.outs)
      }
      case x2b() => {
        val x1 = 0
        val x2: Int = 1
        val x3: Int = if (b1 == 1) 1 else 0
        BaseOutState(
          BaseState(Map(1 -> x1, 2 -> x2, 3 -> x3)), this.base_outs.outs)
      }
      case x3b() => {
        val x1 = 0
        val x2: Int = 0
        val x3: Int = 1
        BaseOutState(
          BaseState(Map(1 -> x1, 2 -> x2, 3 -> x3)), this.base_outs.outs)
      }
      case x4b() => {
        val x1 = 0
        val x2: Int = 0
        val x3: Int = 0
        BaseOutState(
          BaseState(Map(1 -> x1, 2 -> x2, 3 -> x3)), this.base_outs.outs)
      }
    }
    val delta_runs = BatEvents.runs_scored(this.base_outs, bo)
    val new_score = Array(this.score(0) + delta_runs, this.score(1))
    GameState(bo, new_score)
  }

}
