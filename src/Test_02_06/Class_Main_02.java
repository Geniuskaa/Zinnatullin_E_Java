package Test_02_06;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Class_Main_02 {
    public static void main(String[] args) throws InterruptedException {

        while (true){
            System.out.println("Введите значение: ");
            Scanner sc = new Scanner(System.in);
            int value = sc.nextInt();
            switch (value){
                case 0:
                    return;
                case 1:
                    Thread thread1 = new Thread(() -> firstTask());
                    thread1.start();
                    break;
                case 2:
                    Thread thread2 = new Thread(() -> secondTask());
                    thread2.start();
                    break;
                case 3:
                    Thread thread3 = new Thread(() -> thirdTask());
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

    public static void thirdTask(){
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

        Map<String, Integer[]> razbros = new HashMap<>();
        Arrays.stream(pur).collect(Collectors.groupingBy((x) -> x.product)).entrySet()
                .stream().forEach(x -> razbros.put(x.getKey(),
                new Integer[] {x.getValue().stream().max((r,t) -> Integer.compare(r.count, t.count)).get().count}));

        Arrays.stream(pur).collect(Collectors.groupingBy((x) -> x.product)).entrySet()
                .stream().forEach(x ->
                razbros.replace(x.getKey(),razbros.get(x.getKey()),
                new Integer[] {x.getValue().stream().min((r,t) -> Integer.compare(r.count, t.count)).get().count, razbros.get(x.getKey())[0]}));

        for (Map.Entry<String, Integer[]> k : razbros.entrySet()) {
            System.out.println(k.getKey() + ":");
            System.out.println("minimum: " + k.getValue()[0]);
            System.out.println("maximum: " + k.getValue()[1]);
        }

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
