package AlgorithmExercise.easy;

import java.util.Arrays;

/**
 * @description
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 *
 * @author:wuhaizhong
 * @date:2020/9/13
 */
public class RotateArray {

    /**
     * 垃圾，循环
     * 击败5.10%
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length<=1 || k==0){
            return;
        }
        for (int j=0;j<k;j++){
            int first =0;
            for (int i=nums.length-1;i>0;i--){
                if (i==nums.length-1){
                    first = nums[i];
                }
                nums[i] = nums[i-1];
            }
            nums[0] = first;
        }

    }


    /**
     * 反转
     * @param nums
     * @param k
     */
    public void rotate_(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

}
