import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamTink {
    public static void main(String[] args) {

    int n = 6, m = 3, k;
    int[] costOfThing = new int[n];

    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < n; i++){
        costOfThing[i] = sc.nextInt();
    }

    int[] box = new int[m];
    int circle = 1;
        for (int i = 0; i < n; i++) {
            if(circle > 1){
                box[i/circle] = costOfThing[i];
            }else{
                box[i] = costOfThing[i];
            }

            circle++;
        }



//        Scanner sc = new Scanner(System.in);
//
//        int[] inputData = new int[4];
//        for(int i = 0; i < 4; i++){
//            inputData[i] = sc.nextInt();
//        }
//        int a = inputData[0];
//        int b = inputData[1];
//        int c = inputData[2];
//        int t = inputData[3];
//
//        int tempOne = t/c;
//        int min = t - (c * tempOne);
//        int tempTwo = tempOne/b;
//        int hour = tempOne - (b * tempTwo);
//        int day = hour/a;
//
//        System.out.print(day + " " + hour + " " + min);




//        String nickname = "megabos";
//
//        Pattern pattern = Pattern.compile("[aeiouy]{2}");
//        Matcher matcher = pattern.matcher(nickname);
//        if(matcher.find()){
//            System.out.println("NO");
//        }else{
//            System.out.println("YES");
//        }
    }
}
