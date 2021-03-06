package AlgorithmExercise.Week4.difficult;

/**
 * @description
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:wuhaizhong
 * @date:2020/10/13
 */
public class JumpGame2 {

    /**
     * 思路：貪心算法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int postion = nums.length-1;
        int steps = 0;
        while (postion>0){
            for (int i=0;i<nums.length;i++){
                if (i+nums[i]>=postion){
                    steps++;
                    postion = i;
                    break;
                }
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        jumpGame2.jump(new int[]{1,2,1,1,1});
    }

}
