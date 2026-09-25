package view;

import model.*;
import java.util.List;

public class ProductView {

    public void showMainMenu() {
        System.out.println("\n=== MENU UTAMA MiniMarket ===");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Print Semua Produk");
        System.out.println("3. Keluar");
    }

    public void showSubMenu() {
        System.out.println("\n--- TAMBAH PERANGKAT ---");
        System.out.println("1. Mie");
        System.out.println("2. Buah-Buahan");
        System.out.println("3. Frozen Food");
    }

    public void printProductList(List<Product> products) {
        System.out.println("\n=== DAFTAR PRODUK MINIMARKET ===");
        if (products.isEmpty()) {
            System.out.println("Belum ada produk yang terdaftar.");
            return;
        }

        for (Product produk : products) {
            System.out.println("• " + product);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}