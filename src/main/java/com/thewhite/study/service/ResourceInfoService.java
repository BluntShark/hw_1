package com.thewhite.study.service;

import com.thewhite.study.files.UploadingFiles;
import com.thewhite.study.model.ResourceInfo;
import com.thewhite.study.repository.ResourceInfoRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ResourceInfoService {
    private UploadingFiles files = new UploadingFiles("src/main/resources/description.json");
    Map<Integer, ResourceInfo> map = files.HashMapFromJSONFile();

    public void searchByName(Map<Integer, ResourceInfo> resourceInfo, @NonNull String nameToFind) {
        List<ResourceInfo> list = new ArrayList<>();
        for (Map.Entry<Integer, ResourceInfo> entry : resourceInfo.entrySet()) {
            int id = entry.getKey();
            ResourceInfo data = entry.getValue();
            String name = data.getName();

            if (name != null && name.toLowerCase().contains(nameToFind.toLowerCase())) {
                String description = data.getDescription();
                String link = data.getLink();

                ResourceInfo resource = new ResourceInfo(id, name, description, link);
                list.add(resource);
            }
        }
        if(!list.isEmpty()){
            for (ResourceInfo resource: list) {
                System.out.println(resource);
            }
        }
        else{
            System.out.println("Записи не найдены");
        }
    }

    public void printID(Map<Integer, ResourceInfo> resourceInfo, int idInt) {
        var result = resourceInfo.get(idInt);
        if (result == null) {
            System.out.println("Запись с указанным идентификатором не найдена");
            return;
        }
        System.out.println(result.toString());
    }
    public void printHashMap(Map<Integer, ResourceInfo> resourceInfo) {
        for (Map.Entry<Integer, ResourceInfo> entry : resourceInfo.entrySet()) {
            int id = entry.getKey();
            ResourceInfo data = entry.getValue();
            String name = data.getName();
            String description = data.getDescription();
            String link = data.getLink();

            System.out.println("id: " + id
                    + " name: " + name
                    + " description: " + description
                    + " link: " + link);
        }
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
        printID(map, idInt);
    }
    void find() {
        Scanner display = new Scanner(System.in);
        System.out.println("Введите наименование: ");
        String nameToFind = display.nextLine();
        searchByName(map, nameToFind);
    }
    void displayAll(){
        printHashMap(map);
    }
    void exit(){
        System.out.println("-----До скорой встречи-----");
    }
}
