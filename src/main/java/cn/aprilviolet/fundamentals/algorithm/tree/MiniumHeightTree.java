package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * 面试题 04.02. 最小高度树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.24 星期日 22:36
 * @since V1.0.0
 */
public class MiniumHeightTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length);
    }

    private TreeNode traverse(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return null;
        }
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        TreeNode rootNode = new TreeNode(nums[middleIndex]);
        rootNode.left = traverse(nums, leftIndex, middleIndex);
        rootNode.right = traverse(nums, middleIndex + 1, rightIndex);
        return rootNode;
    }
}
