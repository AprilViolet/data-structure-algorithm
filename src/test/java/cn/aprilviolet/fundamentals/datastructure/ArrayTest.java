package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.array.Array;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 数组的测试类
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.22 星期二 23:41
 * @since V1.0.0
 */
@Log4j2
class ArrayTest {
    @Test
    @DisplayName(value = "数组测试")
    void baseArrayTest() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        log.info(arr);

        arr.add(1, 100);
        log.info(arr);

        arr.addFirst(-1);
        log.info(arr);

        arr.remove(2);
        log.info(arr);

        arr.removeElement(4);
        log.info(arr);

        arr.removeFirst();
        log.info(arr);

        arr.remove(2);
        log.info(arr);

        arr.remove(3);
        log.info(arr);

        arr.removeLast();
        log.info(arr);
    }
}
