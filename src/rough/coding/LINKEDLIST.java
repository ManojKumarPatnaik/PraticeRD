package rough.coding;

public class LINKEDLIST {
    public Node root;
    public static int length;

    public void addAtIndex(int ind, int value) {
        Node newNode = new Node(value);
        Node cur = root;
        //specified ind means need prev ind
        int count = 1;
        while (cur != null && count < ind - 1) {
            cur = cur.next;
            count++;
        }
        assert cur != null;
        Node temp = cur.next;
        cur.next = newNode;
        newNode.next = temp;

    }

    public static class Node {
        Node prev, next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public int size() {
        return length;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;

        } else {
            Node existing = root;
            while (existing.next != null) {
                existing = existing.next;
                existing.prev = existing;
            }
            existing.next = newNode;
        }
        length++;
    }

    public void printLL() {
        Node cur = root;
        while (cur != null) {
            System.out.print(cur.value +" -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void reverseLL() {
        Node cur = root;
        Node prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        root = prev;
    }
}
