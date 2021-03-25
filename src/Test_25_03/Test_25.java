package Test_25_03;



import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Test_25 {
    public static void main(String[] args) {



        ArrayList<String> list = new ArrayList<>();
        try {
            File file = new File("orders.txt");


            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();

            }
        } catch (FileNotFoundException e) {  // Закинули в лист
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        BuyerByNameComparator nameC = new BuyerByNameComparator();
        BuyerByCityCountComparator cityC = new BuyerByCityCountComparator();
        BuyerByOrdersCountComparator countC = new BuyerByOrdersCountComparator();

        Comparator<Buyer> firstComparator = nameC.thenComparing(cityC.thenComparing(countC));
        Comparator<Buyer> secondComparator = countC.thenComparing(cityC.thenComparing(nameC));

        TreeSet<Buyer> firstSet = new TreeSet<>(firstComparator);
        TreeSet<Buyer> secondSet = new TreeSet<>(secondComparator);


        for(int f = 0; f < list.size(); f++){
            writeToTreeSet(firstSet, list.get(f));
            writeToTreeSet(secondSet, list.get(f));

        }


        for (Buyer bu : firstSet) {
            System.out.println(bu.toString()); // Проверил, что записалось норм
        }

        writeBuyerToFile(firstSet, "sortedByName.txt");
        writeBuyerToFile(secondSet, "sortedByOrders.txt.txt");

        readBuyer("sortedByName.txt");
        readBuyer("sortedByOrders.txt.txt");



    }

    public static void writeToTreeSet(TreeSet<Buyer> set, String s) {
        String[] splitted = s.split("\\|");
        Buyer[] b = new Buyer[]{};
        set.toArray(b);
        for(int i =0; i < b.length; i++){
            if(b[i].name.equals(splitted[0])){ // нашли такого пользователя
                for(int j = 0; j < b[i].whereWasMadeOrder.size(); j++){
                    if(b[i].whereWasMadeOrder.get(j).name.equals(splitted[1])) { // нашли город
                        for(int t = 0; t < b[i].whereWasMadeOrder.get(j).listOfOrders.size(); t++){
                            if(b[i].whereWasMadeOrder.get(j).listOfOrders.get(t).name.equals(splitted[2])){ // нашли позицию товара
                                int z = Integer.parseInt (splitted[3]);
                                b[i].whereWasMadeOrder.get(j).listOfOrders.get(t).count += z;
                                return;
                            }
                            int d = Integer.parseInt (splitted[3]);
                            Order o = new Order(splitted[2], d);
                            b[i].whereWasMadeOrder.get(j).listOfOrders.add(o);
                            return;
                        }
                    }
                    int d = Integer.parseInt (splitted[3]);
                    Order o = new Order(splitted[2], d);
                    ArrayList<Order> listOfOrders = new ArrayList<>();
                    listOfOrders.add(o);
                    City c = new City(splitted[1], listOfOrders);
                    b[i].whereWasMadeOrder.add(c);
                    return;

                }
            }
        }
        int d = Integer.parseInt (splitted[3]);
        Order o = new Order(splitted[2], d);
        ArrayList<Order> listOfOrders = new ArrayList<>();
        listOfOrders.add(o);
        City c = new City(splitted[1], listOfOrders);
        ArrayList<City> listOfCity = new ArrayList<>();
        listOfCity.add(c);
        Buyer buyer = new Buyer(splitted[0], listOfCity);
        set.add(buyer);

    }

    public static void writeBuyerToFile(TreeSet<Buyer> set, String nameOfFile) {
        try (FileOutputStream fos = new FileOutputStream(nameOfFile);
             ObjectOutputStream out = new ObjectOutputStream(fos))
        {
            for (Buyer bt : set) {
                out.writeObject(bt);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readBuyer(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fis))
        {
            Buyer br = (Buyer) in.readObject();

        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return;
    }
}

class BuyerByNameComparator implements Comparator<Buyer>, Serializable {
    @Override
    public int compare(Buyer b1, Buyer b2) {
        return b1.name.compareTo(b2.name);
    }
}

class BuyerByCityCountComparator implements Comparator<Buyer>, Serializable {
    @Override
    public int compare(Buyer b1, Buyer b2) {
        return Integer.compare(b1.whereWasMadeOrder.size(), b2.whereWasMadeOrder.size());
    }
}

class BuyerByOrdersCountComparator implements Comparator<Buyer>, Serializable {
    @Override
    public int compare(Buyer b1, Buyer b2) {
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < b1.whereWasMadeOrder.size(); i++){
            count1 += b1.whereWasMadeOrder.get(i).listOfOrders.size();
        }

        for(int j = 0; j < b2.whereWasMadeOrder.size(); j++){
            count2 += b1.whereWasMadeOrder.get(j).listOfOrders.size();
        }

        return Integer.compare(count1, count2);
    }
}


