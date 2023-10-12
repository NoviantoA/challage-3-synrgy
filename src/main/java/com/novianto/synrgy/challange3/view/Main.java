package com.novianto.synrgy.challange3.view;

import com.novianto.synrgy.challange3.controller.Pesan;
import com.novianto.synrgy.challange3.model.MenuItem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<MenuItem> menuItems = new ArrayList<>();
    private static Pesan pesan = new Pesan();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        inisialisasiMenu();

        while (true) {
            tampilkanMainMenu();
            int choice = getPilihanUser(0, 99);

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    prosesMenuItem(choice);
                    break;
                case 99:
                    if (pesan.getItems().isEmpty()) {
                        System.out.println("Anda belum memesan apapun. Silakan pesan terlebih dahulu.");
                    } else {
                        prosesPesan();
                        resetPesanan();
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan BinarFud. Sampai jumpa lagi!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Input tidak valid. Mohon masukkan pilihan yang sesuai.");
            }
        }
    }

    private static void inisialisasiMenu(){
        menuItems.add(new MenuItem("Nasi Goreng", 15000));
        menuItems.add(new MenuItem("Mie Goreng", 13000));
        menuItems.add(new MenuItem("Nasi + Ayam", 18000));
        menuItems.add(new MenuItem("Es Teh Manis", 3000));
        menuItems.add(new MenuItem("Es Jeruk", 5000));
    }

    private static void tampilkanMainMenu() {
        System.out.println("============================");
        System.out.println("Selamat Datang di BinarFud");
        System.out.println("============================");
        System.out.println("Silahkan pilih makanan :");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getNama() + " | " + item.getHarga());
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar");
    }

    private static void prosesMenuItem(int menuItemIndex) {
        MenuItem itemTerpilih = menuItems.get(menuItemIndex - 1);
        System.out.println("=====================");
        System.out.println("Berapa Pesanan Anda");
        System.out.println("=====================");
        System.out.println(itemTerpilih.getNama() + " | " + itemTerpilih.getHarga());
        System.out.print("qty => ");

        int jumlah = getPilihanUser(0, Integer.MAX_VALUE);
        if (jumlah > 0) {
            itemTerpilih.setJumlah(jumlah);
            pesan.tambahItem(itemTerpilih);
            System.out.println("Pesanan " + itemTerpilih.getNama() + " sejumlah " + jumlah + " berhasil ditambahkan.");
        } else {
            System.out.println("Pesan minimal 1.");
        }
    }

    private static void prosesPesan() {
        System.out.println("==================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("==================");
        for (MenuItem item : pesan.getItems()) {
            System.out.println(item.getNama() + "   " + item.getJumlah() + "   " + item.getTotalHarga());
        }
        System.out.println("------------------------------  +");
        System.out.println("Total         " + pesan.getItems().size() + "   " + pesan.hitungTotalHarga());

        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar aplikasi");

        int pilihan = getPilihanUser(0, 2);
        if (pilihan == 1) {
            generateStruk();
        }
    }

    private static void generateStruk() {
        System.out.println("============= BinarFud =============");
        System.out.println("Terimakasih telah memesan di BinarFud");
        System.out.println("Dibawah ini adalah pesanan anda");

        for (MenuItem item : pesan.getItems()) {
            System.out.println(item.getNama() + "   " + item.getJumlah() + "   " + item.getTotalHarga());
        }
        System.out.println("------------------------------  +");
        System.out.println("Total         " + pesan.getItems().size() + "   " + pesan.hitungTotalHarga());
        System.out.println("Pembayaran : BinarCash");
        System.out.println("==================");
        System.out.println("Simpan Struk ini sebagai bukti pembayaran");

        fileStruk();
    }

    private static void fileStruk() {
        try {
            FileWriter fileWriter = new FileWriter("struk_pembayaran.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("============= BinarFud =============");
            printWriter.println("Terimakasih telah memesan di BinarFud");
            printWriter.println("Dibawah ini adalah pesanan anda");

            for (MenuItem item : pesan.getItems()) {
                printWriter.println(item.getNama() + "   " + item.getJumlah() + "   " + item.getTotalHarga());
            }
            printWriter.println("------------------------------  +");
            printWriter.println("Total         " + pesan.getItems().size() + "   " + pesan.hitungTotalHarga());
            printWriter.println("Pembayaran : BinarCash");
            printWriter.println("==================");
            printWriter.println("Simpan Struk ini sebagai bukti pembayaran");

            printWriter.close();
            System.out.println("Struk pembayaran telah disimpan sebagai 'struk_pembayaran.txt'");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan struk pembayaran.");
        }
    }

    private static void resetPesanan() {
        pesan = new Pesan();
    }

    private static int getPilihanUser(int min, int max) {
        int pilih;
        while (true) {
            try {
                pilih = Integer.parseInt(scanner.nextLine());
                if (pilih >= min && pilih <= max) {
                    return pilih;
                } else {
                    System.out.println("Mohon masukkan pilihan yang sesuai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mohon masukkan angka.");
            }
        }
    }
}
