package com.leet.buysellstocktest

import org.scalatest.FunSuite
import com.leet.buysellstock.{BuySellStock}

class BuySellStockTest extends FunSuite {



  test("prices") {
    val prices: Array[Int] = Array(1,2,4)
    assert(BuySellStock.maxProfit(prices) == 3)

    assert(BuySellStock.maxProfit(Array()) == 0)
    assert(BuySellStock.maxProfit(Array(1)) == 0)
    assert(BuySellStock.maxProfit(Array(4, 0)) == 0)

    assert(BuySellStock.maxProfit(Array(2, 7, 1, 4, 11)) == 10)

  }

  test("long array") {
    assert(BuySellStock.maxProfit(Array(2, 7, 1, 4, 11)) == 10)

  }
}
