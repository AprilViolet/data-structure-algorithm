package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 652.寻找重复二叉树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.11 星期三 23:57
 * @since V1.0.0
 */
public class RepeatTree {
    /**
     * 记录每个节点子树的及其次数
     */
    private final HashMap<String, Integer> treeFrequencyMap = new HashMap<>();

    /**
     * 不重复的子树
     */
    private final LinkedList<TreeNode> subTreeList = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverseTree(root);
        return subTreeList;
    }

    private String traverseTree(TreeNode rootTree) {
        if (rootTree == null) {
            return "#";
        }

        String leftTree = traverseTree(rootTree.left);
        String rightTree = traverseTree(rootTree.right);
        String subTreeStr = leftTree + "," + rightTree + "," + rootTree.val;

        Integer treeFrequency = treeFrequencyMap.getOrDefault(subTreeStr, 0);
        if (treeFrequency == 1) {
            subTreeList.addFirst(rootTree);
        }
        treeFrequencyMap.put(subTreeStr, treeFrequency + 1);
        return subTreeStr;
    }
}
