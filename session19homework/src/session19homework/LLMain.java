package session19homework;

public class LLMain {
    BE8LinkedList list = new BE8LinkedList();

    public void run() {
        list.addItem(0,10);
        list.addItem(1,99);
        list.addItem(2,9932);
        list.addItem(1,956598932);
        list.deleteItem(2);
      
        list.printList(); 

    }
}
