package HomeWork_13_05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product{
    public String name;
    public int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class HomeWork_13_Main {
    public static void main(String[] args) {
        String[] str = {"ada","gas","as","fasm","asfpw","amqwmpq","asff","safag","a"};

        Stream<String> stream1 = Arrays.stream(str);

        stream1.filter(x -> x.startsWith("a"))
                .sorted()
                .forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////

        Integer[] ints = {124,423,262,423,732,820,229,124};
        Stream<Integer> stream2 = Arrays.stream(ints);
        stream2.sorted((x,y) -> Integer.compare(x%10,y%10))
                .distinct()
                .forEach(x -> {
                    x/=10;
                    System.out.println(x);
                });

        ////////////////////////////////////////////////////////////////////

        List<Product> lst= new ArrayList<>();

        try {
            FileReader fr = new FileReader("task3.txt");

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                String[] s = line.split("\\|");

                lst.add(new Product(s[0],Integer.parseInt(s[1])));

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Product> stream3 = lst.stream();


        Map<String, Long> map2 = stream3
                .collect(Collectors.groupingBy(x -> x.name, Collectors.counting()));

        Iterator<Map.Entry<String,Long>> iterator = map2.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Long> pair = iterator.next();
            String key = pair.getKey();
            Long value = pair.getValue();
            System.out.println(key + ":" + value);
        }









    }
}
