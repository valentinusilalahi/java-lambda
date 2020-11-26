package com.silalahi.valentinus;

import java.util.function.*;

public class LambdaProgram {
    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s != null;
//            }
//        };

        Predicate<String> predicate = (value) -> value != null;
        System.out.println(predicate.test("lambda"));
        System.out.println(predicate.test(null));

//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        };

        Function<String, String> function = (value) -> value.toUpperCase();
        System.out.println(function.apply("valentinus"));
        System.out.println(function.apply("silalahi"));

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println("menggunakan lambda expresion");
//            }
//        };

        Consumer<String> consumer = (value) -> System.out.println(value);
        consumer.accept("menggunakan lambda expression");
        consumer.accept("valentinus belajar lambda!");

//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "valentinus silalahi";
//            }
//        };

        Supplier<String> supplier = () -> "http://valentinusilalahi.herokuapp.com";
        System.out.println(supplier.get());

//        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
//            @Override
//            public boolean test(String s, String s2) {
//                return s.equals(s2);
//            }
//        };

        BiPredicate<String, String> biPredicate = (value1, value2) -> value1.equals(value2);
        System.out.println(biPredicate.test("valentinus", "valentinus"));
        System.out.println(biPredicate.test("valentinus", "silalahi"));

//        Supplier<String> stringSupplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "valentinus silalahi";
//            }
//        };
//
//        printLambda(stringSupplier);

//        printLambda(new Supplier<String>() {
//            @Override
//            public String get() {
//                return "sample anonymousClass";
//            }
//        });

//        Supplier<String> lambdaSupplier = () -> "sample lambda supplier";
//        printLambda(lambdaSupplier);

        printLambda(()->"lebih simple lambda supplier");

    }

    public static void printLambda(Supplier<String> supplier){
        System.out.println(supplier.get());
    }
}
