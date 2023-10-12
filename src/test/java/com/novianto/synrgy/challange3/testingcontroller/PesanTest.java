package com.novianto.synrgy.challange3.testingcontroller;

import com.novianto.synrgy.challange3.controller.Pesan;
import com.novianto.synrgy.challange3.model.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PesanTest {
    private Pesan pesan;

    @BeforeEach
    public void setUp() {
        pesan = new Pesan();
    }

    @Test
    public void testTambahItem() {
        MenuItem menuItem = new MenuItem("Nasi Goreng", 15000);
        pesan.tambahItem(menuItem);
        List<MenuItem> items = pesan.getItems();
        assertEquals(1, items.size());
    }

    @Test
    public void testHapusItem() {
        MenuItem menuItem = new MenuItem("Nasi Goreng", 15000);
        pesan.tambahItem(menuItem);
        pesan.hapusItem(menuItem);
        List<MenuItem> items = pesan.getItems();
        assertEquals(0, items.size());
    }

    @Test
    public void testHitungTotalHarga() {
        MenuItem menuItem1 = new MenuItem("Nasi Goreng", 15000);
        MenuItem menuItem2 = new MenuItem("Mie Goreng", 13000);
        pesan.tambahItem(menuItem1);
        pesan.tambahItem(menuItem2);
        int totalHarga = pesan.hitungTotalHarga();
        assertEquals(28000, totalHarga);
    }
}
