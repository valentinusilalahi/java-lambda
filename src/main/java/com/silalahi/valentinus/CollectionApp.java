package com.silalahi.valentinus;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CollectionApp {
    public static void main(String[] args) {
        List<String> list = createList();
        //foreach biasa
//        for (String value : list){
//            System.out.println(value);
//        }

        // anonymousClass
//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        list.forEach((value)-> System.out.println(value));

        //foreach dengan lambda lebih singkat
        list.forEach(System.out::println);

        Map<String, String> map = createMap();

        // perulangan dalam map dengan biasa
//        for (Map.Entry<String, String> entry : map.entrySet()){
//            System.out.println(entry.getKey()+" : "+entry.getValue());
//        }

        // perulangan dalam map dengan anonymousClass
//        map.forEach(new BiConsumer<String, String>() {
//            @Override
//            public void accept(String s, String s2) {
//                System.out.println(s+" : "+s2);
//            }
//        });

        // perulangan dalam map menggunakan lambda
//        map.forEach((key, value)-> System.out.println(key+" : "+value));
        map.forEach(CollectionApp::printEntry);
    }

    public static void printEntry(String key, String value){
        System.out.println(key+" : "+value);
    }

    public static List<String> createList(){
        return Arrays.asList("valentinus", "silalahi","sinabutar");
    }

    public static Map<String, String> createMap(){
        Map<String, String> map = new HashMap<>();
        map.put("a","valentinus");
        map.put("b","silalahi");
        map.put("c","sinabutar");
        return map;
    }
}
