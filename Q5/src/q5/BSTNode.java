package q5;

/**
 *
 * @author Nguyen Van Quoc Bao - SE161837
 */
public class BSTNode {

    int data;
    BSTNode left;
    BSTNode right;
    int count;
    int level;
    int order;
    BSTNode parent;

    public enum NodeType {
        LEFT_CHILD,
        RIGHT_CHILD
    }

    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.count = 1;
        this.level = 0;
        this.order = 0;
        this.parent = null;
    }

    public boolean isLeaf() {
        return left == null & right == null;
//        if(left == null && right == null){
//            return true;
//        }else{
//            return false;
//        }
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    //Dùng để in 1 con, trái phải đều được
    public boolean hasOneChild() {
        return (hasLeftChild() && !hasRightChild())
                || (!hasLeftChild() && hasRightChild());
    }

    //Kiểm tra xem có 2 con hay không
    public boolean hasTwoChild() {
        return (hasLeftChild() && hasRightChild());
    }

    //Kiểm tra xem có phải là node gốc hay không, in ra node gốc
    public boolean isRoot() {
        return parent == null;
    }

    //Không phải là node lá, cũng k phải là node gốc
    public boolean isInside() {
        return !isLeaf() && !isRoot();
    }

    //Có con thì không phải là lá
    public boolean hasChild() {
        return !isLeaf();
    }

    //Tìm được parent thì sẽ tìm được level của node đó
    public void setParent(BSTNode parent, NodeType type) {
        this.parent = parent;
        this.level = this.parent.level + 1;
        if (type == NodeType.LEFT_CHILD) {
            this.order = 2 * this.parent.order + 1;
        } else {
            this.order = 2 * this.parent.order + 2;
        }
    }

    //Tìm cha cho node trái
    public void setLeft(BSTNode left) {
        this.left = left;
        if (left != null) {
            this.left.setParent(this, NodeType.LEFT_CHILD);
        }
    }

    //Tìm cha cho node phải
    public void setRight(BSTNode right) {
        this.right = right;
        if (right != null) {
            this.right.setParent(this, NodeType.RIGHT_CHILD);
        }
    }

    public BSTNode findMaxNode() {
        BSTNode currentNode = this;
        while (currentNode.hasRightChild()) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public BSTNode findMinNode() {
        BSTNode currentNode = this;
        while (currentNode.hasLeftChild()) {
            currentNode = currentNode.left;
        }
        return currentNode;
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
}
