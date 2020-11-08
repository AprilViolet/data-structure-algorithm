package cn.aprilviolet.fundamentals.algorithm.tree;

/**
 * LeetCode 116.填充每个节点的下一个右侧节点指针
 *
 * @author liutao
 * @version V0.0.1
 * @date 2020.11.06 星期五 15:11
 */
public class FillNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectNode(root.left, root.right);
        return root;
    }

    private void connectNode(Node firstNode, Node secondNode) {
        if (firstNode == null || secondNode == null) {
            return;
        }
        firstNode.next = secondNode;
        connectNode(firstNode.left, firstNode.right);
        connectNode(secondNode.left, secondNode.right);
        connectNode(firstNode.right, firstNode.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
