/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q4;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<BSTNode> listInsideNode = new ArrayList<>();
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

    private void findInsideNode(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.isInside()) {
            listInsideNode.add(node);
        }
        findInsideNode(node.left);
        findInsideNode(node.right);
    }

    public String findInsideNode() {
        String str = "";
        listInsideNode.clear();
        findInsideNode(root);

        for (int i = 0; i < listInsideNode.size(); i++) {
            str += listInsideNode.get(i).data + (i < listInsideNode.size() - 1 ? "," : "");
        }
        return str;
    }
}
