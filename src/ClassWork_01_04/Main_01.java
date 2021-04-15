package ClassWork_01_04;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main_01 {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, HashMap<String, Integer>>> buyersMap = new HashMap<>();
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

        for(int i = 0; i < list.size(); i++){
            String[] parsed = list.get(i).split("\\|");

            if(!buyersMap.containsKey(parsed[0])){
                HashMap<String, Integer> o = new HashMap<>();
                int z = Integer.parseInt (parsed[3]);
                o.put(parsed[2], z);

                HashMap<String, HashMap<String, Integer>> c = new HashMap<>();
                c.put(parsed[1], o);
                buyersMap.put(parsed[0], c);
            }

            if(!buyersMap.get(parsed[0]).containsKey(parsed[1])){
                HashMap<String, Integer> o = new HashMap<>();
                int z = Integer.parseInt (parsed[3]);
                o.put(parsed[2], z);

                buyersMap.get(parsed[0]).put(parsed[1], o);
            }

            if(!buyersMap.get(parsed[0]).get(parsed[1]).containsKey(parsed[2])){
                int z = Integer.parseInt (parsed[3]);
                buyersMap.get(parsed[0]).get(parsed[1]).put(parsed[2], z);
            }

            int z = Integer.parseInt (parsed[3]);
            int temp = buyersMap.get(parsed[0]).get(parsed[1]).get(parsed[2]);
            buyersMap.get(parsed[0]).get(parsed[1]).put(parsed[2], temp + z);
        }


        for(Map.Entry<String, HashMap<String, HashMap<String, Integer>>> s : buyersMap.entrySet()){
            System.out.println(s.getKey() + ": ");
            for(Map.Entry<String, HashMap<String, Integer>> w : s.getValue().entrySet()){
                System.out.println(w.getKey() + ":");
                for(Map.Entry<String, Integer> q : w.getValue().entrySet()){
                    System.out.println(q);
                }
            }
            System.out.println("");
        }

        
        
        
    }
}
