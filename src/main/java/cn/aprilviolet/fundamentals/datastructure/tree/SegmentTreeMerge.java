package cn.aprilviolet.fundamentals.datastructure.tree;

/**
 * 线段树堆每一段的操作接口
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.17 星期六 16:27
 * @since V1.0.0
 */
public interface SegmentTreeMerge<E> {
    E merge(E left, E right);
}
