import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class som {
    public static void main(String[] args) {
        String s = "S/?ome1 .a sdg1, sga/ a<gaS3 Sg.a3 322,/";
        String d = s.toLowerCase();
        Pattern p = Pattern.compile("[^s]+");
        Matcher matcher = p.matcher(d);

        System.out.println(s.replaceAll("[.|/|?|<|,]", ""));

        String string1 = "Hello World";
        int index = string1.indexOf("Worl");
        System.out.println(index);
//        while (matcher.find()) {
//            System.out.println(s.substring(matcher.start(), matcher.end()));
//        }


        String so = "Ge;i. asf.asa ma.mon.do";
        so = stringChanger(so);
        System.out.println(so);

        String text = "12.34"; // example String
        double value = Double.parseDouble(text);

        System.out.println(value);
    }

    public static String stringChanger(String some){
        String h = some.replaceAll("[.]","");
        return h;
    }
}
