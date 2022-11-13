package rough.coding;

import java.util.Stack;

public class QueueDSUsingStack {
    static Stack<Integer> stack = new Stack<>();
    static int length = 0;

    public void enqueue(int value) {
        stack.push(value);
        length++;
    }

    public int dequeue() {
        return stack.remove(0);
    }

    public static void main(String[] args) {
        QueueDSUsingStack queueDSUsingStack = new QueueDSUsingStack();
        queueDSUsingStack.enqueue(1);
        queueDSUsingStack.enqueue(2);
        queueDSUsingStack.enqueue(3);
        queueDSUsingStack.enqueue(4);
        queueDSUsingStack.enqueue(5);
        System.out.println(stack);

        System.out.println(queueDSUsingStack.dequeue());
        System.out.println(stack);
        System.out.println(queueDSUsingStack.dequeue());
        System.out.println(stack);
        System.out.println(queueDSUsingStack.dequeue());
        System.out.println(stack);
    }
}
