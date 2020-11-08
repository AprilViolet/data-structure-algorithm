package cn.aprilviolet.fundamentals.datastructure.statck;

import cn.aprilviolet.fundamentals.datastructure.array.Array;

/**
 * 数组实现的栈
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 21:47
 * @since V1.0.0
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 栈的内部数组
     */
    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    /**
     * 返回栈中的数据个数
     *
     * @return 数据个数
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断栈是否为空
     *
     * @return true：为空      false：不为空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 往栈中添加数据
     *
     * @param element 添加的元素
     */
    @Override
    public void push(E element) {
        array.addLast(element);
    }

    /**
     * 从栈中出栈
     *
     * @return 出栈的元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶的元素
     *
     * @return 栈顶的元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
