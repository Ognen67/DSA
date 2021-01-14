package com.github.ognen67.exercises.trees;//User function Template for Java

 class Node
 {
     int data;
     Node left, right;

     public Node(int d)
     {
         data = d;
         left = right = null;
     }
 }


class Solution
{
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int K)
    {
        int count=0;
        Node current, pre;

        current = root;
        while(current != null) {
            if(current.left == null) {
                count++;
                if(count == K)
                    return current.data;
                current = current.right;
            }
            else {
                pre = current.left;
                while(pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = current;
                    current = current.left; //priprema za naredni krug
                } else { // znamo da je pre.right ,,dodatni" pokazivac
                    pre.right = null;
                    count++;
                    if(count == K)
                        return current.data; //stampano current jer smo pre vec obisli
                    current = current.right;
                }
            }
        }

        return -1;

    }



}