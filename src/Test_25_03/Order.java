package Test_25_03;

import java.io.Serializable;

public class Order implements Serializable {
    public String name;
    public int count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
    }

}

