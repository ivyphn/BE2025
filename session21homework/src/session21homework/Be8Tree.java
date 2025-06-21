package session21homework;

public class Be8Tree {
    Be8Node root;
    
    // Time complexity: O(n)
    // Space complexity: O(height)
    
    private Be8Node findNode(Be8Node current, int targetValue) {
    	
        if (current == null) return null;
        if (current.value == targetValue) return current;

        for (Be8Node child : current.children) {
            Be8Node found = findNode(child, targetValue);
            if (found != null) return found;
        }

        return null;
    }
 
    public void addNode(int parentValue, int valueToAdd) {
    	
        Be8Node parent = findNode(root, parentValue);
        
        if (parent != null) {
            Be8Node newNode = new Be8Node();
            newNode.value = valueToAdd;
            parent.children.add(newNode);
        } else {
            System.out.println("Parent with value " + parentValue + " not found.");
        }
    }
}
