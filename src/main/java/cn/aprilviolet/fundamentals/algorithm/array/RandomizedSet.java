package cn.aprilviolet.fundamentals.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * LeetCode380. 常数时间插入、删除和获取随机元素
 * <a>https://leetcode-cn.com/problems/insert-delete-getrandom-o1/</a>
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.10.29 星期四 21:04
 * @since V1.0.0
 */
public class RandomizedSet {
    /**
     * 用来保证随机获取时候的时间复杂度是O(1)
     */
    private List<Integer> randomList;

    /**
     * hash表，存储值的index的，在插入和删除的时候将值交换到数组的最后，保证操作的时间复杂度是0(1)
     */
    private Map<Integer, Integer> insertRemoveMap;

    /**
     * 随机函数
     */
    private Random random = new Random();

    public RandomizedSet() {
        this.randomList = new ArrayList<>();
        this.insertRemoveMap = new HashMap<>();
    }

    /**
     * 插入操作
     *
     * @param val 插入的值
     * @return true：成功
     *         false：失败
     */
    public boolean insert(int val) {
        if (insertRemoveMap.containsKey(val)) {
            return false;
        }
        randomList.add(randomList.size(), val);
        insertRemoveMap.put(val, randomList.size());
        return true;
    }

    /**
     * 移除操作
     *
     * @param val 移除的值
     * @return true：成功
     *         false：失败
     */
    public boolean remove(int val) {
        if (!insertRemoveMap.containsKey(val)) {
            return false;
        }
        Integer lastValue = randomList.get(randomList.size() - 1);
        Integer valueIndex = insertRemoveMap.get(val);
        randomList.set(valueIndex, lastValue);

        randomList.remove(randomList.size() - 1);
        insertRemoveMap.remove(val);
        return true;
    }

    /**
     * 随机返回一个值
     *
     * @return 随机返回的值
     */
    public int getRandom() {
        return randomList.get(random.nextInt(randomList.size()));
    }
}
