package ClassWork_04_03;

import java.util.*;

import java.io.File;

public class Class_04_Main {
    public static void main(String[] args) {
        File root = new File("C:\\Project");

        printNameOfFilesStack(root); // Добавил счётчик файлов, чтобы сравнить правильность работы функций
        printNameOfFilesQueue(root);
        int countOfFiles = printNameOfFilesRecursive(root);
        System.out.printf("Через рекурсию насчитали %d файл\n", countOfFiles);


    }



    static void printNameOfFilesStack(File root) {
        Stack<File> stack = new Stack<>();
        stack.push(root);
        int counter = 0;

        try {
            while(stack.peek().isDirectory()) {
                System.out.println("Файлы из папки: " + stack.peek().getName());
                File[] allFiles = stack.pop().listFiles();
                if (allFiles == null) {
                    System.out.println("Эта папка пуста!");
                    continue;
                }

                for(int i = 0; i < allFiles.length; i++) {
                    if (allFiles[i].isDirectory()) {
                        stack.push(allFiles[i]);
                    }else {
                        counter++;
                        System.out.println(allFiles[i].getName());
                    }
                }
            }
        }catch (EmptyStackException e){
        }
        System.out.println("Файлов было насчитано: " + counter);
    }

    static void printNameOfFilesQueue(File root){
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(root);
        int counter = 0;

        try {
            while(queue.peek().isDirectory()) {
                System.out.println("Файлы из папки: " + queue.peek().getName());
                File[] allFiles = queue.pop().listFiles();
                if (allFiles == null) {
                    System.out.println("Эта папка пуста!");
                    continue;
                }

                for(int i = 0; i < allFiles.length; i++) {
                    if (allFiles[i].isDirectory()) {
                        queue.push(allFiles[i]);
                    }else {
                        counter++;
                        System.out.println(allFiles[i].getName());
                    }
                }
            }
        }catch (RuntimeException e){
        }
        System.out.println("Файлов было насчитано: " + counter);
    }

    static int printNameOfFilesRecursive(File root){
        int counter = 0;
        if (root.isDirectory()){
            try {
                System.out.println("Файлы из папки: " + root.getName());
                for(int i = 0; i < root.listFiles().length; i++){
                    if (root.listFiles()[i].isDirectory()){
                        counter += printNameOfFilesRecursive(root.listFiles()[i]);
                    }

                    if (root.listFiles()[i].isFile()) {
                        counter++;
                        System.out.println(root.listFiles()[i].getName());
                    }
                }
            }catch (RuntimeException e){
            }

        }
        return counter;
    }


}






        


