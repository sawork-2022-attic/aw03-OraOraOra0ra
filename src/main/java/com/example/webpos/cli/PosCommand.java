//package com.example.webpos.cli;
//
//import com.example.webpos.biz.PosService;
//import com.example.webpos.model.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//
//@ShellComponent
//public class PosCommand {
//
//    private PosService posService;
//
//    @Autowired
//    public void setPosService(PosService posService) {
//        this.posService = posService;
//    }
//
//    @ShellMethod(value = "List Products", key = "p")
//    public String products() {
//        StringBuilder stringBuilder = new StringBuilder();
//        int i = 0;
//        for (Product product : posService.products()) {
//            stringBuilder.append("\t").append(++i).append("\t").append(product).append("\n");
//        }
//        return stringBuilder.toString();
//    }
//
//    @ShellMethod(value = "New Cart", key = "n")
//    public String newCart() {
//        return posService.newCart() + " OK";
//    }
//
//    @ShellMethod(value = "Add a Product to Cart", key = "a")
//    public String addToCart(String productId, int amount) {
//        if (posService.add(productId, amount)) {
//            return posService.getCart().toString();
//        }
//        return "ERROR";
//    }
//}
