package rough.coding;

import java.util.Stack;

public class StackDemo {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.push(4);
        stack.push(6);
        stack.push(1);
        stack.push(2);
        stack.push(9);
        System.out.println(stack);
        insertAtSpecifiedIndex(2, 10);
        sortTheStack();
        System.out.println(stack);
        String d = "[1+{2+}]()(2+3)";
        System.out.println(valid(d));
    }

    private static boolean valid(String d) {
        var st = new Stack<Character>();
        for (var v : d.toCharArray()) {
            if (v == '(' || v == '{' || v == '[') st.push(v);
            else if (v == '}' || v == ')' || v == ']') {
                Character pop = st.pop();
                return ((pop == '{' && v == '}') || (pop == '[' && v == ']') || (pop == '(' && v == ')'));
            }
        }
        throw null;
    }

    private static void sortTheStack() {
        var newStack = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();//1
            while (!newStack.isEmpty() && temp < newStack.peek()) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }
        System.out.println(newStack);
    }

    private static void insertAtSpecifiedIndex(int i, int i1) {
        int count = 0;
        var newStack = new Stack<Integer>();
        while (!stack.isEmpty() && count < i) {
            newStack.push(stack.pop());
            count++;
        }
        stack.push(i1);
        while (!newStack.isEmpty()) stack.push(newStack.pop());
    }
}
