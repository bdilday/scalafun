package com.leet.pathsumtest

import org.scalatest.FunSuite
import com.leet.pathsum.{TreeNode, PathSum}


class PathSumTest extends FunSuite {
test("trivial") {
  assert(1 == 1)
}

  test ("has path") {
    val tree = new TreeNode(3)
    tree.left = new TreeNode(2)
    tree.right = new TreeNode(1)
    assert(PathSum.hasPathSum(tree, 5))
    assert(PathSum.hasPathSum(tree, 4))
    assert(!PathSum.hasPathSum(tree, 6))
  }
}
