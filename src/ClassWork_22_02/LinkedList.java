package ClassWork_22_02;

import ClassWork_16_02.Stack;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    public LinkedList() {
        this.root = new Node<>(null, null);
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    class ListIterator implements Iterator<T> {
        Node<T> copyOfRoot = root;
        @Override
        public boolean hasNext() {
            if (copyOfRoot.next != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            copyOfRoot = copyOfRoot.next;
            return copyOfRoot.item;
        }
    }

    public ListIterator iterator() {
        return new ListIterator();
    }

    private Node<T> root;

    void add(T value){
        if (this.root.next == null) {
            this.root.next = new Node<>(value, null);
            return;
        }

        Node<T> temp = this.root.next;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node<>(value, null);
    }

    int size(){
        if (this.root.next != null) {
            int counter = 1;
            Node<T> temp = this.root.next;
            while (temp.next != null) {
                counter++;
                temp = temp.next;
            }
            return counter;
        }

        if (this.root.item != null) {
            return 1;
        }
        System.out.println("Список пуст.");
        return 0;
    }

    T get(int id){
        if (id < 0) {
            System.out.println("Id не может быть отрицательным числом!");
            return null;
        }

        if (size() > id) {
            int counter = 0;
            Node<T> temp = this.root.next;
            while (counter != id) {
                counter++;
                temp = temp.next;
            }

            return temp.item;
        }

        System.out.println("Id указанный вами, выходит за пределы списка!");
        return null;
    }

    void remove(int id) {
        if (id < 0) {
            System.out.println("Id не может быть отрицательным числом!");
            return;
        }

        if (size() > id) {
            if (size() - 1 == id) {
                int counter = 0;

                Node<T> temp = this.root;

                while (counter != id) {
                    counter++;
                    temp = temp.next;
                }
                temp.next = null;
                return;
            }

            int counter = 0;
            Node<T> previous = this.root.next;
            Node<T> temp = this.root.next;
            while (counter != id) {
                counter++;
                previous = temp;
                temp = temp.next;
            }
            previous.next = temp.next;
            return;
        }

        System.out.println("Id указанный вами, выходит за пределы списка!");
    }
}

    


