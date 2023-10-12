package com.novianto.synrgy.challange3.model;

import java.util.Optional;

public class MenuItem {
    private String nama;
    private double harga;
    private int jumlah;

    public MenuItem(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = 0;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotalHarga() {
        return (int) (harga * jumlah);
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Optional<MenuItem> copy() {
        MenuItem copy = new MenuItem(this.nama, this.harga);
        copy.setJumlah(this.jumlah);
        return Optional.of(copy);
    }
}
