package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LeetCode 107. 二叉树的层次遍历 II
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.16 星期一 23:14
 * @since V1.0.0
 */
public class BstLevelTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelTraversal = new LinkedList<>();

        if (root == null) {
            return levelTraversal;
        }
        Queue<TreeNode> bstLevelQueue = new LinkedBlockingQueue<>();
        bstLevelQueue.offer(root);
        while (!bstLevelQueue.isEmpty()) {
            List<Integer> currentLevelList = new LinkedList<>();
            int currentSize = bstLevelQueue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = bstLevelQueue.poll();
                currentLevelList.add(currentNode.val);
                TreeNode currentLeft = currentNode.left;
                TreeNode currentRight = currentNode.right;
                if (currentLeft != null) {
                    bstLevelQueue.offer(currentLeft);
                }
                if (currentRight != null) {
                    bstLevelQueue.offer(currentRight);
                }
            }
            levelTraversal.add(0, currentLevelList);
        }
        return levelTraversal;
    }
}
