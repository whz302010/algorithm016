package AlgorithmExercise.Week1.diffcult;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author:wuhaizhong
 * @date:2020/9/8
 */
public class TwoNum {

    /**
     * 暴力求解 成功击败6.24%的用户
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_violent(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     *hash缓存
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0 ;i< nums.length; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}

