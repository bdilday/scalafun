package com.leet.maximumsubarray

object MaximumSubarray {

  def maxSubArray(nums: Array[Int]): Int = {

//    nums.tail.scan(nums.head) { (s, e) => math.max(s + e, e) }.max
        def sol(prices: Array[Int], highest: Int, best: Int): Int = {
          prices match {
            case x if x.isEmpty => best
            case x => sol(x.init, math.max(highest, x.last), math.max(best, highest-x.last))
          }
        }

        val agg_nums = nums.scan(0)(_ + _)
        sol(agg_nums.init, agg_nums.last, agg_nums.last)
  }
}