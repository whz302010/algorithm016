package AlgorithmExercise;

/**
 * @description 盛水最多的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 * @author:wuhaizhong
 * @date:2020/9/12
 */
public class MaxAreaContainer {

    /**
     * 暴力求解
     * 牛逼，打败了5%的用户！
     * @param height
     * @return
     */
    public int maxArea_violent(int[] height) {
        int maxArea =0;
        for (int i=0;i<height.length-1;i++){
            for (int j=1;j<height.length;j++){
                maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxArea;
    }


    /**
     * 双指针求解
     * 打败了67.76%
     * @param height
     * @return
     */
    public int maxArea_double_pointer(int[] height){
        int maxArea = 0;
        for (int i=0,j=height.length-1;i!=j;){
            maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }

    /**
     * 稍加优化  92.82%
     * @param height
     * @return
     */
    public int maxArea_double_pointer_better(int[] height){
        int maxArea = 0;
        int i=0,j=height.length-1;
        while (i<j){
            int width = j-i;
            maxArea = height[i] <height[j]?
                    Math.max(maxArea,height[i++]*width):Math.max(maxArea,height[j--]*width);
        }
        return maxArea;
    }
}
