package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.statck.ArrayStack;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

/**
 * 栈的测试
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 21:55
 * @since V1.0.0
 */
@Log4j2
class StackTest {
    @Test
    void stackTest() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
        log.info(stack.toString());
        stack.pop();
        log.info(stack.toString());
    }
}
