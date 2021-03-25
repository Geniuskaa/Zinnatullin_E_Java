package Test_25_03;

import java.io.Serializable;
import java.util.ArrayList;

public class Buyer implements Serializable {
    public String name;
    public ArrayList<City> whereWasMadeOrder;

    public Buyer(String name, ArrayList<City> whereWasMadeOrder) {
        this.name = name;
        this.whereWasMadeOrder = whereWasMadeOrder;
    }

}
