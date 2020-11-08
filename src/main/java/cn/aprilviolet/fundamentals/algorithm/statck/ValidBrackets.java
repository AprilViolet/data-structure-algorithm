package cn.aprilviolet.fundamentals.algorithm.statck;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LeetCode 20.有效的括号
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2020.09.24 星期四 22:12
 * @since V1.0.0
 */
public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]{}"));
        System.out.println(isValid("([)]{}"));
        System.out.println(isValid("([}}])"));
        System.out.println(isValid("{[]})[]"));
    }

    /**
     * 校验有效括号
     *
     * @param checkStr 需要校验的字符串
     * @return true：有效      false：无效
     */
    public static boolean isValid(String checkStr) {
        if (checkStr.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> bracketMap = new HashMap<>(16);
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');
        Deque<Character> bracketStack = new LinkedList<>();
        for (char check : checkStr.toCharArray()) {
            if (bracketMap.containsKey(check)) {
                if (bracketStack.isEmpty() || !bracketStack.peek().equals(bracketMap.get(check))) {
                    return false;
                }
                bracketStack.pop();
            } else  {
                bracketStack.push(check);
            }
        }
        return bracketStack.isEmpty();
    }
}
