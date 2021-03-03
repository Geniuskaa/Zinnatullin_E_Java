package ClassWork_16_02;

public class Class_16_Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.pop();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        int x = stack.peek();
        int y = stack.pop();

        System.out.println(x);
        System.out.println(y);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.pop());
        stack.pop();
        System.out.println("Сань, все хйня, давай по новой!"); // Пробуем добавить элементы в пустой стэк
        stack.push(30);
        System.out.println(stack.peek());
        stack.push(40);
        System.out.println(stack.peek());
        stack.push(70);
        System.out.println(stack.peek());


        System.out.println("Сейчас как пересчитаем...");
        for(Integer item : stack) {
            System.out.println(item);
        }


    }
}
