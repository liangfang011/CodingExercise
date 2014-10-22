package edu.nyu.liangfang.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class binaryTreeInorderTraversal {
	// Iterative method: always put a node and all his left node into stack, then pop out a node and visit,
	// then continue push all nodes in the left path into stack
	// Just simulate recursion function
	public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> list = new LinkedList<Integer>();
        
        TreeNode node = root;
        while (true) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            
            if (st.isEmpty())
                break;
            
            node = st.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }
}
