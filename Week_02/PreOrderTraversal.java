package AlgorithmExercise.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description 二叉树前序排序
 * @author:wuhaizhong
 * @date:2020/9/8
 */
public class PreOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<Integer> res = new LinkedList<>();

    /**
     * 前序遍历，击败100%用户
     * 方法：栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    /**
     * 方法：递归
     * 前序遍历
     *時間複雜度：O(n)
     * 空間複雜度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal2(root.left);
        preorderTraversal2(root.right);
        return res;
    }

}
