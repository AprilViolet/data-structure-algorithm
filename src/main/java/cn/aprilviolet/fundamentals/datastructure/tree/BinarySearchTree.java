package cn.aprilviolet.fundamentals.datastructure.tree;

import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.11 星期日 23:07
 * @since V1.0.0
 */
@Log4j2
public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 节点的个数
     */
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 返回个数
     *
     * @return 二分搜索树中元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return true:为空
     * false:不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二叉树中田间元素
     *
     * @param element 添加的元素
     */
    public void add(E element) {
        root = add(root, element);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node    根
     * @param element 插入的元素
     * @return 添加后的二叉树
     */
    private Node add(Node node, E element) {
        if (node == null) {
            size++;
            return new Node(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = add(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = add(node.right, element);
        }

        return node;
    }

    /**
     * 判断二叉树中是否包含某个元素
     *
     * @param element 某个元素
     */
    public void contain(E element) {
        contain(root, element);
    }

    /**
     * 判断二叉树中是否包含某个元素
     *
     * @param node    二叉树Root
     * @param element 某个元素
     * @return true:包含某元素
     * false:不包含某元素
     */
    private boolean contain(Node node, E element) {
        if (node == null) {
            return false;
        }

        if (element.compareTo(node.element) == 0) {
            return true;
        } else if (element.compareTo(node.element) < 0) {
            return contain(node.left, element);
        } else {
            return contain(node.right, element);
        }
    }

    /**
     * 前序遍历二叉树
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历二叉树
     *
     * @param node 二叉树
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        log.info(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node 二叉树
     */
    private void inOrder(Node node) {
        if (node == null) {

            return;
        }

        inOrder(node.left);
        log.info(node.element);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树
     *
     * @param node 二叉树
     */
    private void postOrder(Node node) {
        if (node == null) {

            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        log.info(node.element);
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.remove();
            log.info(node.element);

            if (node.left != null) {
                nodeQueue.add(node.left);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
            }
        }
    }

    /**
     * 查询二叉树中最小的元素
     *
     * @return 最小元素
     */
    public E minElement() {
        if (size == 0) {
            throw new IllegalArgumentException("二叉树为空");
        }

        return minElement(root).element;
    }

    /**
     * 查询二叉树中最小所在节点
     *
     * @return 最小元素所在节点
     */
    private Node minElement(Node node) {
        if (node.left == null) {
            return node;
        }
        return minElement(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return 二叉树中最大的元素
     */
    public E maxiElement() {
        if (size == 0) {
            throw new IllegalArgumentException("二叉树为空");
        }

        return maxiElement(root).element;
    }

    /**
     * 寻找二分搜索树的最大元素节点
     *
     * @return 二叉树中最大的节点
     */
    private Node maxiElement(Node node) {
        if (node.right == null) {
            return node;
        }

        return maxiElement(node.right);
    }

    /**
     * 移除二叉树中最小的元素
     *
     * @return 移除的最小二叉树的元素
     */
    public E removeMin() {
        E minElement = minElement();
        root = removeMin(root);
        return minElement;
    }

    /**
     * 移除二叉树中最小的元素
     *
     * @param node 根
     * @return 移除后的二叉树
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return 移除的最小二叉树的元素
     */
    public E removeMax() {
        E ret = maxiElement();
        root = removeMax(root);
        return ret;
    }

    /**
     * 移除二叉树中最大的元素
     *
     * @param node 根
     * @return 移除后的二叉树
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 移除二叉树中某个元素
     *
     * @param element 需要移除的元素
     */
    public void remove(E element) {
        root = remove(root, element);
    }

    /**
     * 移除二叉树中某个元素
     *
     * @param node root
     * @param element 需要移除的元素
     * @return 返回被移除后的二叉树
     */
    private Node remove(Node node, E element) {
        if (node == null) {
            return null;
        }

        if (element.compareTo(node.element) < 0) {
            node.left = remove(node.left, element);
            return node;
        } else if (element.compareTo(node.element) > 0) {
            node.right = remove(node.right, element);
            return node;
        } else {
            // 找到了被删除的节点
            // 当前节点无左子树，有右子树
            if (node.left == null) {
                Node rightTemp = node.right;
                node.right = null;
                size--;
                return rightTemp;
            }
            // 当前节点有左子树，无右子树
            if (node.right == null) {
                Node leftTemp = node.left;
                node.left = null;
                size--;
                return leftTemp;
            }

            // 当前节点有左子树和右子树，则需要找出右子树最小的元素作为当前节点
            Node finalNode = minElement(node.right);
            finalNode.right = removeMin(node.right);
            finalNode.left = node.left;

            node.left = node.right = null;
            return finalNode;
        }
    }


    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        generateString(root, 0, outputString);
        return outputString.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node         二叉树
     * @param depth        深度
     * @param outputString 输出的字符串
     */
    private void generateString(Node node, int depth, StringBuilder outputString) {

        if (node == null) {
            outputString.append(generateDepthString(depth)).append("null\n");
            return;
        }

        outputString.append(generateDepthString(depth)).append(node.element).append("\n");
        generateString(node.left, depth + 1, outputString);
        generateString(node.right, depth + 1, outputString);
    }

    /**
     * 打印相应深度的'--'
     *
     * @param depth 深度
     * @return 相应深度的'--'
     */
    private String generateDepthString(int depth) {
        return "--".repeat(Math.max(0, depth));
    }

    private class Node {
        /**
         * 节点的元素
         */
        private E element;

        /**
         * 左节点
         */
        private Node left;

        /**
         * 右节点
         */
        private Node right;

        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
}
