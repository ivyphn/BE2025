package session24homework;

public class Main {
    public static void main(String[] args) {
        BE8Tree tree = new BE8Tree();

        // Create nodes
        BE8Node node3 = new BE8Node(3);
        BE8Node node2 = new BE8Node(2);
        BE8Node node1 = new BE8Node(1);
        BE8Node node4 = new BE8Node(4);
        BE8Node node5 = new BE8Node(5);
        BE8Node node6 = new BE8Node(6);
        BE8Node node7 = new BE8Node(7);
        BE8Node node8 = new BE8Node(8);
        BE8Node node9 = new BE8Node(9);

        // Build unbalanced tree:
        //       3
        //      / \
        //     2   4
        //    /   / \
        //   1   5   6
        //            \      
        //             7
        //              \
        //               8
        //                \
        //                 9                
                      
        tree.root = node3;
        node3.left = node2;
        node2.left = node1;
        node3.right = node4; 
        node4.left = node5; 
        node4.right = node6;
        node6.right = node7; 
        node7.right = node8;
        node8.right = node9;

        System.out.println("Before rebalancing:");
        tree.printTreeWithLabels(tree.root, "", false);

        tree.root = tree.rebalanceSubtree(tree.root);

        System.out.println("\nAfter rebalancing:");
        tree.printTreeWithLabels(tree.root, "", false);
    }
}
