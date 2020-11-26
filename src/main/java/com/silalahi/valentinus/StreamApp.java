package com.silalahi.valentinus;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {
        Stream<String> names = newStream();
        // menggunakan anonymousClass
//        names
//            .map(
//                new Function<String, String>() {
//                    @Override
//                    public String apply(String s) {
//                        return s.toUpperCase();
//                    }
//                })
//                .forEach(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) {
//                        System.out.println(s);
//                    }
//                });

//        names
//            .map((value)->value.toUpperCase())
//            .forEach((value)-> System.out.println(value));

        names
            .map(String::toUpperCase)
            .forEach(System.out::println);

       /*
       * 1. value list fruits di ubah ke stream
       * 2. di manipulate(map) menjadi upperCase
       * 3. filter awalan "A"
       * 4. di loop dan print value dari filter point 3
       */
        List<String> fruits = newList();
        fruits.stream()
                .map(String::toUpperCase)
                .filter((value)->value.startsWith("A"))
                .forEach(System.out::println);
    }

    public static Stream<String> newStream(){
        return Stream.of("valentinus", "silalahi","sinabutar");
    }

    public static List<String> newList(){
        return Arrays.asList("apel","mangga","jambu","pisang","anggur");
    }
}
