package cn.aprilviolet.fundamentals.datastructure.tree;

/**
 * 线段树
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.17 星期六 16:03
 * @since V1.0.0
 */
public class SegmentTree<E> {
    /**
     * 具体的线段树
     */
    private E[] tree;

    /**
     * 存储的具体数据
     */
    private E[] data;

    private SegmentTreeMerge<E> treeMerge;

    public SegmentTree(E[] array, SegmentTreeMerge<E> treeMerge) {
        data = (E[]) new Object[array.length];
        System.arraycopy(array, 0, data, 0, array.length);
        tree = (E[]) new Object[4 * array.length];
        this.treeMerge = treeMerge;

        buildSegmentTree(0, 0, array.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChildIndex = rightChildIndex(treeIndex);

        int middleChildIndex = left + (right - left) / 2;
        buildSegmentTree(leftChildIndex, left, middleChildIndex);
        buildSegmentTree(rightChildIndex, middleChildIndex + 1, right);

        tree[treeIndex] = treeMerge.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("数组下标越界");
        }
        return data[index];
    }

    /**
     * 返回当前节点的左孩子的index
     *
     * @param index 当前节点的index
     * @return 当前节点的左孩子的index
     */
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回当前节点的右孩子的index
     *
     * @param index 当前节点的index
     * @return 当前节点的右孩子的index
     */
    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    /**
     * 查询某区间内的值
     *
     * @param queryLeft 左区间[包含]
     * @param queryRight 右区间[包含]
     * @return 区间内的值
     */
    public E query(int queryLeft, int queryRight) {
        if ((queryLeft < 0 || queryRight < 0 || queryLeft > queryRight
                || queryLeft >= data.length || queryRight >= data.length)) {
            throw new IllegalArgumentException("数组下标越界");
        }
        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    /**
     * 查询某区间内的值
     *
     * @param treeIndex 当前节点
     * @param left 线段树的左边
     * @param right 线段树的右边
     * @param queryLeft 左区间[包含]
     * @param queryRight 右区间[包含]
     * @return 区间内的值
     */
    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }

        int middleChildIndex = left + (right - left) / 2;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChileIndex = rightChildIndex(treeIndex);

        if (queryLeft >= middleChildIndex + 1) {
            return query(rightChileIndex,middleChildIndex + 1, right, queryLeft, queryRight);
        } else if (queryRight <= middleChildIndex) {
            return query(leftChildIndex, left, middleChildIndex, queryLeft, queryRight);
        }

        E leftResult = query(leftChildIndex, left, middleChildIndex, queryLeft, middleChildIndex);
        E rightResult = query(rightChileIndex, middleChildIndex + 1, right, middleChildIndex + 1, queryRight);
        return treeMerge.merge(leftResult, rightResult);
    }

    /**
     * 更新线段树中某个位置的元素
     *
     * @param index 位置
     * @param element 更新的元素
     */
    public void set(int index, E element) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("数组下标越界");
        }
        data[index] = element;
        set(0, 0, data.length - 1, index, element);
    }

    /**
     * 更新线段树中某个位置的元素
     *
     * @param treeIndex 开始节点
     * @param left 左边界
     * @param right 右边界
     * @param index 位置
     * @param element 更新的元素
     */
    private void set(int treeIndex, int left, int right, int index, E element) {
        if (left == right) {
            tree[treeIndex] = element;
            return;
        }

        int middleChildIndex = left + (right - left) / 2;
        int leftChildIndex = leftChildIndex(treeIndex);
        int rightChileIndex = rightChildIndex(treeIndex);
        if (index >= middleChildIndex + 1) {
            set(rightChileIndex, middleChildIndex + 1, right, index, element);
        } else {
            set(leftChildIndex, left, middleChildIndex, index, element);
        }

        tree[treeIndex] = treeMerge.merge(tree[leftChildIndex], tree[rightChileIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if (i != tree.length - 1) {
                res.append(", ");
            }
        }
        return res.append(']').toString();
    }
}
