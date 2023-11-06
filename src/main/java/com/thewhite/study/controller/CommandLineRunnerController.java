package com.thewhite.study.controller;

import com.thewhite.study.service.ResourceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
@RequiredArgsConstructor
public class CommandLineRunnerController implements CommandLineRunner {

    private final ResourceInfoService service;
    @Override
    public void run(String... args) {
        int menu = 0;

        while (menu != 4){
            service.print();

            Scanner in = new Scanner(System.in);
            menu = in.nextInt();

            service.getChoice(menu);
        }
    }

}