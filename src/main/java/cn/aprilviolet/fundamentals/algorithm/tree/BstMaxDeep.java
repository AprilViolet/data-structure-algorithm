package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 104. 二叉树的最大深度
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:15
 * @since V1.0.0
 */
public class BstMaxDeep {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
