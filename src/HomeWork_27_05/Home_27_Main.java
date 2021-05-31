package HomeWork_27_05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Home_27_Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(7);

        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0; i < 4; i++){
            threads.add(new Thread(()->{
                System.out.println("Сейчас работает" + Thread.currentThread().getName());
                counter.fuctorialCounter();
            }));
        }

        for (Thread th : threads) {
            th.start();
        }

        Thread.sleep(2000);

        System.out.println("У нас получился такой факториал: " + counter.fuctorial);
        System.out.println("");
/////////////////////////////////////////////////////////////////////////////////////////////

        StringSplitter ss = new StringSplitter();

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " в работе");
            ss.prosloyka();

        });
        thread1.setName("Jesus");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " в работе");
            ss.prosloyka();

        });
        thread2.setName("Bobik");


        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();


        System.out.println("Четные слова: ");
        for (String s : ss.count) {
            System.out.print(s + " ");
        }
        System.out.println("");

        System.out.println("Нечетные слова: ");
        for (String s : ss.uncount) {
            System.out.print(s + " ");
        }

        
    }


}
 class StringSplitter{
    private int position = 0;
    private List<String> source;
    List<String> count;
    List<String> uncount;

     public StringSplitter() {
         this.source = new ArrayList<>();
         this.count = new ArrayList<>();
         this.uncount = new ArrayList<>();

         try {
             FileReader fileReader = new FileReader("input.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             String line = bufferedReader.readLine();
             while (line != null){
                 source.add(line.toLowerCase());
                 line = bufferedReader.readLine();
             }
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     public void prosloyka(){
         while (position <= source.size()){
             stringTreatment();
             position++;
         }
     }

     synchronized private void stringTreatment(){
         if(position >= source.size()){
             return;
         }
         int uncountable = 2; // default value

         String s = source.get(position);
         char[] charArray = s.toCharArray();

         for(int i = 0; i < charArray.length; i++) {
             for(int j = i + 1; j < charArray.length; j++) {
                 if(charArray[i] == charArray[j])
                     uncountable++;
             }
         }

         //position++;

         if(uncountable % 2 != 0){
             uncount.add(s);
             System.out.println(Thread.currentThread().getName() + " добавил слово к списку нечётных!");
         }else {
             count.add(s);
             System.out.println(Thread.currentThread().getName() + " добавил слово к списку чётных!");
         }

     }


 }



 class Counter{
    volatile Integer fuctorial = 1;
    private volatile Integer maxCount;
    private volatile Integer residue = 0; // остаток
    private volatile Integer previous = 1;

     public Counter(int n) {
         if(n == 0){
             fuctorial = 0;
         }
         maxCount = n;
         if(n % 4 != 0){
             residue = n % 4;
         }
     }

     synchronized public void fuctorialCounter(){
         int workingRange = maxCount / 4;

         if(fuctorial == 0){
             return;
         }

         if(maxCount - previous < 0){
             return;
         }

         if(maxCount - (previous + workingRange - 1) == residue){
             workingRange += residue;
         }

         while(workingRange != 0){
             fuctorial *= previous;
             previous += 1;
             workingRange--;
         }
     }
 }


