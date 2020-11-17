package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 235. 二叉搜索树的最近公共祖先
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.17 星期二 23:11
 * @since V1.0.0
 */
public class BstNearestCommonAncestor {
    private TreeNode commonAncestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p,q);
        return commonAncestor;
    }

    public void traverse(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            commonAncestor = root;
        } else if (p.val < root.val && q.val < root.val) {
            traverse(root.left, p, q);
        } else {
            traverse(root.right, p, q);
        }
    }
}
