package rough;

import java.util.*;

public class BST {
    protected Node root;

    public static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    public List<Integer> bfs() {
        Node current = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(current);
        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            current = queue.remove();
            result.add(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }

    public boolean contains(int incomingValue) {
        if (root == null) return false;
        Node existing = root;
        while (existing != null) {
            if (incomingValue < existing.value) {
                existing = existing.left;
            } else if (incomingValue > existing.value) {
                existing = existing.right;
            } else return true;
        }
        return false;
    }


    public boolean insert(int value) {
        Node incomingValue = new Node(value);
        if (root == null) {
            root = incomingValue;
            return true;
        }
        Node existingValue = root;
        while (true) {
            if (incomingValue.value == existingValue.value) return false;
            if (existingValue.value > incomingValue.value) {
                if (existingValue.left == null) {
                    existingValue.left = incomingValue;
                    return true;
                }
                existingValue = existingValue.left;
            } else {
                if (existingValue.right == null) {
                    existingValue.right = incomingValue;
                    return true;
                }
                existingValue = existingValue.right;
            }
        }
    }

    public void  inOrderBStUsingRecursion(int value){
        if(root==null) System.out.println();
    }
    public int minValInBSt(){
        Node cur =root;
        while (cur.left!=null){
            cur =cur.left;
        }return cur.value;
    }

    public List<Integer> dfsForPreOrder(){
        List<Integer> list = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                list.add(currentNode.value);
                if(currentNode.left!=null) new Traverse(currentNode.left);
                if(currentNode.right!=null) new Traverse(currentNode.right);
            }
        } new Traverse(root);
        return  list;
    }
    //  1 -> 3->4 -> 5 -> 6 -> 7 -> 8 -> 9
    //
    //
    public void  reverseLL(){
        Node current = root;
        Node next,prev=null;
        while(current!=null){
            next = current.right;
            current.right = prev;
            prev = current;
            current =next;
        }
    }
    public void  printLL(){
        Node current= root;
        while (current!=null){
            System.out.println(current.value);
            current=current.right;
        }
    }

    public int heightOFBST(Node root){
        if(root==null) return -1;
        return 1+Math.max(heightOFBST(root.left),heightOFBST(root.right));
    }

    public  List<Integer> dfsForPostOrder(){
        List<Integer> list = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left!=null) new Traverse(currentNode.left);
                if(currentNode.right!=null) new Traverse(currentNode.right);
                list.add(currentNode.value);
            }
        }
        new Traverse(root);
        return list;
    }
    public  List<Integer> dfsForInOrder(){
        List<Integer> list = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left!=null) new Traverse(currentNode.left);
                list.add(currentNode.value);
                if(currentNode.right!=null) new Traverse(currentNode.right);

            }
        }
        new Traverse(root);
        return list;
    }
    public  void DeleteNodeAtTheEnd(){
        Node current = root;
        while(current.right.right!=null) current = current.right;
        current.right=null;
        root=current;
    }

    public boolean addNodeAtIndex(int index,Node node){
        int count=0;
        Node current =root;
        while(current!=null && count==index-1){
            current=current.right;
            count++;
        }
        Node temp=current.right;
        current.right=node;
        node.right=temp;
        return true;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(4);
        priorityQueue.offer(6);
        priorityQueue.offer(7);

        System.out.println(priorityQueue);


    }


}
