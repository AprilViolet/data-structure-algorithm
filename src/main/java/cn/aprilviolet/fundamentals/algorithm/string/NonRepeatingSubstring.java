package cn.aprilviolet.fundamentals.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:50
 * @since V1.0.0
 */
public class NonRepeatingSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> windowCharMap = new HashMap<>();
        // 左右窗口指针
        int left = 0;
        int right = 0;
        // 有效的
        int result = 0;

        while (right < s.length()) {
            // 移入窗口的字符
            char currentChar = s.charAt(right);
            // 右移窗口
            right++;
            windowCharMap.put(currentChar, windowCharMap.getOrDefault(currentChar, 0) + 1);

            while (windowCharMap.get(currentChar) > 1) {
                char leftChar = s.charAt(left);
                left++;
                windowCharMap.put(leftChar, windowCharMap.get(leftChar) - 1);
            }
            result = Math.max(result, right - left);
        }

        return result;
    }
}
