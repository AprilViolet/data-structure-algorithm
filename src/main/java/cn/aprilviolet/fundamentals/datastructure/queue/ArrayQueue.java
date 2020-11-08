package cn.aprilviolet.fundamentals.datastructure.queue;

import cn.aprilviolet.fundamentals.datastructure.array.Array;

/**
 * 数组实现的队列
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 23:08
 * @since V1.0.0
 */
public class ArrayQueue<E> implements Queue<E> {
    /**
     * 队列的内部数组
     */
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    /**
     * 返回队列的个数
     * @return 队列个数
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 判断队列是否为空
     *
     * @return true：为空      false：不为空
     */
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    /**
     * 获取队列容量
     *
     * @return 队列容量个数
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * 入队
     *
     * @param element 入队元素
     */
    @Override
    public void enqueue(E element){
        array.addLast(element);
    }

    /**
     * 出队
     *
     * @return 出对元素
     */
    @Override
    public E dequeue(){
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     *
     * @return 队首元素
     */
    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
