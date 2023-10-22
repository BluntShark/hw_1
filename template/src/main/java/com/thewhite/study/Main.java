package com.thewhite.study;

import java.util.*;

public class Main {
    public final static Reading reading = new Reading();
    public final static DisplayToScreen displayToScreen = new DisplayToScreen();
    public final static FindAnEntry findAnEntry = new FindAnEntry();

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.setChoice("0");

        while (!menu.getChoice().equals("4")){
            print();

            Scanner in = new Scanner(System.in);
            String option = in.nextLine();

            menu.setChoice(option);
            getChoice(menu);
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
    static void getChoice(Menu menu){
        String a = menu.getChoice();
        switch (a){
            case "1" -> display();
            case "2" -> find();
            case "3" -> displayAll();
            case "4" -> exit();
            default -> System.out.println("Введено некорректное значение");
        }
    }
    static void display(){
        Scanner display = new Scanner(System.in);
        System.out.println("Введите идентификатор: ");
        int idInt = display.nextInt();
        displayToScreen.printID(reading.HashMapFromTextFile(), idInt);
    }
    static void find() {
        Scanner display = new Scanner(System.in);
        System.out.println("Введите наименование: ");
        String nameToFind = display.nextLine();

        findAnEntry.searchByName(reading.HashMapFromTextFile(), nameToFind);
    }
    static void displayAll(){
        displayToScreen.printHashMap(reading.HashMapFromTextFile());
    }
    static void exit(){
        System.out.println("-----До скорой встречи-----");
    }
}