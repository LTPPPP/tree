/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q12;

import java.util.ArrayList;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<BSTNode> listNode = new ArrayList<>();
    ArrayList<BSTNode> listPreOrder = new ArrayList<>();
    ArrayList<BSTNode> listPostOrder = new ArrayList<>();
    ArrayList<BSTNode> listInOrder = new ArrayList<>();
    BSTNode root;
    String result="";

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

    public void preOrder() {
        listPreOrder.clear();
        preOrder(root);
    }

    private void preOrder(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        listPreOrder.add(currentNode);
        preOrder(currentNode.left);
        preOrder(currentNode.right);
    }

    public void posOrder() {
        listPostOrder.clear();
        posOrder(root);
    }

    private void posOrder(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        posOrder(currentNode.left);
        posOrder(currentNode.right);

        listPostOrder.add(currentNode);
    }

    public void inOrder() {
        listInOrder.clear();
        inOrder(root);
    }

    private void inOrder(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        inOrder(currentNode.left);

        listInOrder.add(currentNode);
        inOrder(currentNode.right);
    }

    public void BSTBalanceArray() {
        listNode.clear();
        BSTBalanceArray(root);
    }

    private void BSTBalanceArray(BSTNode current) {
        if (current == null) {
            return;
        }
        BSTBalanceArray(current.left);
        listNode.add(current);
        BSTBalanceArray(current.right);
    }

    public void balance() {
        BSTBalanceArray();
        this.root = null;
        balance(0, listNode.size() - 1);
    }

    private void balance(int L, int R) {
        if (L > R) {
            return;
        }
        int m = (L + R) / 2;
        addNode(listNode.get(m).data);
        balance(L, m - 1);
        balance(m + 1, R);
    }

    public void resultBalancing() {
        listPreOrder.clear();
        listPostOrder.clear();
        listInOrder.clear();
        this.preOrder();
        this.posOrder();
        this.inOrder();
        for (int i = 0; i < listPreOrder.size(); i++) {
            result += listPreOrder.get(i).data + (i < listPreOrder.size() - 1 ? "," : "\n");
        }
        for (int i = 0; i < listPostOrder.size(); i++) {
            result += listPostOrder.get(i).data + (i < listPostOrder.size() - 1 ? "," : "\n");
        }
        for (int i = 0; i < listInOrder.size(); i++) {
            result += listInOrder.get(i).data + (i < listInOrder.size() - 1 ? "," : "\n");
        }
    }
}
