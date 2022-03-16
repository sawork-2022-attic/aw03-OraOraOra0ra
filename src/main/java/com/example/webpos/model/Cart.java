package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public Item getItem(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct() == item.getProduct()) {
                return items.get(i);
            }
        }
        return null;
    }

    public boolean addItem(Item item) {
        for (Item temp : items) {
            if (temp.getProduct() == item.getProduct()) {
                temp.addAmount(item.getAmount());
                if (temp.getAmount() <= 0) {
                    items.remove(getItem(temp));
                }
                return true;
            }
        }
        return items.add(item);
    }

    public boolean deleteItem(Item item) {
        for (Item temp : items) {
            if (temp.getProduct() == item.getProduct()) {
                items.remove(getItem(temp));
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n");

        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append(items.get(i).toString()).append("\n");
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n");

        stringBuilder.append("Total...\t\t\t" + total);

        return stringBuilder.toString();
    }

    public double total() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getAmount() * items.get(i).getProduct().getPrice();
        }
        return total;
    }

    public String sum() {
        double sum = total() * 1.12;
        return String.format("%.1f", sum);
    }

    public boolean cancel() {
        items.clear();
        return true;
    }

    public boolean charge() {
        items.clear();
        return true;
    }
}
