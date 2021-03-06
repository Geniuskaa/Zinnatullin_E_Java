package HomeWork_08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Class_08_Main extends PolandCalculator{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = bufferedReader.readLine();
        PolandCalculator calc = new PolandCalculator();
        try {
            int a = calc.polandCalc(inputStr);
            System.out.println(a);
        }catch (EmptyStackException e){
            System.out.println("Некорректные данные на входе.");
        }


        /////////////////////////////////////// Сверху польский калькулятор, снизу Задание 1, но вы уже проверили его на паре

        String exercise = "dj(cj9[{df}]fk,l5)";

        System.out.println(checkBrackets(exercise));


    }


    static boolean checkBrackets(String task) {
        Stack<Character> store = new Stack<>();
        String charc = "()[]{}";

        for (int i = 0; i < task.length(); i++) {
            char letter = task.charAt(i);
            String stringFromLetter = Character.toString(letter);
            if (charc.contains(stringFromLetter)) {
                switch (letter) {
                    case '(':
                        store.push(letter);
                        break;
                    case ')':
                        if (store.peek() == '(') {
                            store.pop();
                        }else {
                            return false;
                        }
                        break;
                    case '[':
                        store.push(letter);
                        break;
                    case ']':
                        if (store.peek() == '[') {
                            store.pop();
                        }else {
                            return false;
                        }
                        break;
                    case '{':
                        store.push(letter);
                        break;
                    case '}':
                        if (store.peek() == '{') {
                            store.pop();
                        }else {
                            return false;
                        }
                        break;
                    default:
                        continue;
                }
            }
        }
        return true;
    }

}
