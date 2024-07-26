/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    ArrayList<BSTNode> listTwoChildNode = new ArrayList<>();
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

    private void findTwoChildNode(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.hasTwoChild()) {
            listTwoChildNode.add(node);
        }
        findTwoChildNode(node.left);
        findTwoChildNode(node.right);
    }

    public String findTwoChildNode() {
        String str = "";
        listTwoChildNode.clear();
        findTwoChildNode(root);

        for (int i = 0; i < listTwoChildNode.size(); i++) {

            str += listTwoChildNode.get(i).data + (i < listTwoChildNode.size() - 1 ? "," : "");
        }
        return str;
    }
}
