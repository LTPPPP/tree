/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q7;

/**
 *
 * @author Vo Hoang Tu - CE000000
 */
public class BSTree {

    BSTNode root;

    String resultFindNode = "";

    public BSTree() {
        this.root = null;
    }

    public void addNode(int data) {
        if (this.root == null) {
            root = new BSTNode(data);
        } else {
            BSTNode currentNode = root;
            boolean isAdded = false;
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
//                    currentNode.count = currentNode.count + 1;
                    isAdded = true;
                }
            }
        }
    }


    public String getResultFindNode() {
        return resultFindNode;
    }
    
    

    public BSTNode findNode(int searchkey) {
        BSTNode currentNode = root;
        while (currentNode != null) {
            resultFindNode += "->" + currentNode.data;
            if (searchkey < currentNode.data) {
                currentNode = currentNode.left;
            } else if (searchkey > currentNode.data) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        resultFindNode = "  No";
        return null;
    }

    public void searching() {
        String str;
        if (resultFindNode != null) {
            resultFindNode =  resultFindNode.substring(2) + "\r\n";
        } else {
            resultFindNode = "";
        }
       
    }
}
