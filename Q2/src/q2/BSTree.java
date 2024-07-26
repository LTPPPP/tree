/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;


/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    BSTNode root;
    String result = "";
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;

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
                    currentNode.count = currentNode.count + 1;
                    isAdded = true;
                }
            }
        }
    }

   private void preOrder(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        result += "," + currentNode.data;
        count1++;
        preOrder(currentNode.left);
        preOrder(currentNode.right);
    }

    public String getResult() {
        return result;
    }
    

    public void preOrder() {
        preOrder(root);
    }

    private void postOrder(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        postOrder(currentNode.left);
        postOrder(currentNode.right);
        if (count2 == 0) {
            result += "\n";
            result += currentNode.data;
        } else {
            result += "," + currentNode.data;
        }

        count2++;
    }

    public void postOrder() {
        postOrder(root);
    }

    public BSTNode remove(BSTNode node, int elem) {
        if (node == null) {
            return node;
        }

        if (elem > node.data) {
            node.right = remove(node.right, elem);
        } else if (elem < node.data) {
            node.left = remove(node.left, elem);
        } else {
            if (node.left == null) {
                //node = null;
                return node.right;

            } else if (node.right == null) {

                return node.left;

            }

            node.data = maxLeft(node.left);
            node.left = remove(node.left, node.data);

        }
        return node;
    }

    private int maxLeft(BSTNode node) {
        int maximum = node.data;
        while (node.right != null) {
            maximum = node.right.data;
            node = node.right;
        }
        return maximum;
    }

    public boolean remove(int elem) {
        if (!contains(root, elem)) {
            return false;
        }
        root = remove(root, elem);
        return true;
    }

    public boolean contains(BSTNode node, int elem) {
        if (node == null) {
            return false;
        }
        if (elem < node.data) {
            return contains(node.left, elem);
        } else if (elem < node.data) {
            return contains(node.right, elem);
        } else {
            return true;
        }
    }

}
