package cn.aprilviolet.fundamentals.datastructure.queue;

/**
 * 队列的接口
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 23:05
 * @since V1.0.0
 */
public interface Queue<E> {
    /**
     * 返回队列的个数
     * @return 队列个数
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return true：为空      false：不为空
     */
    boolean isEmpty();

    /**
     * 入队
     *
     * @param element 入队元素
     */
    void enqueue(E element);

    /**
     * 出队
     *
     * @return 出对元素
     */
    E dequeue();

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    E getFront();
}
