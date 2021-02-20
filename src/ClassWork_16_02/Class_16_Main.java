package ClassWork_16_02;

public class Class_16_Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(new Stack.Node<>(1,null));

        stack.push(10);
        stack.push(20);
        stack.push(30);
        int x = stack.peek();
        int y = stack.pop();

        System.out.println(x);
        System.out.println(y);

        System.out.println(stack.peek());



    }
}
