package HomeWork_25_03;

import java.util.ArrayList;
import java.util.Scanner;


public class Store {
    private ArrayList<Product> store;

    public Store() {
        store = new ArrayList<>();
    }

    public Store(ArrayList<Product> store) {
        this.store = store;
    }

    void printAllProducts(){
        Product[] arrOfProducts = new Product[store.size()];
        store.toArray(arrOfProducts);

        for(int i = 0; i < store.size(); i++) {
            System.out.printf("%s) " + arrOfProducts[i].nameOfProduct + ":%s \n", i+1, arrOfProducts[i].countOfProducts);
        }
    }

    void addNewProduct(Product product){
        for (Product p : store) {
            if(p.nameOfProduct.equals(product.nameOfProduct)){
                System.out.println("Такой товар уже есть на складе, поэтому мы увеличили его кол-во.");
                p.countOfProducts += product.countOfProducts;
                return;
            }
        }

        this.store.add(product);
    }

    void removeProduct(String name) {
        String answer = name.toLowerCase();
        for(int i = 0; i < store.size(); i++) {
            if(store.get(i).nameOfProduct.equals(answer)) {
                if (store.get(i).countOfProducts != 0) {
                    System.out.println("Данный товар ещё есть на складе. Всеравно удалить его из списка?");
                    System.out.print("Введите 'да' или 'нет': ");
                    Scanner scanner = new Scanner(System.in);
                    String s = scanner.next();
                    s.toLowerCase();

                    if (s.contentEquals("да")) {
                        store.remove(i);
                        System.out.println("\n Deleted!");
                    }
                    return;
                }
                store.remove(i);
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Такого товара нет на складе!");
    }

    void changeCountOfProducts(String name, int count) { // Метод не заменит значение, а увеличит
        String answer = name.toLowerCase();
        for(int i = 0; i < store.size(); i++) {
            if (store.get(i).nameOfProduct.equals(answer)) {
                store.get(i).countOfProducts += count;
                return;
            }
        }
        System.out.println("Такого товара нет на складе!");
    }

    void sizeOfStore(){
        System.out.println("Размер: " + store.size());
    }


}
