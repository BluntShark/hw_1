package com.thewhite.study.service;

import com.thewhite.study.model.ResourceInfo;
import com.thewhite.study.repository.ResourceInfoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResourceInfoService {
    private ResourceInfoRepository repository;
    @Autowired
    public ResourceInfoService(ResourceInfoRepository repository){
        this.repository = repository;
    }
    public void searchByName(@NonNull String nameToFind) {
        List<ResourceInfo> list = repository.searchByName(nameToFind);
        if(!list.isEmpty()){
            for (ResourceInfo resource: list) {
                System.out.println(resource);
            }
        }
        else{
            System.out.println("Записи не найдены");
        }
    }

    public void printID(int idInt) {
        var result = repository.printID(idInt);
        if (result == null) {
            System.out.println("Запись с указанным идентификатором не найдена");
            return;
        }
        System.out.println(result.toString());
    }
    public void print(){
        System.out.println("-----Введите вариант-----");
        System.out.println(
                "1 - Вывести на экран запись\n" +
                        "2 - Найти записи по части наименования без учёта регистра\n" +
                        "3 - Вывести на экран все записи\n" +
                        "4 - Завершить (закрыть программу)");
    }
    public void getChoice(int menu){
        switch (menu){
            case 1 -> display();
            case 2 -> find();
            case 3 -> displayAll();
            case 4 -> exit();
            default -> System.out.println("Введено некорректное значение");
        }
    }
    void display(){
        Scanner display = new Scanner(System.in);
        System.out.println("Введите идентификатор: ");
        int idInt = display.nextInt();
        printID(idInt);
    }
    void find() {
        Scanner display = new Scanner(System.in);
        System.out.println("Введите наименование: ");
        String nameToFind = display.nextLine();
        searchByName(nameToFind);
    }
    void displayAll(){
        repository.printHashMap();;
    }
    void exit(){
        System.out.println("-----До скорой встречи-----");
    }
}
