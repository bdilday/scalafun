package com.leet.longestcommonprefix

object LongestCommonPrefix {
  def run(strs: Array[String]): String = {
    strs match {
      case x if x.length <= 1 => ""
      case _ => shortest(strs)
    }
  }

  def shortest(strs: Array[String]): String = {
    strs.fold(strs(0))(str_compare(_, _))
  }

  def str_compare(str1: String, str2: String, current: String = ""): String = {
    (str1, str2) match {
      case (x, _) if x.length == 0 => current
      case (_, y) if y.length == 0 => current
      case (x, y) if x.head == y.head => str_compare(str1.tail, str2.tail, current + x.head)
      case _ => current
    }
  }
}

