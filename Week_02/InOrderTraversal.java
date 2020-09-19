package AlgorithmExercise.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:wuhaizhong
 * @date:2020/9/15
 */
public class InOrderTraversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

    ArrayList<Integer> res = new ArrayList<>();

    /**
     * 递归方法  击败100%用户
     * 时间复杂度：O(n)
     * 空间复杂度：O(log2n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }


    /**
     * 迭代方法
     * 思路，用栈模拟递归
     * 时间复杂度：
     * 空间复杂度：
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root==null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null&&!stack.isEmpty()){
            while (root!=null){
                stack.push(root.left);
                root = root.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            root = root.right;
        }
        return res;
    }


//    public List<Integer> inorderTraversal_2(TreeNode root) {
//        Deque<Integer> res = new LinkedList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode pop = stack.pop();
//            res.add(pop.val);
//            if (pop.left!=null){
//                stack.addLast(root.left);
//            }
//            stack.addLast(pop);
//            if (pop.right!=null){
//                stack.addLast(root.right);
//            }
//        }
//        return (List<Integer>) res;
//    }
}
