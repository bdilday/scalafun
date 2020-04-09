package com.leet.combinationsum

object CombinationSum {

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {

    def dfs(nums: List[Int], left: Int, current_path: List[Int]): List[List[Int]] = {

      left match {
        case x if x < 0 => Nil
        case 0 => List(current_path)
        case _ => {
          nums match {
            case Nil => Nil
            case _ => dfs(nums, left - nums.head, nums.head :: current_path) ::: dfs(nums.tail, left, current_path)
          }
        }
      }
    }

    dfs(candidates.toList, target, List.empty)

  }
}

