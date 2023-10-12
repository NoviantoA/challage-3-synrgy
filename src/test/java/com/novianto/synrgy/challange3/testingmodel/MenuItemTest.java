package com.novianto.synrgy.challange3.testingmodel;

import com.novianto.synrgy.challange3.model.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuItemTest {
    private MenuItem menuItem;

    @BeforeEach
    public void setUp() {
        menuItem = new MenuItem("Nasi Goreng", 15000);
    }

    @Test
    public void testGetTotalHarga() {
        menuItem.setJumlah(2);
        assertEquals(30000, menuItem.getTotalHarga());
    }

    @Test
    public void testGetNama() {
        assertEquals("Nasi Goreng", menuItem.getNama());
    }

    @Test
    public void testGetHarga() {
        assertEquals(15000, menuItem.getHarga(), 0.01);
    }

    @Test
    public void testGetJumlah() {
        menuItem.setJumlah(3);
        assertEquals(3, menuItem.getJumlah());
    }

}
