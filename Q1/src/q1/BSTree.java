/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTree {

    private BSTNode root;

    private String traversalResult;

    private boolean check;

    /*===== for drawing =====*/
    int screenWidth;
    int yMin;

    /*===== for drawing =====*/

    public BSTree() {
        root = null;
    }

    public BSTree(int screenWidth, int yMin) {
        root = null;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
    }

    public BSTNode getRoot() {
        return root;
    }

    public String getTraversalResult() {
        return traversalResult;
    }

    public void addNode(int valueOfNewNode) {
        if (this.root == null) {
            this.root = new BSTNode(valueOfNewNode, yMin, screenWidth);
        } else {
            boolean isAdded = false;
            BSTNode node = this.root;
            while (!isAdded) {
                if (valueOfNewNode == node.getData()) {
                    isAdded = true;
//                    node.setCount(node.getCount() + 1);
                } else if (valueOfNewNode < node.getData()) {
                    if (node.hasLeftChild()) {
                        node = node.getLeftChild();
                    } else {
                        node.setLeftChild(new BSTNode(valueOfNewNode, yMin, screenWidth));
                        isAdded = true;
                    }
                } else {
                    if (node.hasRightChild()) {
                        node = node.getRightChild();
                    } else {
                        node.setRightChild(new BSTNode(valueOfNewNode, yMin, screenWidth));
                        isAdded = true;
                    }
                }
            }
        }
    }

    public BSTNode findNode(int data) {
        BSTNode node = root;
        while (node != null) {
            if (data == node.getData()) {
                return node;
            } else if (data < node.getData()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return node;
    }

    public String displayNode(BSTNode node) {
        return node.getData() + "";
    }

    public void preOrder() {
        if (root == null) {
            this.traversalResult = "The tree is empty";
        } else {
            check = false;
            this.traversalResult = "";
            preOrder(root);
        }
    }

    public void preOrder(BSTNode node) {
        if (node != null) {
            for (int i = 0; i < node.getCount(); i++) {
                if (!check) {
                    traversalResult += displayNode(node);
                    check = true;
                } else {
                    traversalResult += "," + displayNode(node);
                }
            }
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void inOrder() {
        if (root == null) {
            this.traversalResult = "The tree is empty";
        } else {
            check = false;
            this.traversalResult = "";
            inOrder(root);
        }
    }

    public void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.getRightChild());
            for (int i = 0; i < node.getCount(); i++) {
                if (!check) {
                    traversalResult += displayNode(node);
                    check = true;
                } else {
                    traversalResult += "," + displayNode(node);
                }
            }
            inOrder(node.getLeftChild());
        }
    }

    public void postOrder() {
        if (root == null) {
            this.traversalResult = "The tree is empty";
        } else {
            check = false;
            this.traversalResult = "";
            postOrder(root);
        }
    }

    public void postOrder(BSTNode node) {
        if (node != null) {
            postOrder(node.getRightChild());
            postOrder(node.getLeftChild());
            for (int i = 0; i < node.getCount(); i++) {
                if (!check) {
                    traversalResult += displayNode(node);
                    check = true;
                } else {
                    traversalResult += "," + displayNode(node);
                }

            }
        }
    }

}
