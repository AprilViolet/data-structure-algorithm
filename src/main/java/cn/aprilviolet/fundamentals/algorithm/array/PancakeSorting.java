package cn.aprilviolet.fundamentals.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 969. 煎饼排序
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.24 星期日 22:38
 * @since V1.0.0
 */
public class PancakeSorting {
    List<Integer> sort = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        // 每一次都找到最大值，翻动到顶部，然后整体翻动，每执行一次循环，就排好了一个
        sort(arr, arr.length);
        return sort;
    }

    private void sort(int[] cakes, int length) {
        if (length <= 1) {
            return;
        }
        // 找到每次的最大值
        int maxElement = cakes[0];
        int maxElementIndex = 0;
        for (int i = 0; i < length; i++) {
            if (cakes[i] > maxElement) {
                maxElement = cakes[i];
                maxElementIndex = i;
            }
        }

        // 第一次翻转，将最大值翻转到最上面
        reverse(cakes, 0, maxElementIndex);
        sort.add(maxElementIndex + 1);
        // 第二次翻转，将最大值翻转到下面
        reverse(cakes, 0, length - 1);
        sort.add(length);

        sort(cakes, length - 1);
    }

    private void reverse(int[] cakes, int startIndex, int maxElementIndex) {
        while (startIndex < maxElementIndex) {
            int tempElement = cakes[startIndex];
            cakes[startIndex] = cakes[maxElementIndex];
            cakes[maxElementIndex] = tempElement;
            startIndex++;
            maxElementIndex--;
        }
    }
}
