package com.thewhite.study;

import java.util.*;

public class Main {
    public final static Reading reading = new Reading();
    public final static DisplayToScreen displayToScreen = new DisplayToScreen();
    public final static FindAnEntry findAnEntry = new FindAnEntry();
    public static String filePath;
    public static Map<Integer, ResourceInfo<String>> map;


    public static void main(String[] args){
        if (args.length > 0) {
            filePath = args[0];
            System.out.println("Путь до файла: " + filePath);
            map = reading.HashMapFromTextFile();

            int menu = 0;
            while (menu != 4){
                print();

                Scanner in = new Scanner(System.in);
                int option = in.nextInt();

                menu = option;
                getChoice(menu);
            }
        } else{
            System.out.println("Путь до файла не был предоставлен");
        }
    }
    static void print(){
        System.out.println("-----Введите вариант-----");
        System.out.println(
                        "1 - Вывести на экран запись\n" +
                        "2 - Найти записи по части наименования без учёта регистра\n" +
                        "3 - Вывести на экран все записи\n" +
                        "4 - Завершить (закрыть программу)");
    }
    static void getChoice(int menu){
        int a = menu;
        switch (a){
            case 1 -> display();
            case 2 -> find();
            case 3 -> displayAll();
            case 4 -> exit();
            default -> System.out.println("Введено некорректное значение");
        }
    }
    static void display(){
        Scanner display = new Scanner(System.in);
        System.out.println("Введите идентификатор: ");
        int idInt = display.nextInt();
        displayToScreen.printID(map, idInt);
    }
    static void find() {
        Scanner display = new Scanner(System.in);
        System.out.println("Введите наименование: ");
        String nameToFind = display.nextLine();
        findAnEntry.searchByName(map, nameToFind);
    }
    static void displayAll(){
        displayToScreen.printHashMap(map);
    }
    static void exit(){
        System.out.println("-----До скорой встречи-----");
    }
}