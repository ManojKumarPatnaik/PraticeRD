package rough.coding;

import java.util.Arrays;

public class QueueIMPUsingArray {
    public static int[] A = new int[5];
    static int rare = 0;

    public void enqueue(int value) {
            A[rare++] = value;
    }

    public int dequeue() {
        int temp = A[0];
        for (int i = 0; i < rare - 1; i++) {
            A[i] = A[i + 1];
        }
        A[rare - 1] = 0;
        return temp;
    }

    public static void main(String[] args) {
        QueueIMPUsingArray queueIMPUsingArray = new QueueIMPUsingArray();
        queueIMPUsingArray.enqueue(1);
        queueIMPUsingArray.enqueue(2);
        queueIMPUsingArray.enqueue(3);
        queueIMPUsingArray.enqueue(4);
        queueIMPUsingArray.enqueue(5);
        System.out.println(Arrays.toString(A));
        System.out.println(queueIMPUsingArray.dequeue());
        System.out.println(Arrays.toString(A));
        System.out.println(queueIMPUsingArray.dequeue());
        System.out.println(Arrays.toString(A));
        System.out.println(queueIMPUsingArray.dequeue());
        System.out.println(Arrays.toString(A));
        System.out.println(queueIMPUsingArray.dequeue());
        System.out.println(Arrays.toString(A));
    }
}
