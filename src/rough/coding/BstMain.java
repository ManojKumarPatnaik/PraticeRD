package rough.coding;

import rough.BST;

public class BstMain {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);
        bst.reverseLL();
        bst.printLL();
//        System.out.println(bst.dfsForPostOrder());
//        System.out.println(bst.dfsForInOrder());
//        System.out.println(bst.bfs());
//        System.out.println(bst.dfsForPreOrder());
//        System.out.println(bst.contains(18));
//        System.out.println(bst.contains(47));
//        System.out.println(bst.contains(82));
//        System.out.println(bst.contains(76));
    }
}
