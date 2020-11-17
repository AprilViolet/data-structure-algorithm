package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 404. 左叶子之和
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.17 星期二 23:11
 * @since V1.0.0
 */
public class LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftSum += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + leftSum;
    }
}
