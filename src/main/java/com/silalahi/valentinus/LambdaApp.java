package com.silalahi.valentinus;

import java.util.function.*;

public class LambdaApp {
    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s != null;
//            }
//        };

        // implementasi lambda expresion
//        Predicate<String> predicate = (value) -> {
//            return value != null;
//        };

        // persingkat lambda bisa seperti dibawah jika code nya 1 line.
        Predicate<String> predicate =  (value) -> value != null;

//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        };

//        Function<String, String> function =  (value) -> {
//            return value.toUpperCase();
//        };

        Function<String, String> function = (value) -> value.toUpperCase();

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

//        Consumer<String> consumer = (value) ->{
//            System.out.println(value);
//        };

        Consumer<String> consumer = (value) -> System.out.println(value);


//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "valentinus belajar lambda expressions";
//            }
//        };

//        Supplier<String> supplier = () -> {
//            return "valentinus belajar lambda expression";
//        };

        Supplier<String> supplier = () -> "valentinus belajar lambda expression";

//        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
//            @Override
//            public boolean test(String s, String s2) {
//                return s.equals(s2);
//            }
//        };

//        BiPredicate<String, String> biPredicate = (value1, value2) -> {
//            return value1.equals(value2);
//        };

        BiPredicate<String, String> biPredicate = (value1, value2) -> value1.equals(value2);

    }
}
