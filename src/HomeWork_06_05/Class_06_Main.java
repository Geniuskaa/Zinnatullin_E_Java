package HomeWork_06_05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Class_06_Main {
    public static void main(String[] args) {
        Comparator<String> comp = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };

        TreeSet<String> tr = new TreeSet<>(comp);

        tr.add("Mama");
        tr.add("Father");
        tr.add("Bro");
        tr.add("Qu");

        Iterator it = tr.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


        int[] a = {2,3,7,4,12,9,1,20};
        int[] b = arraySorter(a, x -> x%2 == 0);
        for (int f : b) {
            System.out.println(f);
        }



    }


    static int[] arraySorter(int[] arr, Predicate<Integer> predicate){
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : arr){
            if(predicate.test(element)){
                list.add(element);
            }
        }

        int[] newArr = new int[list.size()];
        for(int i=0; i < list.size(); i++){
            newArr[i] = list.get(i);
        }

        return newArr;
    }
}
