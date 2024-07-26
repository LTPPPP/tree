/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q14;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    BSTNode root;
    ArrayList<BSTNode> listSibling = new ArrayList<>();
    ArrayList<BSTNode> listPathNodeSearch = new ArrayList<>();
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

    public BSTNode findNode(int data) {
        listPathNodeSearch.clear();
        BSTNode currentNode = root;
        while (currentNode != null) {
            listPathNodeSearch.add(currentNode);
            if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else if (data > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        listPathNodeSearch.clear();
        return null;
    }

    public BSTNode findSibling(int data) {
        BSTNode current = findNode(data);
        if (current == null) {
            return null;
        }
        BSTNode parent = current.parent;
        if (data < parent.data) {
            return parent.right;
        } else {
            return parent.left;
        }
    }


    public void printSibling() {
            for (int i = 0; i < listSibling.size(); i++) {
                if (listSibling.get(i) != null) {
                  result+= listSibling.get(i).data + (i < listSibling.size() - 1 ? ", " : "");
                } else {
                   result+= "null" + (i < listSibling.size() - 1 ? ", " : "");
                }
            }
    }
}
