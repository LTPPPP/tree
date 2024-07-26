/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q9;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<BSTNode> listPreOrder = new ArrayList<>();
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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        //Gốc (root)
        listPreOrder.add(currentNode);
        //Trái (left)
        preOrder(currentNode.left);
        //Phải (right)
        preOrder(currentNode.right);
    }

    public void readDataFile(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner sc = new Scanner(inputFile);
            int n = sc.nextInt();
            int data;
            for (int i = 0; i < n; i++) {
                data = sc.nextInt();
                addNode(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String printLevel() {
        listPreOrder.clear();
        String str = "";
        preOrder();

        for (int i = 0; i < listPreOrder.size(); i++) {
            str += listPreOrder.get(i).data + "[" + listPreOrder.get(i).level + "]" + (i < listPreOrder.size() - 1 ? "," : "");
        }
        return str;
    }
}
