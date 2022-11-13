package rough.coding;

public class LLMain {
    public static void main(String[] args) {
        LINKEDLIST linkedlist = new LINKEDLIST();
        linkedlist.insert(1);
        linkedlist.insert(2);
        linkedlist.insert(4);
        linkedlist.insert(6);
        linkedlist.insert(3);
        linkedlist.insert(5);
        linkedlist.insert(18);

        System.out.println("Linked List size is : " + linkedlist.size());

        linkedlist.addAtIndex(3, 24);
        linkedlist.printLL();
        linkedlist.reverseLL();
        linkedlist.printLL();
    }
}
