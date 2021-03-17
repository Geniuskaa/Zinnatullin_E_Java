package HomeWork_17_03;

import java.util.*;

public class Class_17 {
    public static void main(String[] args) {
        HashMap<String, Integer> dictionary = new HashMap<>();

        System.out.println("Введите данные для 1-го задания.");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();

        String [] words = name.toLowerCase().split(" ");

        wordsDictionary(dictionary, words);

        System.out.println(dictionary.size());
        System.out.println(dictionary.get("i"));

        for(int i = 0; i < words.length; i++) { // проверил, что слова очистились от знаков
            System.out.println(words[i]);
        }
////////////////////////////////////////////////////////////////////////////////////////////////

        HashMap<String, HashMap<String, Integer>> clients = new HashMap<>();


        int exit = 0;
        while(exit == 0) {
            System.out.println("Введите данные для 2-го задания.");

            String purchase = console.nextLine();

            String [] infoAboutPurchase = purchase.toLowerCase().split(" ");

            internetShopping(infoAboutPurchase, clients);

            System.out.println("Хотите закончить? Введите 1 - если да, 0 - если нет.");
            int answer = Integer.parseInt(console.nextLine());
            exit = answer;

        }


        Object [] arrayOfKeysOfClients = clients.keySet().toArray();
        for(int i = 0; i < clients.size(); i++) {
            System.out.println(arrayOfKeysOfClients[i].toString() + ":");
            Object [] arrayOfKeysOfProducts = clients.get(arrayOfKeysOfClients[i].toString()).keySet().toArray();

            for(int j = 0; j < arrayOfKeysOfProducts.length; j++) { // кол-во разных названий товаров у каждого покупателя
                System.out.println(arrayOfKeysOfProducts[j].toString() + "-"
                        + clients.get(arrayOfKeysOfClients[i].toString()).get(arrayOfKeysOfProducts[j]));
            }
        }


    }

    /**
     * @param word Выдаёт true если слово содержит пунктуационный знак.
     * @return
     */
    static boolean havePunctMark(String word) {
        if(word.contains(".") || word.contains(",") || word.contains("!") || word.contains("?")) {
            return true;
        }
        return false;
    }

    static void wordsDictionary(HashMap<String, Integer> map, String[] words) {
        for(int i = 0; i < words.length; i++) {
            if(havePunctMark(words[i])) {
                switch (words[i].charAt(words[i].length() - 1)) {
                    case '.':
                        words[i] = words[i].substring(0, words[i].length() - 1);
                        break;
                    case ',':
                        words[i] = words[i].substring(0, words[i].length() - 1);
                        break;
                    case '!':
                        words[i] = words[i].substring(0, words[i].length() - 1);
                        break;
                    case '?':
                        words[i] = words[i].substring(0, words[i].length() - 1);
                        break;
                    default:
                        break;
                }
            }

            if(map.containsKey(words[i])) {
                int value = map.get(words[i]);
                value++;
                map.put(words[i], value);
                continue;
            }

            map.put(words[i], 1);
        }
    }

    static void internetShopping(String [] purchaseInfo, HashMap<String, HashMap<String, Integer>> clients) {
        HashMap<String, Integer> product = new HashMap<>();

        Integer v = Integer.parseInt(purchaseInfo[2]);

        if(clients.containsKey(purchaseInfo[0])){
            if(clients.get(purchaseInfo[0]).containsKey(purchaseInfo[1])) {
                int count = clients.get(purchaseInfo[0]).get(purchaseInfo[1]);
                count += v;
                clients.get(purchaseInfo[0]).put(purchaseInfo[1], count);
                return;
            }

            clients.get(purchaseInfo[0]).put(purchaseInfo[1], v);
            return;
        }

        product.put(purchaseInfo[1], v);
        clients.put(purchaseInfo[0], product);

    }


}





