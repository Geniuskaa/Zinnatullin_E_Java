package ClassWork_13_05;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    public String name;
    public String shop;
    public int price;

    public Product(String name, String shop, int price) {
        this.name = name;
        this.shop = shop;
        this.price = price;
    }
}

class Purchase {
    public String buyer;
    public String product;
    public String shop;
    public int count;

    public Purchase(String buyer, String product, String shop, int count) {
        this.buyer = buyer;
        this.product = product;
        this.shop = shop;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyer='" + buyer + '\'' +
                ", product='" + product + '\'' +
                ", shop='" + shop + '\'' +
                ", count=" + count +
                '}';
    }
}

public class Class_Main_13 {
    public static void main(String[] args) {

//        Purchase[] purchases = {new Purchase("d", "da", "market",20),
//                new Purchase("h", "da", "market",10),
//                new Purchase("d", "a", "market",18),
//                new Purchase("e", "da", "maret",26),
//                new Purchase("e", "a", "mrket",25)};
//
//        Stream<Purchase> stream1 = Arrays.stream(purchases);
//
//        Map<String, Integer> map =  stream1
//                .collect(Collectors.groupingBy(x -> x.buyer,
//                        Collectors.summingInt(x -> x.count)));
//
//        Stream<Map.Entry<String, Integer>> str2 = map.entrySet().stream();
//        String st = str2.max((x,y) -> Integer.compare(x.getValue(), y.getValue())).map(x -> x.getKey()).orElse("None");
//
//
////////////////////////////////////////////////////////////////////////////////////////
//
//        Product[] pr = {new Product("da", "market",235),
//                new Product("da", "maret",135),
//                new Product("a", "market",27),
//                new Product("a", "mrket",305),
//        };
//
//
//
//        Stream<Purchase> stream2 = Arrays.stream(purchases);
//        Map<String, List<Purchase>> map2 =  stream2
//                .collect(Collectors.groupingBy(x -> x.buyer));
//
//        Iterator<Map.Entry<String, List<Purchase>>> iterator2 = map2.entrySet().iterator();
//
//        while(iterator2.hasNext()){
//            Map.Entry<String, List<Purchase>> pair = iterator2.next();
//            String key = pair.getKey();
//            List<Purchase> value = pair.getValue();
//            System.out.println(key + ":" + value);
//        }
//
//
//    }


        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }

//    public static String task1(Purchase[] purchases) { ... }

        //public static String[] task2(Purchase[] purchases, Product[] products) { ... }
        String s = "asga adgad    arhah     ajaja arha ajaja";
        for (String st : s.split("//s.")) {
            System.out.println(st);
        }
        System.out.println(countingFibo(5));

    }
    public static int countingFibo(int n){
        int result = Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0]+ arr[1]})
                .limit(n)
                .map(t -> t[0])
                .mapToInt(Integer::intValue)
                .sum();
        return result;
    }
}
