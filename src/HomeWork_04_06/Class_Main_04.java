package HomeWork_04_06;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Class_Main_04 {
    public static void main(String[] args) throws InterruptedException {

        IOPersonClasses personClasses = new IOPersonClasses();

        Thread thread1 = new Thread(() -> {
            personClasses.FileWriter();
        });
        thread1.setName("Writer");


        Thread thread2 = new Thread(() -> {
            try {
                personClasses.FileReader();
            } catch (FileNotFoundException | InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread2.setName("Reader");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        /////////////////////////////////////////////////////////////////////////

        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        if (t < 0) {
            throw new InvalidParameterException("Вы ввели отрицательное число!");
        }

        StringAdder sA = new StringAdder();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        for(int i=0; i < t; i++){
            try {
                scheduledExecutorService.schedule(sA,3,TimeUnit.SECONDS).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        scheduledExecutorService.shutdown();
        if (scheduledExecutorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
            scheduledExecutorService.shutdownNow();
        }




    }
}

final class IOPersonClasses{

    private Person Generator(){
        Countries[] countries = Countries.values();
        int size = countries.length;
        Random random = new Random();

        Countries c = countries[random.nextInt(size)];
        int randomName = random.nextInt(c.toString().length() + 1);
        String s = c.toString().substring(0,randomName);

        if(s.equals("")){
            s = "default name";
        }

        return new Person(s,c);
    }


    synchronized public void FileWriter(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int iterations = 10;

        while (iterations > 0) {
            try (FileWriter writer = new FileWriter("binocla.txt", true)) {
                writer.write(gson.toJson(this.Generator()));
                writer.flush();
                System.out.println(Thread.currentThread().getName() + " записал данные в файл");
                iterations--;
                notify();

                if(iterations != 0){
                    wait();
                }

                Thread.sleep(500);
            } catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        return;
    }

    synchronized public void FileReader() throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().create();
        JsonReader jsR = new JsonReader(new FileReader("binocla.txt"));

        int iterations = 10;

        while (iterations > 0) {

            Person per = gson.fromJson(jsR, Person.class);

            iterations--;
            System.out.println(Thread.currentThread().getName() + " считал данные из файла");
            System.out.println(per.toString());

            notify();

            if(iterations != 0){
                wait();
            }

            Thread.sleep(500);
        }

        return;

    }



}

class Person{
    String name;
    int age;
    Countries countries;

    public Person(String n, Countries c) {
        this.name = n;
        this.countries = c;
        Random random = new Random();
        this.age = random.nextInt(100) + 1;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", countries=" + countries +
                '}';
    }
}

class StringAdder implements Callable<String> {
    StringBuilder sB;

    public StringAdder() {
        this.sB = new StringBuilder();
    }


    @Override
    public String call() throws Exception {

            int n = new Random().nextInt(6) + 1;
            String alphabit = "abcdefghijklmnopqrstuvxyz";
            for(int i=0; i < n; i++){
                sB.append(alphabit.charAt(new Random().nextInt(alphabit.length())));
            }

            System.out.println(Thread.currentThread().getName() + " прибавил буквы к слову");
            System.out.println(sB.toString());


        return sB.toString();
    }
}