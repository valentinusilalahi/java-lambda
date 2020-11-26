package com.silalahi.valentinus;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaMethodApp {

    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return LamdaMethodApp.isNotNull(s);
//            }
//        };

//        Predicate<String> predicate = (value) -> LamdaMethodApp.isNotNull(value);

        // bisa dipersingkat dengan kondisi parameter nya harus sama dengan parameter yang kita ambil
        Predicate<String> predicate = LamdaMethodApp::isNotNull;

//        Predicate<String> predicate2 = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

//        Predicate<String> predicate1 = (value) -> value.isEmpty();

        Predicate<String> predicate1 = String::isEmpty;

//        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
//            @Override
//            public boolean test(String s, String s2) {
//                return LamdaMethodApp.isEquals(s, s2);
//            }
//        };

//        BiPredicate<String, String> biPredicate = (s1, s2) -> LamdaMethodApp.isEquals(s1, s2);

        BiPredicate<String, String> biPredicate = LamdaMethodApp::isEquals;

//        String hello = "Hei lambda";
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return hello.concat(s);
//            }
//        };

//        String hello = "Hei lambda";
//        Function<String, String> function = (value) -> hello.concat(value);

        String hello = "Hei lambda";
        Function<String, String> function = hello::concat;

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

//        Consumer<String> consumer = (value) -> System.out.println(value);

        Consumer<String> consumer = System.out::println;

    }

    public static boolean isNotNull(String value){
        return value != null;
    }

    public static boolean isEquals(String value1, String value2){
        return value1.equals(value2);
    }
}
