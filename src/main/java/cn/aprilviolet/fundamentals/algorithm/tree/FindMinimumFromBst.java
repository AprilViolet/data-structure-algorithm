package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 230. 二叉搜索树中第K小的元素
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.14 星期六 00:03
 * @since V1.0.0
 */
public class FindMinimumFromBst {
    private int rank = 0;

    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
