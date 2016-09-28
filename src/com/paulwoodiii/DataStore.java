package com.paulwoodiii;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 9/27/16.
 */
public class DataStore {
    public static void persist(String filename, List<Person> object){

        File f = new File(filename);
        JsonSerializer serializer = new JsonSerializer();
        PersonWrapper pw = new PersonWrapper();
        ArrayList<Person> list =  new ArrayList();
        list.addAll(object);
        pw.setPeople(list);
        String json = serializer.deep(true).serialize(pw);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't save to file!");
        }
    }

    public static ArrayList<Person> load(String filename){
        File f = new File(filename);
        // read json
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents, 0, fileSize);
            JsonParser parser = new JsonParser();
            PersonWrapper pw2 = parser.parse(contents, PersonWrapper.class);
            System.out.println(pw2);
            return pw2.people;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
