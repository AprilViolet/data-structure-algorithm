package cn.aprilviolet.fundamentals.algorithm.array;

import lombok.extern.log4j.Log4j2;

import java.util.Arrays;

/**
 * 去除数组中的重复项
 * 用到的快慢指针，避免在数组中间删除元素
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.29 星期二 23:14
 * @since V1.0.0
 */
@Log4j2
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 5, 10, 12};
        log.info(removeDuplicates(nums));
        log.info(Arrays.toString(nums));
    }

    /**
     * 去除有序数组中重复的元素
     *
     * @param nums 有序数组
     * @return 去重后的元素个数
     */
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;

        while (fast < length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                    nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
