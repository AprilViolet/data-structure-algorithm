package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.link.LinkedList;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 链表的测试
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.11 星期日 20:31
 * @since V1.0.0
 */
@Log4j2
class LinkedListTest {
    @Test
    @DisplayName("链表测试")
    void linkedListTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            log.info(linkedList);
        }

        linkedList.add(2, 666);
        log.info(linkedList);

        linkedList.remove(2);
        log.info(linkedList);
        linkedList.removeFirst();
        log.info(linkedList);
    }
}
