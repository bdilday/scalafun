package com.leet.numberofsegmentstest

import org.scalatest.FunSuite
import com.leet.numberofsegments.NumberOfSegments

class NumberOfSegmentsTest extends FunSuite {
  test("simple test") {
    assert(NumberOfSegments.countSegments("a little test") == 3)
    assert(NumberOfSegments.countSegments(" a little test") == 3)
    assert(NumberOfSegments.countSegments("a little test ") == 3)
  }
}
