package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 501. 二叉搜索树中的众数
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.19 星期四 23:10
 * @since V1.0.0
 */
public class BstMode {
    private List<Integer> resultTemp = new ArrayList<>();

    private int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] result = new int[resultTemp.size()];
        for (int i = 0; i < resultTemp.size(); i++) {
            result[i] = resultTemp.get(i);
        }
        return result;
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            traverse(root.left);
            update(root.val);
            traverse(root.right);
        }
    }

    private void update(int value) {
        if (value == base) {
            ++count;
        } else {
            count = 1;
            base = value;
        }

        if (count == maxCount) {
            resultTemp.add(base);
        }

        if (count > maxCount) {
            maxCount = count;
            resultTemp.clear();
            resultTemp.add(base);
        }
    }
}
