package HomeWork_08_03;

import java.util.Stack;

public class PolandCalculator {

    int polandCalc(String input) {
        String[] elementsOfInputStr = input.split(" ");
        Stack<Integer> storeOfNums = new Stack<>();
        for (int i = 0; i < elementsOfInputStr.length; i++) {
            if (tryParseInt(elementsOfInputStr[i])) {
                storeOfNums.push(Integer.parseInt(elementsOfInputStr[i]));
                continue;
            }
            char charFromString = elementsOfInputStr[i].charAt(0);

            int b = storeOfNums.pop();
            int a = storeOfNums.pop();
            doMathOperations(charFromString, storeOfNums, a, b);
        }

        if(storeOfNums.size() == 1) {
            return storeOfNums.pop();
        }

        System.out.println("Вы ввели некорректную строку!");
        return -1;
    }


    boolean tryParseInt(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    void doMathOperations(char mark, Stack stack, int a, int b) {
        switch (mark) {
            case '+':
                stack.push(a + b);
                break;
            case '-':
                stack.push(a - b);
                break;
            case '*':
                stack.push(a * b);
                break;
            case '/':
                stack.push(a / b);
                break;
        }
    }


}
