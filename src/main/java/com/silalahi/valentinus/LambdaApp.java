package com.silalahi.valentinus;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaApp {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s != null;
            }
        };

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        System.out.println(predicate);
        System.out.println(function);
    }
}
