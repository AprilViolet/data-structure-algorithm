package cn.aprilviolet.fundamentals.algorithm.string;

/**
 * 5. 最长回文子串
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.24 星期日 22:34
 * @since V1.0.0
 */
public class LongestPalindromeSubstring {
    /**
     * 中心扩散方法
     *
     * @param s 原始字符串
     * @return 最长回文字符串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int maxSizeOdd = expandAroundCenter(s, i, i);
            int maxSizeEvent = expandAroundCenter(s, i, i + 1);
            int maxSize = Math.max(maxSizeOdd, maxSizeEvent);
            if (maxSize > endIndex - startIndex) {
                startIndex = i - (maxSize - 1) / 2;
                endIndex = i + maxSize / 2;
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private int expandAroundCenter(String originalStr, int left, int right) {
        while (left >= 0 && right < originalStr.length() && originalStr.charAt(left) == originalStr.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public String longestPalindromeTwo(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        // 保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 把回文看成中间的部分全是同一字符，左右部分相对称
            // 找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        // 查找中间部分
        // 也就是将abcccbd中的ccc看成一个整体
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        // 定位中间部分的最后一个字符
        int ans = high;
        // 从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        // 记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        // 直接跳过中间的部分，精髓！
        return ans;
    }
}
