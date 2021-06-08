package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.24 星期日 22:39
 * @since V1.0.0
 */
public class RecentCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        }
        if (leftNode == null && rightNode == null) {
            return null;
        }
        return leftNode == null ? rightNode : leftNode;
    }
}
