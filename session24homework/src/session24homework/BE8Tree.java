package session24homework;

import java.util.ArrayList;
import java.util.List;

public class BE8Tree {

    public BE8Node root;

    private void collectNodesInOrder(BE8Node node, List<BE8Node> list) {
        if (node == null) return;
        
        collectNodesInOrder(node.left, list);
        list.add(node);
        collectNodesInOrder(node.right, list);
    }
    
    // 1,2,3,5,4,6,7,8,9
    // 1,2,3,5,  4  ,6,7,8,9
    // 1,  2,   3, 5 

    private BE8Node buildBalancedTree(List<BE8Node> nodes, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        BE8Node root = nodes.get(mid);

        root.left = buildBalancedTree(nodes, start, mid - 1);
        root.right = buildBalancedTree(nodes, mid + 1, end);

        return root;
    }

    public BE8Node rebalanceSubtree(BE8Node root) {
        List<BE8Node> nodeList = new ArrayList<>();
        collectNodesInOrder(root, nodeList);

        for (BE8Node node : nodeList) {
            node.left = null;
            node.right = null;
        }

        return buildBalancedTree(nodeList, 0, nodeList.size() - 1);
    }

    public void printTreeWithLabels(BE8Node node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.println(prefix + (isLeft ? "L-- " : "R-- ") + node.value);

        String childPrefix = prefix + (isLeft ? "|   " : "    ");
        printTreeWithLabels(node.left, childPrefix, true);
        printTreeWithLabels(node.right, childPrefix, false);
    }

    public boolean isBalanced(BE8Node node) {
        return getBalanceStatus(node) != -1;
    }

    private int getBalanceStatus(BE8Node node) {
        if (node == null) return 0;

        int left = getBalanceStatus(node.left);
        int right = getBalanceStatus(node.right);

        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
