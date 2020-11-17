package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 257. 二叉树的所有路径
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.17 星期二 23:12
 * @since V1.0.0
 */
public class AllPaths {
    private final List<String> allPaths = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            traverse(root, "");
        }
        return allPaths;
    }

    public void traverse(TreeNode root, String path) {
        if (root != null) {
            path += root.val;
            // 叶子几点
            if (root.left == null && root.right == null) {
                allPaths.add(path);
            } else {
                // 非叶子节点
                path += "->";
                traverse(root.left, path);
                traverse(root.right, path);
            }
        }
    }
}
