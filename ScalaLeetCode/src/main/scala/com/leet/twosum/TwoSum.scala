
package com.leet.twosum

object TwoSum {

    def run(nums: Array[Int], target: Int): Array[Int] = {
      var cache: Map[Int, Int] = Map()
      for (i <- 0 until nums.length) {

        val diff: Int = target - nums(i)
        println(i, nums(i), cache, diff)
        if (cache contains diff) {
          println("found it!")
          return Array(cache(diff), i)
        }
        cache += (nums(i) -> i)
      }

      throw new Exception("no solution found")
      }

}

object TwoSum2{
  def run(nums: Array[Int], target: Int): Array[Int] = {
    def getSum(hash: collection.immutable.Map[Int, Int], i: Int): Array[Int] = {
      if (hash contains nums(i)) Array(hash(nums(i)), i)
      else getSum(hash + (target - nums(i) -> i), i + 1)
    }
    getSum(collection.immutable.Map[Int, Int](), 0)
  }
}