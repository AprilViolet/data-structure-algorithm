package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 101. 对称二叉树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:17
 * @since V1.0.0
 */
public class SymmetricBst {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetricTree(root.left, root.right);
        }
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
        }
    }
}
