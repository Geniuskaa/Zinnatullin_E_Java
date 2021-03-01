package ClassWork_01_03;

import java.util.Stack;

public class Class_01_Main {
    public static void main(String[] args) {
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
};



