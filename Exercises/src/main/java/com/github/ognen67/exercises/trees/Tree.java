package com.github.ognen67.exercises.trees;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

    private TreeNode<T> rootNode;

    public TreeNode<T> setRootNode(T hello) {
        rootNode = new TreeNode<>(hello);
        return rootNode;
    }

    public TreeNode<T> getRootNode() {
        return rootNode;
    }

    public List<T> depthFirstTraversal() {
        return getRootNode().depthFirstTraversal();
    }

    public static class TreeNode<E> {

        private final E value;
        private final List<TreeNode<E>> childrenNodes = new ArrayList<>();

        public TreeNode(E value) {
            this.value = value;
        }

        public TreeNode<E> addNode(E hello_again) {
            TreeNode<E> node = new TreeNode<>(hello_again);
            childrenNodes.add(node);
            return node;
        }

        public E getValue() {
            return value;
        }

        public List<TreeNode<E>> getChildren() {
            return childrenNodes;
        }

        public List<E> depthFirstTraversal(){
            List<E> result = new ArrayList<>();
            result.add(this.value);
            for (TreeNode<E> childrenNode : this.childrenNodes) {
                result.addAll(childrenNode.depthFirstTraversal());
            }
            return result;
        }
    }
}
