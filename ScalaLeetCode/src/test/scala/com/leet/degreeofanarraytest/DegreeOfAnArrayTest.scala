package com.leet.degreeofanarraytest

import org.scalatest.FunSuite
import com.leet.degreeofanarray.DegreeOfAnArray

class DegreeOfAnArrayTest extends FunSuite {

  test("example 1") {
    val data = Array(1, 2, 2, 3, 1)
    assert(DegreeOfAnArray.findShortestSubArray(data) == 6)
  }

  test("example 2") {
    val data = Array(1, 2, 2, 3, 1, 4, 2)
    assert(DegreeOfAnArray.findShortestSubArray(data) == 6)
  }
}
