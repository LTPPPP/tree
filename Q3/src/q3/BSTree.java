/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3;


/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    BSTNode root;
    String traversalResult;

    public BSTree() {
        root = null;
    }
     public String getTraversalResult() {
        return traversalResult;
    }

    public void addNode(int data) {
        if (root == null) {
            root = new BSTNode(data);
        } else {
            boolean isAdded = false;
            BSTNode currentNode = root;
            while (!isAdded) {
                if (data < currentNode.data) {
                    if (currentNode.hasLeftChild()) {
                        currentNode = currentNode.left;
                    } else {
                        currentNode.setLeft(new BSTNode(data));
                        isAdded = true;
                    }
                } else if (data > currentNode.data) {
                    if (currentNode.hasRightChild()) {
                        currentNode = currentNode.right;
                    } else {
                        currentNode.setRight(new BSTNode(data));
                        isAdded = true;
                    }
                } else {
                    currentNode.count = currentNode.count + 1;
                    isAdded = true;
                }
            }
        }

    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(BSTNode node) {
        if (node == null) {
            return 0;
        }
        if (node.isLeaf()) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public String printLeaves() {
        StringBuilder sb = new StringBuilder();
        printLeaves(root, sb);
        return sb.toString();
    }

    private void printLeaves(BSTNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            sb.append(node.data).append(",");
        }
        printLeaves(node.left, sb);
        printLeaves(node.right, sb);
    }
   
}
