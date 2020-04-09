package com.leet.numberofsegments

object NumberOfSegments {

  def countSegments(s: String): Int = {
    update_count(s)
  }

  def update_count(s: String,
                   last_char_was_letter: Boolean = false,
                   current_count: Int = 0): Int = {
    (s, last_char_was_letter) match {
      case (s, _) if s.length == 0 => current_count
      case (s, v) if !s.head.isSpaceChar && !v => update_count(s.tail, true, current_count + 1)
      case _ => update_count(s.tail, !s.head.isSpaceChar, current_count)
    }

  }

}
