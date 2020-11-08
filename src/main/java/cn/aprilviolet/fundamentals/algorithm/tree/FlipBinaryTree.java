package cn.aprilviolet.fundamentals.algorithm.tree;

/**
 * LeetCode 226.翻转二叉树
 *
 * @author liutao
 * @version V0.0.1
 * @date 2020.11.06 星期五 15:00
 */
public class FlipBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
