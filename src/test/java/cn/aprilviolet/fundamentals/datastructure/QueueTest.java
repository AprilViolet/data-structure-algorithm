package cn.aprilviolet.fundamentals.datastructure;

import cn.aprilviolet.fundamentals.datastructure.queue.ArrayQueue;
import cn.aprilviolet.fundamentals.datastructure.queue.LoopQueue;
import cn.aprilviolet.fundamentals.datastructure.queue.Queue;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 队列的测试
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.29 星期二 21:14
 * @since V1.0.0
 */
@Log4j2
class QueueTest {
    @Test
    @DisplayName(value = "队列测试")
    void queueTest() {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        log.info("ArrayQueue, time: {} ms", time1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        log.info("LoopQueue, time:{} ms", time2);
    }

    private long testQueue(Queue<Integer> q, int opCount){

        long startTime = System.currentTimeMillis();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
