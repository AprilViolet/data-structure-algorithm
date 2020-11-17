package cn.aprilviolet.fundamentals.algorithm.array;

/**
 * LeetCode 922. 按奇偶排序数组 II
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.11.14 星期六 00:04
 * @since V1.0.0
 */
public class ParitySort {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if ((A[i] & 1) != 0) {
                while ((A[j] & 1) != 0) {
                    j += 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
