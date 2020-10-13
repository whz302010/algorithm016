package AlgorithmExercise.Week1.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 *
 * @author:wuhaizhong
 * @date:2020/9/19
 */
public class TopKFrequent {

    /**
     * 思路：堆
     * 击败了97.74%的用户
     * 
     * 时间复杂度：O(Nlogk)，其中 N 为数组的长度。我们首先遍历原数组，
     * 并使用哈希表记录出现次数，每个元素需要 O(1) 的时间，共需 O(N) 的时间。
     * 随后，我们遍历「出现次数数组」，由于堆的大小至多为 k，
     * 因此每次堆操作需要 O(logk) 的时间，共需 O(Nlogk) 的时间。
     * 二者之和为 O(Nlogk)。
     *
     * 空间复杂度:O(
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length<=0){
            return null;
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.compute(nums[i],(m,v)->v==null?1:++v);
        }
        heap.addAll(map.entrySet());
        int[] res = new int[k];
        for (int i=0;i<k;i++){
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
