package session21homework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Be8Tree tree = new Be8Tree(); 
        Be8Node root = new Be8Node(); 
        
        // 1 
        // 30 40
        // 999
        
        
        root.value = 1; 
        tree.root = root; 
        
        Be8Node node30 = new Be8Node(); 
        node30.value = 30;
        tree.root.children.add(node30);
        
        Be8Node node40 = new Be8Node(); 
        node40.value = 40;
        tree.root.children.add(node40);
        
        Be8Node node100 = new Be8Node(); 
        tree.addNode(40, 999);
        

        System.out.println("--Root: " + tree.root.value);

        for (Be8Node child : tree.root.children) {
            System.out.println("----Child: " + child.value);
            
            for (Be8Node grandChild : child.children) {
                System.out.println("--------GrandChild: " + grandChild.value);
     
                for (Be8Node greatGrandChild : grandChild.children) {
                    System.out.println("------------Great-grandchild: " + greatGrandChild.value);
                }
            }
        }
    }
}


