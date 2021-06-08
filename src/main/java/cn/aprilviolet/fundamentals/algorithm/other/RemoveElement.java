package cn.aprilviolet.fundamentals.algorithm.other;

/**
 * 27. 移除元素
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:51
 * @since V1.0.0
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
