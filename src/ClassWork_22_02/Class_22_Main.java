package ClassWork_22_02;

public class Class_22_Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10); // 0
        list.add(40); // 1
        list.add(50);
        list.add(60); // 3

        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.get(0));

        list.remove(2); // Убрали раз
        System.out.println(list.get(2));
        list.remove(1); // Убрали два
        list.remove(1); // Убрали три, но 1 элемент остался, проверим теперь метод size()

        System.out.println(list.size());

        System.out.println("Сейчас как пересчитаем...");
        for (Integer item : list) {
            System.out.println(item);
        }
    }
}
