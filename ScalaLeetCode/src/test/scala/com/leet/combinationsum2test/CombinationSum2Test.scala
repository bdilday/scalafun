package com.leet.combinationsum2test

import com.leet.combinationsum2.CombinationSum2
import org.scalatest.FunSuite

class CombinationSum2Test extends FunSuite {
  test("trivial") {
    assert(1 == 1)
  }

  test("example 1") {
    val data = Array(10, 1, 2, 7, 6, 1, 5)
    assert(CombinationSum2.combinationSum2(data, 8).length == 4)
  }

  test("example 2") {
    val data = Array(2, 5, 2, 1, 2)
    assert(CombinationSum2.combinationSum2(data, 5).length == 2)
  }
}
