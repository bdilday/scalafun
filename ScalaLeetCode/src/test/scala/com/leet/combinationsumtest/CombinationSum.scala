package com.leet.combinationsumtest

import org.scalatest.FunSuite
import com.leet.combinationsum.CombinationSum

class CombinationSumTest extends FunSuite {

  test("sums") {
    val candidates = Array(2,3,6,7)
    val target: Int = 7
    assert(CombinationSum.combinationSum(candidates, target).length == 2)
  }

  test("sums one") {
    val candidates = Array(1, 2, 3)
    val target: Int = 3
    assert(CombinationSum.combinationSum(candidates, target).length == 3)
  }

}
