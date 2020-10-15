package com.example.autowiredemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {
    private String fileName="/Users/inouetakayuki/java_practice/spring_hibernate_for_beginners/springdemoannotations/src/main/resources/fortune-data.txt";
    private List<String> theFortunes;

    private Random myRandom = new Random();

    public FileFortuneService() {
        System.out.println(">> FileFortuneService: inside default constructor");
    }

    @PostConstruct
    public void loadTheFortunesFile() {
        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

        File theFile = new File(fileName);

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        // initialize array list
        theFortunes = new ArrayList<String>();

        try(BufferedReader br = new BufferedReader(new FileReader(theFile))) {
            String tempLine;

            while ((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(theFortunes.size());

        return theFortunes.get(index);
    }
}
