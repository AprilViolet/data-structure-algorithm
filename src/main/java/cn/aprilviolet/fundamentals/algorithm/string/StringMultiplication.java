package cn.aprilviolet.fundamentals.algorithm.string;

/**
 * 43. 字符串相乘
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.01.24 星期日 22:39
 * @since V1.0.0
 */
public class StringMultiplication {
    public static final String ZERO_STRING = "0";

    public String multiply(String num1, String num2) {
        if (ZERO_STRING.equals(num1) || ZERO_STRING.equals(num2)) {
            return ZERO_STRING;
        }

        int multiplierLength = num1.length();
        int multiplicandLength = num2.length();
        int[] multiplyResult = new int[multiplierLength + multiplicandLength];

        // 用来存储每一个乘数*被乘数
        for (int i = multiplierLength - 1; i >= 0 ; i--) {
            int tempMultiplier = num1.charAt(i) - '0';
            for (int j = multiplicandLength - 1; j >= 0; j--) {
                int tempMultiplicand = num2.charAt(j) - '0';
                multiplyResult[i + j + 1] += tempMultiplier * tempMultiplicand;
            }
        }

        for (int i = multiplierLength + multiplicandLength - 1; i > 0; i--) {
            multiplyResult[i - 1] += multiplyResult[i] / 10;
            multiplyResult[i] = multiplyResult[i] % 10;
        }

        int index = multiplyResult[0] == 0 ? 1 : 0;
        StringBuilder multiplyResultString = new StringBuilder();
        while (index < multiplierLength + multiplicandLength) {
            multiplyResultString.append(multiplyResult[index]);
            index++;
        }

        return multiplyResultString.toString();
    }
}
