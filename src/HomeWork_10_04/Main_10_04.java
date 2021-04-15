package HomeWork_10_04;

import java.io.File;
import java.util.Scanner;

public class Main_10_04 {
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        Bot bot = new Bot();
        System.out.print("- Чем могу быть полезен? *Если желаете закончить беседу введите " +
                "\"exit\" *" + "\n");

        while (true) {

            System.out.print("- ");
            String message = in.nextLine(); // *команда* + *аргумент_1* + *аргумент_2* и т.д
            if (message.equals("exit")) {
                System.out.println("Возвращайтесь ещё!");
                break;
            }

            String answer = bot.userInput(message);
            System.out.println(answer);
        }


    }
}
