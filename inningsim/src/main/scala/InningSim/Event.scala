package InningSim

sealed abstract class BatEvent
sealed abstract class RunEvent

case class take_base(base: Int, take: Boolean) extends RunEvent

case class xout() extends BatEvent
case class xbb() extends BatEvent
case class x1b() extends BatEvent
case class x2b() extends BatEvent
case class x3b() extends BatEvent
case class x4b() extends BatEvent

object RunEvents {
  val value = List(
    take_base(3, true),
    take_base(3, false),
    take_base(4, true),
    take_base(4, false)
  )
}

object BatEvents {
  val value = List(xbb(), x1b(), x2b(), x3b(), x4b(), xout())

  def runs_scored(base_out_start: BaseOutState, base_out_end: BaseOutState): Int = {
    // runs = -d(runners) - d(outs) + 1
    val runners_end: Int = base_out_end.bases.bases.values.sum
    val runners_start: Int = base_out_start.bases.bases.values.sum
    val delta_runners = runners_end - runners_start
    val delta_outs = base_out_end.outs - base_out_start.outs
    assert(delta_outs >= 0)
    1 - delta_runners - delta_outs
  }
}


//impl BOState {
//  pub fn runs_scored(&self, last_state: BOState) -> i32 {
//  // before = after
//  // runners + 1 = runners + runs scored + outs made
//  // runs scored = -d(runners) - d(outs) + 1
//  let runners_end: i32 = self.bases.iter().sum();
//  let runners_start: i32 = last_state.bases.iter().sum();
//  let douts = self.outs - last_state.outs;
//  -douts - (runners_end - runners_start) + 1
//}
//}
