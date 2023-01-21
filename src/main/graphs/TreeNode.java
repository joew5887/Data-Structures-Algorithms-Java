package main.graphs;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        setValue(value);
        setLeftNode(leftNode);
        setRightNode(rightNode);
    }

    public TreeNode(int value) {
        setValue(value);
        setLeftNode(null);
        setRightNode(null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public TreeNode getLeftNode() {
        return left;
    }

    public void setLeftNode(TreeNode newLeftNode) {
        this.left = newLeftNode;
    }

    public TreeNode getRightNode() {
        return right;
    }

    public void setRightNode(TreeNode newRightNode) {
        this.right = newRightNode;
    }

    public boolean hasNoChildren() {
        return ((left == null) && (right == null));
    }
}
