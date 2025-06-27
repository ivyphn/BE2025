package session24homework;

//   1 
// 2   3
//4
public class Main {
    public static void main(String[] args) {
        BE8Tree tree = new BE8Tree();
        tree.root = new BE8Node();
        tree.root.value = 1;

        tree.root.left = new BE8Node();
        tree.root.left.value = 2;

        tree.root.right = new BE8Node();
        tree.root.right.value = 3;

        tree.root.left.left = new BE8Node();
        tree.root.left.left.value = 4;

        System.out.println("Is balanced: " + tree.isBalance());
    }
}

