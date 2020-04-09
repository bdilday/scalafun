package com.leet.buysellstock

object BuySellStock {

  def maxProfit(prices: Array[Int]): Int = {

    def sol(prices: Array[Int], highest: Int, best: Int): Int = {
      prices match {
        case x if x.isEmpty => best
        case x => sol(x.init, math.max(highest, x.last), math.max(best, highest-x.last))
      }
    }

    sol(prices, 0, 0)
  }

}


