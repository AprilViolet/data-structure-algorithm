package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 106.从中序和后序构建二叉树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.11 星期三 23:57
 * @since V1.0.0
 */
public class BuildTreeOfMiddleAfter {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        int rootIndex = postEnd;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        TreeNode rootNode = new TreeNode(rootValue);
        int leftSize = rootIndex - inStart;
        rootNode.left = build(inorder, inStart, rootIndex - 1, postorder,
                postStart, postStart + leftSize - 1);
        rootNode.right = build(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return rootNode;
    }
}
