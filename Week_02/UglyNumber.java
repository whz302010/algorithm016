package AlgorithmExercise.Week1.easy;

/**
 * @description
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *  
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 *
 * @author:wuhaizhong
 * @date:2020/9/17
 */
public class UglyNumber {

    /**
     * 动态规划
     * 想不到，先记住方法
     * 思路：最小值乘以2,3,5依次排列
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a = 0 ,b = 0, c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i=1;i<res.length;i++){
            int n1 = res[a] * 2;
            int n3 = res[b] * 3;
            int n5 = res[c] * 5;
            res[i] = Math.min(Math.min(n1,n3),n5);
            if (res[i]==n1){
                a++;
            }
            if (res[i]==n3){
                b++;
            }
            if (res[i]==n5){
                c++;
            }
        }
        return res[n-1];
    }

}
