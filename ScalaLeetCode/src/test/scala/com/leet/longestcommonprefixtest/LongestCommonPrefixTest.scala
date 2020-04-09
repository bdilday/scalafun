package com.leet.longestcommonprefixtest

import org.scalatest.FunSuite
import com.leet.longestcommonprefix.LongestCommonPrefix

class LongestCommonPrefixTest extends FunSuite {
  test("a simple test") {
    val strs1: Array[String] = Array("abc", "abcd", "abcxyz")
    assert(LongestCommonPrefix.run(strs1) == "abc")

    val strs2: Array[String] = Array("abc", "abcd", "xyz")
    assert(LongestCommonPrefix.run(strs2) == "")

    val strs3 = Array("abc", "xyz", "")
    assert(LongestCommonPrefix.run(strs3) == "")

    val strs4: Array[String] = Array()
    assert(LongestCommonPrefix.run(strs4) == "")
  }

  test("simple str compare") {
    assert(LongestCommonPrefix.str_compare("abc", "abcd", "") == "abc")
    assert(LongestCommonPrefix.str_compare("abc", "z", "") == "")
  }
}
