package cn.aprilviolet.fundamentals.datastructure.queue;

/**
 * 循环队列，优化出队的时间复杂度
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 23:13
 * @since V1.0.0
 */
public class LoopQueue<E> implements Queue<E> {
    /**
     * 队列数组
     */
    private E[] data;

    /**
     * 头部指针
     */
    private int front;

    /**
     * 尾部指针
     */
    private int tail;

    /**
     * 容量大小
     */
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    /**
     * 返回队列的个数
     * @return 队列个数
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return true：为空      false：不为空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    /**
     * 入队操作
     *
     * @param element 入队元素
     */
    @Override
    public void enqueue(E element) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (++tail) % data.length;
        size++;
    }

    /**
     * 出队操作
     *
     * @return 出队的元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列不能为空");
        }

        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return element;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列不能为空");
        }
        return data[front];
    }

    /**
     * 进行扩容缩容操作
     *
     * @param newCapacity 扩容缩容后的大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        result.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            result.append(data[i]);
            if ((i + 1) % data.length != tail) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
