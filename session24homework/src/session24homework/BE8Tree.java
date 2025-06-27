package session24homework;

public class BE8Tree {

    BE8Node root;

    public boolean isBalance() {
        return isBalancedHelper(root) != -1;
    }

    private int isBalancedHelper(BE8Node node) {
        if (node == null) return 0;

        int left = isBalancedHelper(node.left);
        if (left == -1) return -1;  

        int right = isBalancedHelper(node.right);
        if (right == -1) return -1;  

        if (Math.abs(left - right) > 1) return -1; 

        return Math.max(left, right) + 1;
    }
}
