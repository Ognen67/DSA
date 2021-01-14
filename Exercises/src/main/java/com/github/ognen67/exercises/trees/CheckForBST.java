package com.github.ognen67.exercises.trees;

import java.util.Stack;

public class CheckForBST {

    //User function Template for Java

    class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        }
    }

    public class Tree
    {
        // return true if the given tree is a BST, else return false
        boolean isBST(Node root) {
            Node curr = root;
            Node prev = null;
            Stack<Node> stack = new Stack<>();

            while(!stack.isEmpty() || curr != null) {
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (prev != null && curr.data <= prev.data) return false;
                else prev = curr;

                curr = curr.right;
            }
            return true;
        }
    }

}
