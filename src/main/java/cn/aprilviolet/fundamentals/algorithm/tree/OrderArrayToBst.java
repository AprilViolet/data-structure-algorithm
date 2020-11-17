package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 108. 将有序数组转换为二叉搜索树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:16
 * @since V1.0.0
 */
public class OrderArrayToBst {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0,nums.length - 1);
    }

    private TreeNode traverse(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + ((right - left + 1) >> 1);
        TreeNode root = new TreeNode(nums[middle]);
        root.left = traverse(nums, left, middle - 1);
        root.right = traverse(nums, middle + 1, right);
        return root;
    }
}
