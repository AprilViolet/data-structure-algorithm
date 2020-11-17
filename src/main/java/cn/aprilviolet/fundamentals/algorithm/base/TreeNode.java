package cn.aprilviolet.fundamentals.algorithm.base;

/**
 * 共同的二叉树类
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:08
 * @since V1.0.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
