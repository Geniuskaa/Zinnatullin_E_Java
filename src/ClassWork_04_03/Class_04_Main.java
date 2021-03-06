package ClassWork_04_03;

import ClassWork_16_02.Stack;

import java.io.File;

public class Class_04_Main {
    public static void main(String[] args) {
        File root = new File("C:\\DIS");

        //System.out.println(root.listFiles()[0].getName());
        printNameOfFilesStack(root);


    }



    static void printNameOfFilesStack(File root) {
        Stack<File> stack = new Stack<>();
        stack.push(root);

        while(stack.peek().isDirectory()) {
            for(int i = 0; i < stack.peek().listFiles().length; i++) {
                if (stack.peek().listFiles()[i].isDirectory()) {
                    stack.push(root.listFiles()[i]);
                }else {
                    System.out.println(stack.peek().listFiles()[i].getName());
                }
            }
        }
    }


}






        


