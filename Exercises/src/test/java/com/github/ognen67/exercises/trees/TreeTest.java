package com.github.ognen67.exercises.trees;

import com.github.ognen67.exercises.trees.Tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTest {

    /**
     * Tests that the tree "Hello" -> "Hello Again"
     * can be built
     */
    @Test
    public void createTree() {
        var tree = new Tree<String>();
        TreeNode<String> node = tree.setRootNode("Hello");
        node.addNode("Hello Again");
        var value = List.of(tree.getRootNode().getValue(), tree.getRootNode().getChildren().get(0).getValue());
        assertEquals(List.of("Hello","Hello Again"), value);
    }

    /**
     * Tests that the tree
     *          1
     *         /  \
     *       2     3
     *     /|\     /|\
     *    4 6 8   5 7 1000
     *
     */
    @Test
    public void createMoreAdvancedTree() {
        Tree<Integer> tree = getBasicTree();
        /// Then
        assertNodeEquals(1, tree.getRootNode());
        assertChildrenNodeEquals(List.of(2,3), tree.getRootNode());
        var child2 = tree.getRootNode().getChildren().get(0);
        assertChildrenNodeEquals(List.of(4,6,8), child2);
        var child3 = tree.getRootNode().getChildren().get(1);
        assertChildrenNodeEquals(List.of(5,7,1000), child3);
    }

    /**
     * Builds the tree
     *          1
     *         /  \
     *       2     3
     *     /|\     /|\
     *    4 6 8   5 7 1000
     *
     */
    private Tree<Integer> getBasicTree() {
        var tree = new Tree<Integer>();
        TreeNode<Integer> node = tree.setRootNode(1);
        TreeNode<Integer> node2 = node.addNode(2);
        node2.addNode(4);
        node2.addNode(6);
        node2.addNode(8);
        TreeNode<Integer> node3 = node.addNode(3);
        node3.addNode(5);
        node3.addNode(7);
        node3.addNode(1000);
        return tree;
    }

    private static <T> void assertNodeEquals(T expectedValue, TreeNode<T> node){
        assertEquals(expectedValue, node.getValue());
    }

    private static <T> void assertChildrenNodeEquals(List<T> expectedValue, TreeNode<T> node){
        List<T> result = new ArrayList<>();
        for (TreeNode<T> child : node.getChildren()) {
            result.add(child.getValue());
        }
        assertEquals(expectedValue, result);
    }

    /**
     * For the basicTree we have available at this class we test to iterate it using the DFT algorithm
     */
    @Test
    public void testDFT(){
        var tree = getBasicTree();
        List<Integer> result = tree.depthFirstTraversal();
        List<Integer> expected = List.of(1, 2, 4, 6, 8, 3, 5, 7, 1000);
        assertEquals(expected,result);
    }

}