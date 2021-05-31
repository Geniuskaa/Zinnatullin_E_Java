package Test_25_03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NothingInteresting {
    public static void main(String[] args) {

        int count = 4194304;
        try(FileWriter writer = new FileWriter("data_4194304.txt", false))
        {
            int copy = count * 2;
            while(copy > 0){
                Random r = new Random();
                Integer num = r.nextInt(800);
                String n = num.toString();
                writer.append(n + " ");
                copy--;
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
