package cn.aprilviolet.fundamentals.datastructure.array;

/**
 * 自定义的数组
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.22 星期二 23:11
 * @since V1.0.0
 */
public class Array<E> {
    /**
     * 数组中的元素
     */
    private E[] data;

    /**
     * 数组中数据的个数
     */
    private int size;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 往数组的特定位置增加元素
     *
     * @param index   数组下标
     * @param element 增加的元素
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("增加失败，请检查参数");
        }

        if (size == data.length) {
            resize(data.length * 2);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * 往数组最尾部添加一个元素
     *
     * @param element 添加的数据
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 往数组头部添加一个元素
     *
     * @param element 添加的数据
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index 需要删除的数据的索引
     * @return 被删除的数据
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败，请检查索引下标");
        }

        E element = data[index];
        if (index != size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index + 1);
        }
        size--;
        // 帮助GC
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return element;
    }

    /**
     * 从数组中删除元素e
     *
     * @param element 需要删除的数据
     */
    public void removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return 被删除的数据
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return 被删除的数据
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 修改某下标下的数据
     *
     * @param index   下标索引
     * @param element 数据
     */
    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败，请检查索引下标");
        }

        data[index] = element;
    }

    /**
     * 获取某下标的数据
     *
     * @param index 下标索引
     * @return 下标索引的数据
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("修改失败，请检查索引下标");
        }
        return data[index];
    }

    /**
     * 获取数组第一个元素
     *
     * @return 数组第一个元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取最后的元素
     *
     * @return 最后的元素的值
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 返回数组中的元素的个数
     *
     * @return 数组中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return 数组容量大小
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 查找数组中是否有相应的数据
     *
     * @param element 需要查找的数据
     * @return true：有相应数据       false：没有相应数据
     */
    public boolean contains(E element) {
        for (E value : data) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素所在的下标
     *
     * @param element 查找的数据
     * @return 数据所在下标，如果没有1则返回-1
     */
    public int find(E element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 判断数组是否为空
     *
     * @return true：为空      false：不为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 将数组进行扩容
     *
     * @param newCapacity 扩容后的大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("数组: 个数 = %d , 容量 = %d%n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
