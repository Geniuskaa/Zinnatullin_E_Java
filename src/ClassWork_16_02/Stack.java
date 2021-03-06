package ClassWork_16_02;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    public Stack() {
        this.head = new Node<>(null, null);
    } // fixes

    class StackIterator implements Iterator<T> {
        Node<T> copyOfHead = head;
        @Override
        public boolean hasNext() {
            if (copyOfHead.next != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            copyOfHead = copyOfHead.next; // fixes
            return copyOfHead.value;
        }
    }

    public StackIterator iterator() {
        return new StackIterator();
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
            return;
        }
        this.head.value = value; // fixes
    }

    public T pop(){
        if (this.head.value != null && this.head.next != null) {
            Node<T> oldHead = head;
            Node<T> previousHead = head.next;
            head = previousHead;
            return oldHead.value;
        }

        if(this.head.value == null && this.head.next == null) {
            System.out.println("Осторожно! Стек пуст - выводить нечего!"); // fixes
            return null;
        }
        return null;
    }

    public T peek(){
        return this.head.value;
    }

}
