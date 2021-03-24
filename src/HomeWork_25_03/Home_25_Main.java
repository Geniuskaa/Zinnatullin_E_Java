package HomeWork_25_03;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;

public class Home_25_Main {
    public static void main(String[] args) throws FileNotFoundException {

        Product first = new Product("Iphone", 5);
        Product second = new Product("Samsung", 2);
        Product third = new Product("Huawei", 3);
        Product five = new Product("Nokia", 12);
        Product six = new Product("Honor", 24);
        Product seven = new Product("HTC", 4);


          ArrayList<Product> products = new ArrayList<Product>();
          products.add(first);
          products.add(second);
          products.add(third);
          products.add(five);
          products.add(six);
          products.add(seven);

          Store miniStore = new Store(products);
          miniStore.removeProduct("HTC");

          miniStore.changeCountOfProducts("Iphone", 10);
          miniStore.printAllProducts();

         //writeToFile(miniStore,"file.txt");



        miniStore = readFromFile("file.txt");
        miniStore.sizeOfStore();
        miniStore.printAllProducts();


    }

    static void writeToFile(Object o, String nameOffile) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try (FileWriter writer = new FileWriter(nameOffile, false)) {
            writer.write(gson.toJson(o));
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static Store readFromFile(String nameOfFile) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Store store = gson.fromJson(new JsonReader(new FileReader(nameOfFile)), Store.class);
        return store;
    }


}
