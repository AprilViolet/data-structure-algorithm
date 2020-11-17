package cn.aprilviolet.fundamentals.algorithm.tree;

import cn.aprilviolet.fundamentals.algorithm.base.TreeNode;

/**
 * LeetCode 105.从前序和中序构建二叉树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.11 星期三 23:56
 * @since V1.0.0
 */
public class BuildTreeOfPreMiddle {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 当前的根节点的值
        int rootValue = preorder[preStart];
        // 中序遍历中的根节点的位置
        int middleindex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                middleindex = i;
                break;
            }
        }
        int leftSize = middleindex - inStart;
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = build(preorder, preStart + 1, preStart + leftSize, inorder,
                inStart, middleindex - 1);
        treeNode.right = build(preorder,preStart + leftSize + 1, preEnd, inorder,
                middleindex + 1, inEnd);
        return treeNode;
    }
}
