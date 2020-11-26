package com.silalahi.valentinus;

public class LambdaInterfaceApp {
    public static void main(String[] args) {

//        ArgsConsumer<String> consumer = (arg) -> printAll(arg);

        ArgsConsumer<String> consumer = LambdaInterfaceApp::printAll;

        consumer.consumer("valentinus", "silalahi", "sinabutar", "belajar-lambda");

    }

    public static void printAll(String[] xxx){
        for (String value : xxx){
            System.out.println(value);
        }
    }

    @FunctionalInterface
    interface ArgsConsumer<T>{

        void consumer(T...arg);

    }
}
