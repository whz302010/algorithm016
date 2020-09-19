package AlgorithmExercise.diffcult;

import java.util.*;

/**
 * @description
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * @author:wuhaizhong
 * @date:2020/9/17
 */
public class PreOrderNTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    static List<Integer> res = new ArrayList<>();
    /**
     * 递归，96.66% 的用户
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root==null){
            return res;
        }
        res.add(root.val);
        if (root.children!=null){
            for (Node n: root.children){
                preorder(n);
            }
        }
        return res;
    }



    /**
     * 迭代
     * 使用栈来模拟递归，击败38.18%
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public static List<Integer> preorder2(Node root) {
        if (root == null){
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            if (node.children!=null){
                List<Node> children = node.children;
                Collections.reverse(children);
                for (Node n :node.children){
                    stack.push(n);
                }
            }
        }
        return res;
    }


}
