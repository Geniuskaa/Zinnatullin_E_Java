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

        Store str = new Store();
        str.addNewProduct(first);
        str.addNewProduct(second);
        str.addNewProduct(third);
        str.addNewProduct(five);
        str.addNewProduct(six);
        str.addNewProduct(seven);

//        str.removeProduct("htc");
//        str.changeCountOfProducts("iphone", -3);
        str.printAllProducts();


         //writeToFile(str,"file.txt");

        str = readFromFile("file.txt");
        System.out.println(str.toString());

    }

    static void writeToFile(Store st, String nameOffile) { //Object o
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(nameOffile, false)) {
            writer.write(gson.toJson(st));
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static Store readFromFile(String nameOfFile) throws FileNotFoundException { // в существующий склад закинет данные
        Gson gson = new GsonBuilder().create();                                 // вместо тех,что уже есть там

        Store store = gson.fromJson(new JsonReader(new FileReader(nameOfFile)), Store.class);
        return store;
    }


}
