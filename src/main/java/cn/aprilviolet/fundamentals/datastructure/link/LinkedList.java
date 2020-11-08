package cn.aprilviolet.fundamentals.datastructure.link;

/**
 * 链表
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.11 星期日 19:34
 * @since V1.0.0
 */
public class LinkedList<E> {
    /**
     * 链表的头节点
     */
    private Node dummyHead;

    /**
     * 链表的长度
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表的长度
     *
     * @return 链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return true:链表为空
     *         false:链表不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在某个位置添加元素
     *
     * @param index 添加的下标位置
     * @param e 添加的元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，下标移除");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表的头添加元素
     *
     * @param e 添加的元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表的结尾添加元素
     *
     * @param e 添加的元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取下标位置的元素
     *
     * @param index 下标位置
     * @return 下标位置相应的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，下标异常");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    /**
     * 获取首位的元素
     *
     * @return 首位元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取结尾的元素
     *
     * @return 末尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 从链表中删除index位置的元素, 返回删除的元素
     *
     * @param index 删除的下标
     * @return 被删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，下标溢出");
        }

        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node needRemoveNode = preNode.next;
        preNode.next = needRemoveNode.next;
        needRemoveNode.next = null;
        size--;

        return needRemoveNode.e;
    }

    /**
     * 移除首位元素
     *
     * @return 移除的首位元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除末尾元素
     *
     * @return 末尾元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素为e
     *
     * @param index 下标位置
     * @param e 修改后的元素的值
     */
    public void set(int index, E e){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("设置失败，下标移除");
        }

        Node current = dummyHead.next;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        current.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e 是否包含的元素
     * @return true:包含
     *         false:不包含
     */
    public boolean contains(E e){
        Node current = dummyHead.next;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current).append("->");
            current = current.next;
        }
        res.append("NULL");

        return res.toString();
    }

    /**
     * 链表的内部节点类
     */
    private class Node {
        /**
         * 节点的值
         */
        private E e;

        /**
         * 下一个节点
         */
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
