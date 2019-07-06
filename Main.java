/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Google.
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t
 * has exactly the same structure and node values with a subtree
 * of s. A subtree of s is a tree consists of a node in s and all
 * of this node's descendants. The tree s could also be considered
 * as a subtree of itself.
 */

class BST {
    Node root;

    BST(int val) {
        root = new Node(val);
    }

    public void insert(int val) {
        root.insert(val);
    }

    public boolean find(int val) {
        return root.find(val);
    }

    public void preorderTraversal(Node node) {
        root.preorderTraversal(node);
    }

    public void inorderTraversal(Node node) {
        root.inorderTraversal(node);
    }

    public void postorderTraversal(Node node) {
        root.postorderTraversal(node);
    }

}

class Node {
    private int mVal;
    Node left;
    Node right;

    public int getVal() {
        return mVal;
    }

    Node(int val) {
        mVal = val;
    }


    public void insert(int val) {
        if (val < this.getVal()) {
            if (this.left == null) {
                this.left = new Node(val);
            } else {
                this.left.insert(val);
            }
        } else if (val > this.getVal()) {
            if (this.right == null) {
                this.right = new Node(val);
            } else {
                this.right.insert(val);
            }
        }
    }

    public boolean find(int val) {
        boolean found = false;
        if (val == this.getVal()) {
            return true;
        }
        if (val < this.getVal()) {
            found = this.left.find(val);
        } else if (val > this.getVal()) {
            found = this.right.find(val);
        }
        return found;
    }

    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.getVal() + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void inorderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            inorderTraversal(node.left);
            System.out.print(node.getVal() + " ");
            inorderTraversal(node.right);
        }
    }

    public void postorderTraversal(Node node) {
        if (node == null) {
            return;
        } else {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.getVal() + " ");
        }
    }
}

public class Main {

    public static boolean isSubArray(int[] subArr, int[] arr) {
        String subArrStr = "";
        String arrStr = "";

        for (int i : subArr) {
            subArrStr += i + ",";

        }

        for (int i : arr) {
            arrStr += i + ",";
        }

        return arrStr.contains(subArrStr);
    }


    public static void main(String[] args) {

        BST s = new BST(12);
        int[] sArray = new int[]{5, 11, 3};
        BST t = new BST(12);
        int[] tArray = new int[]{1, 2, 5, 11, 3, 15, 6};

        for (int i : sArray) {
            s.insert(i);
        }

        for (int i : tArray) {
            t.insert(i);
        }

        System.out.println("Preorder Traversal: ");
        s.preorderTraversal(s.root);
        System.out.println(" ");
        t.preorderTraversal(t.root);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Inorder Traversal: ");
        s.inorderTraversal(s.root);
        System.out.println(" ");
        t.inorderTraversal(t.root);

        /**
         * All you would have to do now is preorder traverse
         * the whole thing and add each element to the an array.
         *
         * Compare the two arrays to see if the traversal of each
         * one is a match.
         */

        System.out.println(isSubArray(sArray, tArray));
    }
}