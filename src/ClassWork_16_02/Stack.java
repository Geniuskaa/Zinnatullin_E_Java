package ClassWork_16_02;

public class Stack<T> {
    public Stack(Node<T> head) {
        this.head = head;
    }

    static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node node) {
            this.value = value;
            this.next = node;
        }
    }

    private Node<T> head;

    public void push(T value){
        if(this.head != null) {
            Node<T> newNode = new Node<>(value, this.head);
            this.head = newNode;
        }
    }

    public T pop(){
        if (head != null) {
            Node<T> oldHead = head;
            Node<T> previousHead = head.next;
            head = previousHead;
            return oldHead.value;
        }
        return head.value;
    }

    public T peek(){
        return this.head.value;
    }

}
