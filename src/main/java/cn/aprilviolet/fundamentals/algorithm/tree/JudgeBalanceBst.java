package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 110. 平衡二叉树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:15
 * @since V1.0.0
 */
public class JudgeBalanceBst {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int treeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
