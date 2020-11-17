package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 111. 二叉树的最小深度
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:14
 * @since V1.0.0
 */
public class BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return leftDepth == 0 || rightDepth == 0 ? 1 + leftDepth + rightDepth : 1 + Math.min(leftDepth, rightDepth);
    }
}
