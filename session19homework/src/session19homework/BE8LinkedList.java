package session19homework;

public class BE8LinkedList {
    LinkedListItem head;

    public void addItem(int index, int value) {
        LinkedListItem addedItem = new LinkedListItem();
        addedItem.value = value;

        if (index < 0) {
            System.out.println("Invalid index: " + index);
            return;
        }

        if (index == 0) {
            addedItem.next = head;
            head = addedItem;
            return;
        }

        LinkedListItem currentItem = head;
        int currentIndex = 0;

        while (currentItem != null && currentIndex < index - 1) {
            currentItem = currentItem.next;
            currentIndex++;
        }

        if (currentItem == null) {
            System.out.println("Index out of bounds: " + index);
            return;
        }

        addedItem.next = currentItem.next;
        currentItem.next = addedItem;
    }

    public void deleteItem(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index or empty list");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        LinkedListItem currentItem = head;
        int currentIndex = 0;

        while (currentItem.next != null && currentIndex < index - 1) {
            currentItem = currentItem.next;
            currentIndex++;
        }

        if (currentItem.next == null) {
            System.out.println("Index out of bounds: " + index);
            return;
        }

        currentItem.next = currentItem.next.next;
    }

    public void printList() {
        LinkedListItem currentItem = head;
        while (currentItem != null) {
            System.out.print(currentItem.value + " -> ");
            currentItem = currentItem.next;
        }
        System.out.println("null");
    }
}
