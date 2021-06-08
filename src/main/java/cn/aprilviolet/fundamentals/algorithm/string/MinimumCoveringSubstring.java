package cn.aprilviolet.fundamentals.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:49
 * @since V1.0.0
 */
public class MinimumCoveringSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> containSubCharMap = new HashMap<>(16);
        Map<Character, Integer> windowCharMap = new HashMap<>(16);
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            containSubCharMap.put(currentChar, containSubCharMap.getOrDefault(currentChar, 0) + 1);
        }

        // 左右窗口指针
        int left = 0;
        int right = 0;
        // 有效的
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int startIndex = 0;
        int lengthIndex = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 移入窗口的字符
            char currentChar = s.charAt(right);
            // 右移窗口
            right++;
            if (containSubCharMap.containsKey(currentChar)) {
                windowCharMap.put(currentChar, windowCharMap.getOrDefault(currentChar, 0) + 1);
                if (containSubCharMap.get(currentChar).equals(windowCharMap.get(currentChar))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否需要收缩
            while (valid == containSubCharMap.size()) {
                // 更新最小子串
                if (right - left < lengthIndex) {
                    startIndex = left;
                    lengthIndex = right - left;
                }
                // 移除窗口的字符
                char removeChar = s.charAt(left);
                // 左移窗口
                left++;
                // 窗口内数据的更新
                if (containSubCharMap.containsKey(removeChar)) {
                    if (windowCharMap.get(removeChar).equals(containSubCharMap.get(removeChar))) {
                        valid--;
                    }
                    windowCharMap.put(removeChar, windowCharMap.get(removeChar) - 1);
                }
            }
        }

        return lengthIndex == Integer.MAX_VALUE? "" : s.substring(startIndex, startIndex + lengthIndex);
    }
}
