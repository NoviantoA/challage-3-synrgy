package com.novianto.synrgy.challange3.controller;

import com.novianto.synrgy.challange3.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Pesan {
    private List<MenuItem> items = new ArrayList<>();

    public void tambahItem(MenuItem item){
        item.copy().ifPresent(items::add);
    }

    public void hapusItem(MenuItem item){
        items.removeIf(menuItem -> menuItem.getNama().equals(item.getNama()));
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public int hitungTotalHarga(){
        return items.stream()
                .mapToInt(MenuItem::getTotalHarga)
                .sum();
    }
}
