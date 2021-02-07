package com.github.ognen67.exercises.trees;

public class BST {

    private TreeNode root;

    public void addNode(int value) {
        TreeNode ins = new TreeNode(value);
        if (root == null) {
            root = ins;
        } else {
            TreeNode curr = root;
            TreeNode parent;
            while (true) {
                parent = curr;
                if (value < curr.value) {
                    curr = curr.leftChild;
                    if (curr == null) {
                        parent.leftChild = ins;
                        return;
                    }
                } else {
                    curr = curr.rightChild;
                    if (curr == null) {
                        parent.rightChild = ins;
                        return;
                    }
                }
            }
        }
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.leftChild);
            System.out.println(node);
            inorderTraversal(node.rightChild);
        }
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.addNode(4);
        tree.addNode(6);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(1);
        tree.addNode(7);
        tree.addNode(5);

        tree.inorderTraversal();
    }
}

class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
