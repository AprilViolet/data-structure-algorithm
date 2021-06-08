package cn.aprilviolet.fundamentals.algorithm.other;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * @author AprilViolet
 * @version V1.0.0
 * @date 2021.02.04 星期四 22:35
 * @since V1.0.0
 */
public class NumberOfOccurrences {
    public int[] singleNumbers(int[] nums) {
        // 用于记录 A B 的异或结果
        int x = 0;

        // 得到A^B的结果
        // 基于异或运算的以下几个性质
        // 1.交换律
        // 2.结合律 （即(a^b)^c == a^(b^c)）
        // 3.对于任何数x，都有x^x=0，x^0=x
        // 4.自反性 A XOR B XOR B = A xor 0 = A ---> A XOR B = C 则 C XOR B = A
        for (int val : nums) {
            x ^= val;
        }

        // x & (-x)本身的作用是得到最低位置的1，
        int flag = x & (-x);
        // 而我们所需要的做到的是：利用这个1来进行分组，也就是做到将A和B区分开
        // 前面已经知道，x是我们需要的结果数A和B相异或的结果，也就是说，x的二进制串上的任何一个1，都能成为区分A和B的条件
        // 因此我们只需要得到x上的任意一个1，就可以做到将A和B区分开来

        // 用于记录A或B其中一者
        int res = 0;

        // 分组操作
        for (int val : nums) {
            // 根据二进制位上的那个“1”进行分组
            // 可分为两组，一组为与flag相与等于1的[10]，另一组为0的[1,2,4,1,4,3,3]
            // 需要注意的是，分组的结果必然是相同的数在相同的组，且还有一个结果数
            // 即使有多个不为0的在同一组，也是双数的，多次XOR也会只剩下不同的结果
            // 因此每组的数再与res=0一路异或下去，最终会得到那个结果数A或B
            // 且由于异或运算具有自反性，因此只需得到其中一个数即可
            if ((flag & val) != 0) {
                res ^= val;
            }
        }
        // 利用先前的x进行异或运算得到另一个，即利用自反性
        return new int[] {res, x ^ res};
    }
}
