package com.leet.maximumsubarraytest

import org.scalatest.FunSuite
import com.leet.maximumsubarray.MaximumSubarray

class MaximumSubarrayTest extends FunSuite {

  test("max subarray") {
    val nums: Array[Int] = Array(-2,1,-3,4,-1,2,1,-5,4)
    assert(MaximumSubarray.maxSubArray(nums) == 6)
  }

  test("max subarray with single entry") {
    val nums: Array[Int] = Array(1)
    assert(MaximumSubarray.maxSubArray(nums) == 1)
  }

  test("max subarray with single negative entry") {
    val nums: Array[Int] = Array(-1)
    assert(MaximumSubarray.maxSubArray(nums) == -1)
  }
}
