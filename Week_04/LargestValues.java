package AlgorithmExercise.Week4.middle;

import java.util.*;

/**
 * @description
 *
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 *
 * @author:wuhaizhong
 * @date:2020/10/7
 */
public class LargestValues {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * 思路:广度优先
     * 43.44%
     * 空间复杂度：O(logn)
     * 时间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            while (size>0){
                size--;
                TreeNode node = queue.poll();
                maxValue = Math.max(maxValue,node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(maxValue);
        }
        return res;
    }


    /**
     * dfs
     * @param root
     * @return
     */
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        if (root==null){
            return res;
        }
        dfs(res,root,0);
        return res;
    }

    public void dfs(List<Integer> res ,TreeNode node,int level){
        if (res.size()<level+1){
            res.add(level,node.val);
        }else {
            res.set(level,Math.max(node.val,res.get(level)));
        }
        if (node.left!=null){
            dfs(res,node.left,level+1);
        }
        if (node.right!=null){
            dfs(res,node.right,level+1);
        }
    }

}
