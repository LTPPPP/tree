/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q15;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

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

    public boolean isFullTree(BSTNode node) {
        if (node == null) {
            return true;
        }
        if (!node.hasLeftChild() && !node.hasRightChild()) { //Kiểm tra xem nếu không có con thì cũng tính là full tree
            return true;
        }
        if (node.hasLeftChild() && node.hasRightChild()) { //Nếu có thì tiếp tục chạy qua trái và phải để kiểm tra nhue trên
            return (isFullTree(node.left) && isFullTree(node.right));
        }
        return false;
    }


    public String fullBinary() {
        String str="";
      
            if (isFullTree(root)) {
               str = "Yes";
            } else {
               str ="No";
            }
            return str;
        
    }
}
