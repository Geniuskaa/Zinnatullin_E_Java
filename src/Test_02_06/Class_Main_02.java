package Test_02_06;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Class_Main_02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> firstTask());


        Thread thread2 = new Thread(() -> secondTask());

        Thread thread3 = new Thread(() -> System.out.println("3 task"));

        while (true){
            System.out.println("Введите значение: ");
            Scanner sc = new Scanner(System.in);
            int value = sc.nextInt();
            switch (value){
                case 0:
                    return;
                case 1:
                    thread1.start();
                    break;
                case 2:
                    thread2.start();
                    break;
                case 3:
                    thread3.start();
                    break;
            }
        }



    }

    public static void firstTask (){
        System.out.println(Thread.currentThread().getName() + " на работе");
        ArrayList<Purchase> s = new ArrayList<>();
        try {
            File file = new File("task1.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String []temp = line.toLowerCase().split("\\|");
                Integer i = Integer.parseInt(temp[2]);
                s.add(new Purchase(temp[0], temp[1], i));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Purchase[] pur = s.toArray(Purchase[]::new);
        Arrays.stream(pur).collect(Collectors.groupingBy((x) -> x.name)).entrySet().stream()
                .forEach((x) -> {
                    System.out.println(x.getValue().stream().max((a,b) -> Integer.compare(a.count, b.count)));
                });
    }

    public static void secondTask(){
        System.out.println(Thread.currentThread().getName() + " на работе");
        ArrayList<Sklad> sk = new ArrayList<>();

        try {
            File file = new File("task2.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String []temp = line.toLowerCase().split("\\|");
                Integer i = Integer.parseInt(temp[1]);
                sk.add(new Sklad(temp[0], i));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sklad[] sklad = sk.toArray(Sklad[]::new);

        Map<String, Long> count = Arrays.stream(sklad).collect(Collectors.groupingBy(x -> x.name, Collectors.counting()));
        long sum = 0;
        for (Map.Entry<String, Long> k : count.entrySet()) {
            sum += k.getValue();
        }


        sum /= count.size();
        int d = (int) sum;

        for (Map.Entry<String, Long> k : count.entrySet()) {
            if(k.getValue() > d){
                System.out.println(k.getKey() + " " + k.getValue());
            }
        }

//        Arrays.stream(sklad).collect(Collectors.groupingBy(x -> x.name)).entrySet().stream()
//                .filter(x -> x.getValue().size() > d).forEach(z -> System.out.println(z.getValue()));
    }

    static class Purchase{
        String name;
        String product;
        int count;

        public Purchase(String name, String product, int count) {
            this.name = name;
            this.product = product;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Purchase{" +
                    "name='" + name + '\'' +
                    ", product='" + product + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    static class Sklad{
        String name;
        int count;

        public Sklad(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Sklad{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
