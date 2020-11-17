package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 538. 把二叉搜索树转换为累加树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.14 星期六 00:03
 * @since V1.0.0
 */
public class BstConvertSumTree {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);

        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}
