package cn.aprilviolet.fundamentals.datastructure.statck;

/**
 * 栈的接口
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 21:37
 * @since V1.0.0
 */
public interface Stack<E> {
    /**
     * 返回栈中的数据个数
     *
     * @return 数据个数
     */
    int getSize();

    /**
     * 判断栈是否为空
     *
     * @return true：为空      false：不为空
     */
    boolean isEmpty();

    /**
     * 往栈中添加数据
     *
     * @param element 添加的元素
     */
    void push(E element);

    /**
     * 从栈中出栈
     *
     * @return 出栈的元素
     */
    E pop();

    /**
     * 查看栈顶的元素
     *
     * @return 栈顶的元素
     */
    E peek();
}
