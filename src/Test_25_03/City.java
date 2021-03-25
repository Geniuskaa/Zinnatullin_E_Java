package Test_25_03;

import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable {
    public String name;
    public ArrayList<Order> listOfOrders;

    public City(String name, ArrayList<Order> listOfOrders) {
        this.name = name;
        this.listOfOrders = listOfOrders;
    }

}
