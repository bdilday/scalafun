
package com.leet.degreeofanarray
// https://leetcode.com/problems/degree-of-an-array/

object DegreeOfAnArray {

  def findShortestSubArray(nums: Array[Int]): Int = {

  }

  def update_map(indexed_nums: Array[(Int, Int)], result: Map[Int, Int]): Map[Int, Int] = {
    indexed_nums match {
      case x if x.isEmpty => result
      case _ => {
        val nm = Map()
        update_map(indexed_nums.tail)
      }
    }
  }
}
