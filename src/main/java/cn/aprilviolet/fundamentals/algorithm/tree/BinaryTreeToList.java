package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 144.二叉树展开为链表
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.11 星期三 23:52
 * @since V1.0.0
 */
public class BinaryTreeToList {
    private TreeNode lastRoot = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = lastRoot;
        root.left = null;
        lastRoot = root;
    }
}
