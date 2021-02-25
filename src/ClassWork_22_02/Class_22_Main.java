package ClassWork_22_02;

public class Class_22_Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10); // 0
        list.add(20);
        list.add(30);
        list.add(40); // 3
        list.add(50);
        list.add(60); // 5

        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.get(0));

        list.remove(2);
        System.out.println(list.get(4));

        System.out.println("Сейчас как пересчитаем...");
        for (Integer item : list) {
            System.out.println(item);
        }
    }
}
