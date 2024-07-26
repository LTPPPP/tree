/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q5;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<BSTNode> listOneChildNode = new ArrayList<>();
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

    private void findOneChildNode(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.hasOneChild()) {
            listOneChildNode.add(node);
        }
        findOneChildNode(node.left);
        findOneChildNode(node.right);
    }

    public String findOneChildNode() {
        String str = "";
        listOneChildNode.clear();
        findOneChildNode(root);

        for (int i = 0; i < listOneChildNode.size(); i++) {
            str += listOneChildNode.get(i).data + (i < listOneChildNode.size() - 1 ? "," : "");
        }
        return str;
    }

}
