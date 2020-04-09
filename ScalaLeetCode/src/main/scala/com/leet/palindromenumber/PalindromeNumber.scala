package com.leet.palindromenumber

import scala.annotation.tailrec

object PalindromeNumber {

  def run(x: Int): Boolean = {

    @tailrec
    def check_pal(s: String, current: Boolean): Boolean = {
      (s.length, current) match {
        case (_, b) if b == false => false
        case (x, _) if x <= 1 => current
        case _ => check_pal(s.init.tail, current && s.head == s.last)
      }
    }

    check_pal(x.toString, true)
  }
}
