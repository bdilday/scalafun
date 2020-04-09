package com.leet.pathsum

object PathSum {

  /**
    * Definition for a binary tree node.
    * class TreeNode(var _value: Int) {
    * var value: Int = _value
    * var left: TreeNode = null
    * var right: TreeNode = null
    * }
    */

    def hasPathSum(root: TreeNode, sum: Int): Boolean = {
      root match {
        case x if x == null => false
        case x if x.left == null && x.right == null => x.value == sum
        case _ => hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
      }

    }


}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}