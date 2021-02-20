package HomeWork_22_02;

public class HomeWork_22_Main {
    public static void main(String[] args) {
        FourTuple<String, Integer, String, Integer> storage = new FourTuple<>("Apple", 20, "Cat", 120);

        System.out.println(storage.fisrt); // Задание 1
        System.out.println(storage.second);
///////////////////////////////////////////////////////////////////////////
        int[] a = new int[] {2,5,1,5,2};
        for (int i : new RangeInterval(2, a.length)) { // Задание 2
            a[i] = 9;
        }

        for (int i : new Range(a.length)) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println("");

//////////////////////////////////////////////////////////////////////////
        for (int i : new FibonacciRange(35)) {  // Задание 3
            System.out.printf("%d ",i);
        }

    }
}
