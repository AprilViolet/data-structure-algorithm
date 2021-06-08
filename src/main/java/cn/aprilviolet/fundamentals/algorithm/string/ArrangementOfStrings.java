package cn.aprilviolet.fundamentals.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.28 星期四 22:49
 * @since V1.0.0
 */
public class ArrangementOfStrings {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> containSubCharMap = new HashMap<>(16);
        Map<Character, Integer> windowCharMap = new HashMap<>(16);
        for (int i = 0; i < s1.length(); i++) {
            char currentChar = s1.charAt(i);
            containSubCharMap.put(currentChar, containSubCharMap.getOrDefault(currentChar, 0) + 1);
        }

        // 左右窗口指针
        int left = 0;
        int right = 0;
        // 有效的
        int valid = 0;
        while (right < s2.length()) {
            // 移入窗口的字符
            char currentChar = s2.charAt(right);
            // 右移窗口
            right++;
            if (containSubCharMap.containsKey(currentChar)) {
                windowCharMap.put(currentChar, windowCharMap.getOrDefault(currentChar, 0) + 1);
                if (containSubCharMap.get(currentChar).equals(windowCharMap.get(currentChar))) {
                    valid++;
                }
            }

            // 左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 找到何使字符串
                if (valid == containSubCharMap.size()) {
                    return true;
                }
                // 移除窗口的字符
                char removeChar = s2.charAt(left);
                // 左移窗口
                left++;
                if (containSubCharMap.containsKey(removeChar)) {
                    if (windowCharMap.get(removeChar).equals(containSubCharMap.get(removeChar))) {
                        valid--;
                    }
                    windowCharMap.put(removeChar, windowCharMap.get(removeChar) - 1);
                }
            }
        }

        return false;
    }
}
