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
public class BSTNode {

    private int data;
    private int count;
    private int level;
    private int order;
    private BSTNode leftChild;
    private BSTNode rightChild;
    private BSTNode parent;

    /*===== for drawing =====*/
    public static final int LEVEL_DY = 60;
    private int x;
    private int y;
    private int width;
    /*===== for drawing =====*/

    public enum NodeType {
        LEFT_CHILD,
        RIGHT_CHILD
    }

    public BSTNode(int data) {
        this.data = data;
        this.count = 1;
        this.level = this.order = 0;
        this.leftChild = this.rightChild = this.parent = null;
        
        this.x = 0;
        this.y = 0;
        this.width = 0;
    }
    
    public BSTNode(int data, int y, int screenWidth) {
        this.data = data;
        this.count = 1;
        this.level = this.order = 0;
        this.leftChild = this.rightChild = this.parent = null;
        
        // ===== for drawing
        this.x = this.width = screenWidth / 2;
        this.y = y;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            this.leftChild.setParent(this, NodeType.LEFT_CHILD);
        }
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            this.rightChild.setParent(this, NodeType.RIGHT_CHILD);
        }
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent, NodeType nodeType) {
        this.parent = parent;
        this.level = parent.getLevel() + 1;
        if (nodeType == NodeType.LEFT_CHILD) {
            this.order = parent.getOrder() * 2 + 1;
        } else {
            this.order = parent.getOrder() * 2 + 2;
        }

        //===== for drawing
        this.width = parent.getWidth() / 2;
        if (nodeType == NodeType.LEFT_CHILD) {
            //this.x = parent.getX() - (this.width + 5  - this.level);
            this.x = parent.getX() - this.width;

        } else {
            this.x = parent.getX() + this.width;
        }
        this.y = parent.getY() + LEVEL_DY;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean hasChild() {
        return this.hasLeftChild() || this.hasRightChild();
    }

    public boolean hasLeftChildOnly() {
        return this.leftChild != null && this.rightChild == null;
    }

    public boolean hasRighttChildOnly() {
        return this.rightChild != null && this.leftChild == null;
    }

    public boolean hasFullChild() {
        return this.leftChild != null && this.rightChild != null;
    }

    public boolean isLeaf() {
        return !this.hasChild();
    }

    public boolean isInside() {
        return !this.isRoot() && !this.isLeaf();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
