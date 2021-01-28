package com.karanarora.interviewbit.leetcode.trees;

/*
  @author gs-karora on 12/12/20
 */

public class TreeNode {
  int val;

  TreeNode left;

  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  boolean isValidBST(TreeNode node) {

    return helper(node, null, null);
  }

  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    if (!helper(node.right, val, upper))
      return false;

    return helper(node.left, lower, val);
  }

  class Solution {





  }

}
