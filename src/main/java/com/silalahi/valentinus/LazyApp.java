package com.silalahi.valentinus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LazyApp {

    private static ProductService productService = new ProductService();

    // parameter eager loading
//    public static void main(String[] args) {
//        Product product1 = findOrCreate("1", productService.createNewProduct("1"));
//        System.out.println(product1);
//
//        Product product2 = findOrCreate("2", productService.createNewProduct("2"));
//        System.out.println(product2);
//
//        Product product1Lagi = findOrCreate("1", productService.createNewProduct("1"));
//        System.out.println(product1Lagi);
//    }
//
//    public static Product findOrCreate(String id, Product newProduct){
//        Product product = productService.findById(id);
//        if(product != null){
//            return product;
//        }else {
//            return newProduct;
//        }
//    }

    // penggunaan lambda untuk lazy parameter
    public static void main(String[] args) {
        Product product1 = findOrCreate("1", () -> productService.createNewProduct("1"));
        System.out.println(product1);

        Product product2 = findOrCreate("2", () -> productService.createNewProduct("2"));
        System.out.println(product2);

        Product product1Lagi = findOrCreate("1", () -> productService.createNewProduct("1"));
        System.out.println(product1Lagi);
    }

    public static Product findOrCreate(String id, Supplier<Product> newProduct){
        Product product = productService.findById(id);
        if(product != null){
            return product;
        }else {
            return newProduct.get();
        }
    }

    public static class ProductService{

        private Map<String, Product> database = new HashMap<>();

        public Product findById(String id){
            return database.get(id);
        }

        public Product createNewProduct(String id){
            Product product = new Product(id, null);
            System.out.println("CREATE NEW");
            database.put(id, product);
            return product;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Product{
        private String id;
        private String name;
    }
}
