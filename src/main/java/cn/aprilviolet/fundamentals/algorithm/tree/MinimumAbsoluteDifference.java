package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.24 星期日 22:36
 * @since V1.0.0
 */
public class MinimumAbsoluteDifference {
    int answer;
    int preValue;

    public int getMinimumDifference(TreeNode root) {
        answer = Integer.MAX_VALUE;
        preValue = -1;
        traverse(root);
        return answer;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (preValue != -1) {
            answer = Math.min(answer, root.val - preValue);
        }
        preValue = root.val;
        traverse(root.right);
    }
}
