/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q10;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<String> listParentPreOrder = new ArrayList<>();
    BSTNode root;
    String result = "";
    
    public BSTree() {
        root = null;
    }

    public String getResult() {
        return result;
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

    private void getNodeParent(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        } else {
            if (currentNode.parent != null) {
                listParentPreOrder.add(currentNode.data + "[" + currentNode.parent.data + "]");
            } else {
                listParentPreOrder.add(currentNode.data + "[null]");
            }
        }
        getNodeParent(currentNode.left);
        getNodeParent(currentNode.right);
    }

    public void getNodeParent() {
        getNodeParent(root);
    }

    public void printParent() {
        getNodeParent();

        for (int i = 0; i < listParentPreOrder.size(); i++) {
            result += listParentPreOrder.get(i) + (i < listParentPreOrder.size() - 1 ? "," : "");
        }

    }
}
