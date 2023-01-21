package main.graphs;

public class BinarySearchTree {
    private TreeNode root;
    char[] ALPH = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };

    public BinarySearchTree(TreeNode rootNode) {

    }

    public BinarySearchTree(int[] nodeValues) {
    }

    public TreeNode getRootNode() {
        return root;
    }

    public void setRootNode(TreeNode newRootNode) {
        this.root = newRootNode;
    }

    public boolean isEmpty() {
        return root.hasNoChildren();
    }

    // The main insert method. Calls another method of the same name (but different
    // type) which does the work
    public void insert(int i) {
        root = insert(i, root);
    }

    // The main delete method. Calls another method of the same name (but different
    // type) which does the work
    public void delete(int i) {
        root = delete(i, root);
    }

    private TreeNode insert(int i, TreeNode node) {
        if (node == null) {
            return new TreeNode(i);
        }

        if (i < node.getValue()) {
            node.setLeftNode(insert(i, node.getLeftNode()));
        } else {
            node.setRightNode(insert(i, node.getRightNode()));
        }

        return node;
    }

    private TreeNode delete(int i, TreeNode node) {
        if (node == null) {
            return null;
        }
        // search for the node to delete
        if (i < node.getValue()) {
            node.setLeftNode(delete(i, node.getLeftNode()));
        } else if (i > node.getValue()) {
            node.setRightNode(delete(i, node.getRightNode()));
        } else { // found it!
                 // easy cases: when there is one or no subtrees, just move things up
            if (node.getLeftNode() == null) {
                node = node.getRightNode();
            } else if (node.getRightNode() == null) {
                node = node.getRightNode();
            } else {
                // Now we have to move the predecessor into place
                // locate predecessor and its parent

                // first take one step left
                TreeNode pred = node.getLeftNode();
                // now step to the right as far as you can
                if (pred == null) {
                    node = node.getRightNode();
                } else {
                    TreeNode predparent = node;
                    while (pred.getRightNode() != null) {
                        predparent = pred;
                        pred = pred.getRightNode();
                    }
                    node.setValue(pred.getValue());
                    node.setLeftNode(delete(node.getValue(), node.getLeftNode()));
                }

            }

        }
        return node;
    }

    public void preorderTraversal(TreeNode current) {
        if (current != null) {
            System.out.println(ALPH[current.getValue()]);
            preorderTraversal(current.getLeftNode());
            preorderTraversal(current.getRightNode());
        }
    }

    public void inorderTraversal(TreeNode current) {
        if (current != null) {
            inorderTraversal(current.getLeftNode());
            System.out.println(ALPH[current.getValue()]);
            inorderTraversal(current.getRightNode());
        }
    }

    public void postorderTraversal(TreeNode current) {
        if (current != null) {
            postorderTraversal(current.getLeftNode());
            postorderTraversal(current.getRightNode());
            System.out.println(ALPH[current.getValue()]);
        }
    }

    public static void main(String[] args) throws Exception {
        TreeNode rootA = new TreeNode(0);
        TreeNode nodeB = new TreeNode(1);
        TreeNode nodeC = new TreeNode(2);
        TreeNode nodeD = new TreeNode(3);
        TreeNode nodeE = new TreeNode(4);
        TreeNode nodeF = new TreeNode(5);
        TreeNode nodeG = new TreeNode(6);
        BinarySearchTree foo = new BinarySearchTree(rootA);
        rootA.setLeftNode(nodeB);
        rootA.setRightNode(nodeC);
        nodeB.setLeftNode(nodeD);
        nodeB.setRightNode(nodeF);
        nodeC.setLeftNode(nodeG);
        nodeF.setRightNode(nodeE);
        foo.inorderTraversal(rootA);
        System.out.println();
        foo.postorderTraversal(rootA);
    }
}
