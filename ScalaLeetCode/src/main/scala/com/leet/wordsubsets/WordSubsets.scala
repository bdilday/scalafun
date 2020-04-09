package com.leet.wordsubsets


object WordSubsetsHash {

  def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
    val target = WordSubsets.collapse_target(B.distinct)
    val h = string_to_hash(target)
    List("")
  }

  def check_word(s: String, h: Map[Char, Int]): Boolean = {
    val sh = string_to_hash(s)
true
  }

  def check_hashes(candidate: Map[Char, Int], target: Map[Char, Int]): Boolean = {
true
  }

  def string_to_hash(s: String): Map[Char, Int] = {

    def _update(s: String, m: Map[Char, Int]): Map[Char, Int] = {
      s match {
        case x if x.length == 0 => m
        case _ => _update(s.tail, m + (s.head -> (m.getOrElse(s.head, 0) + 1)))
      }
    }
    _update(s, Map[Char, Int]())
  }
}

object WordSubsets {

  def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
    A.filter(s => has_sub(s, collapse_target(B))).toList
  }

  def combine_strs(s1: String, s2: String): String = {

    def update_combination(s1: String, s2: String, current: String): String = {
      (s1, s2) match {
        case (s, t) if s.isEmpty && t.isEmpty => current
        case (s, t) if s.isEmpty => current + t
        case (s, t) => {
          update_combination(s.tail, remove_at_index(t, t.indexOf(s.head)), current + s.head)
        }
      }
    }

    update_combination(s1, s2, "").toString

  }

  def collapse_target(target_subs: Array[String]): String = {
    target_subs.fold("")(combine_strs(_, _))
  }

  def has_all_sub(s: String, target_subs: Array[String]): Boolean = {
    target_subs match {
      case x if x.length == 0 => true
      case x if has_sub(s, target_subs.head) => has_all_sub(s, target_subs.tail)
      case _ => false
    }
  }

  def remove_at_index(s: String, idx: Int): String = {
    idx match {
      case i if i < 0 => s
      case _ => s.take(idx) ++ s.drop(idx + 1)
    }
  }

  def has_sub(s: String, target: String): Boolean = {
    (s, target) match {
      case (_, t) if t.length == 0 => true
      case (s, t) if s.contains(t.head) => {
        val idx = s.indexOf(t.head)
        has_sub(remove_at_index(s, idx), t.tail)
      }
      case _ => false
    }
  }
}
