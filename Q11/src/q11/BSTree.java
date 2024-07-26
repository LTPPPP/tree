/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q11;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<String> listHighPreOrder = new ArrayList<>();
    BSTNode root;

    public BSTree() {
        root = null;
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
                    //"have no duplicate values"
                    //currentNode.count = currentNode.count + 1;
                    isAdded = true;
                }
            }
        }
    }

    public int height(int data) {
        return height(root, data);
    }

    private int height(BSTNode current, int data) {
        if (current == null || current.isLeaf()) {
            return 0;
        }
        if (current.data == data) {
            int hLeft = 0, hRight = 0;
            if (current.hasLeftChild()) {
                hLeft = height(current.left, current.left.data);
            }
            if (current.hasRightChild()) {
                hRight = height(current.right, current.right.data);
            }
            return 1 + Math.max(hLeft, hRight);
        } else if (data < current.data) {
            return height(current.left, data);
        } else {
            return height(current.right, data);
        }
    }

    private void heightAllNode(BSTNode current) {
        if (current == null) {
            return;
        }
        listHighPreOrder.add(current.data + "[" + height(current.data) + "]");
        heightAllNode(current.left);
        heightAllNode(current.right);
    }

    public String heightAllNode() {
        String str= "";
        listHighPreOrder.clear();
        heightAllNode(root);

        for (int i = 0; i < listHighPreOrder.size(); i++) {
            str += listHighPreOrder.get(i) + (i < listHighPreOrder.size() - 1 ? "," : "");
        }
        return str;
    }
}
