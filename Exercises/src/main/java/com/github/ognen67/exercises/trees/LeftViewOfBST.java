package com.github.ognen67.exercises.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBST {

    // A Binary Tree node
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    class Tree
    {
        ArrayList<Integer> leftView(Node root)
        {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if (root == null) return result;
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                result.add(queue.peek().data);
                while(size > 0) {
                    Node curr = queue.remove();
                    if(curr.left != null) queue.add(curr.left);
                    if(curr.right != null) queue.add(curr.right);
                    size--;
                }

            }
            return result;
        }
    }
}
