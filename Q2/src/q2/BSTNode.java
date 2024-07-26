/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;

/**
 *
 * @author Vo Hoang Tu - CE000000
 */
public class BSTNode {

    int data;
    BSTNode left;
    BSTNode right;
    int level;
    int count;
    int order;
    BSTNode parent;

    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.level = 0;
        this.count = 1;
        this.order = 0;
        this.parent = null;
    }

    public boolean isLeaf() {
        return this.left == null
                && this.right == null;
    }

    public boolean hasLeftChild() {
        return this.left != null;
    }

    public boolean hasRightChild() {
        return this.right != null;
    }

    public boolean hasOneChild() {
        return (this.hasLeftChild() && !this.hasRightChild())
                || (!this.hasLeftChild() && this.hasRightChild());
    }

    public boolean hasTwoChild() {
        return this.hasLeftChild() && this.hasRightChild();
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isInside() {
        return !this.isRoot() && !this.isLeaf();
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
        this.level = this.parent.level + 1;
        if (this.data < this.parent.data) {
            this.order = this.parent.order * 2 + 1;
        } else {
            this.order = this.parent.order * 2 + 2;
        }
    }

    public void setLeft(BSTNode left) {
        this.left = left;
        if (left != null) {
            this.left.setParent(this);
        }
    }

    public void setRight(BSTNode right) {
        this.right = right;
        if (right != null) {
            this.right.setParent(this);
        }
    }

    public boolean removeLeafChild(BSTNode node) {
        if (node == null) {
            return false;
        }
        if (node.isLeaf()) {
            if (this.hasLeftChild()) {
                if (this.left.data == node.data) {
                    this.setLeft(null);
                    return true;
                }
            }
            if (this.hasRightChild()) {
                if (this.right.data == node.data) {
                    this.setRight(null);
                    return true;
                }
            }
        }
        return false;
    }

    public BSTNode findMinNode() {
        BSTNode currentNode = this;
        while (currentNode.hasLeftChild()) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public BSTNode findMaxNode() {
        BSTNode currentNode = this;
        while (currentNode.hasRightChild()) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }
    
    public void replaceWithChild(BSTNode childNode) {
        if (this.parent.left == this) {
            this.parent.setLeft(childNode);
        } else {
            this.parent.setRight(childNode);
        }

}
}
