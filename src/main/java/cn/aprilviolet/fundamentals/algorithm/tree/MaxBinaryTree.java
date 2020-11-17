package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 654.最大二叉树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.11 星期三 23:56
 * @since V1.0.0
 */
public class MaxBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lower, int higher) {
        if (lower > higher) {
            return null;
        }

        // 找到最大的元素
        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = lower; i <= higher; i++) {
            if (nums[i] > maxValue) {
                index = i;
                maxValue = nums[i];
            }
        }

        TreeNode treeNode = new TreeNode(maxValue);
        treeNode.left = build(nums, lower, index - 1);
        treeNode.right = build(nums, index + 1, higher);
        return treeNode;
    }
}
