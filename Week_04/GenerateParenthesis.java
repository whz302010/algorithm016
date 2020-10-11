package AlgorithmExercise.Week4.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:wuhaizhong
 * @date:2020/10/7
 */
public class GenerateParenthesis {

    /**
     * 思路：回溯，左括号或者右括号
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        geneRate(res,0, 0,n,"");
        return res;
    }

    private void geneRate(List<String> res, int left , int right, int max ,String parenth){
        if (left==max && right ==max){
            res.add(parenth);
            return;
        }
        //左括号随时可以加
        if (left<max)
            geneRate(res,left+1,right,max,parenth+"(");
        //左括号数大于右括号可以加右括号
        if (left>right)
            geneRate(res,left,right+1, max,parenth+")");
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
    }
}
