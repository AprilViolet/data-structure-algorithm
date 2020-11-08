package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.tree.SegmentTree;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 线段树的测试
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.17 星期六 16:31
 * @since V1.0.0
 */
@Log4j2
class SegmentTreeTest {
    @Test
    @DisplayName(value = "线段树测试")
    void segmentTreeTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        log.info("线段树:{}", segmentTree);

        log.info("区间内的值:{}", segmentTree.query(0,2));
        log.info("区间内的值:{}", segmentTree.query(2,5));
        log.info("区间内的值:{}", segmentTree.query(0,5));

        segmentTree.set(1, 2);
        log.info("线段树:{}", segmentTree);
        log.info("区间内的值:{}", segmentTree.query(0,2));
    }
}
