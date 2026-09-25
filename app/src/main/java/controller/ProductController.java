package controller;

import model.*;
import view.InputUtil;
import view.ProductView;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private final List<Product> listProduct;
    private final ProductView view;

    public ProductController(ProductView view) {
        this.listProduct = new ArrayList<>();
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMainMenu();
            int pilihan = InputUtil.readInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahProdukFlow();
                    break;
                case 2:
                    view.printProductList(listProduct);
                    break;
                case 3:
                    running = false;
                    view.showMessage("Terima kasih telah menggunakan sistem Mini Market.");
                    break;
                default:
                    view.showMessage("Pilihan tidak valid!");
            }
        }
    }

    private void tambahProdukFlow() {
        view.showSubMenu();
        int subPilihan = InputUtil.readInt("Pilih kategori produk: ");

        switch (subPilihan) {
            case 1:
                tambahMie();
                break;
            case 2:
                tambahBuah();
                break;
            case 3:
                tambahFrozenFood();
                break;
            default:
                view.showMessage("Kategori produk tidak ditemukan!");
        }
    }

    private void tambahMie() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double harga = InputUtil.readDouble("Masukkan Harga (Rp): ");
        int stok = InputUtil.readInt("Masukkan Stok: ");
        String rasa = InputUtil.readString("Masukkan Rasa: ");
        double berat = InputUtil.readDouble("Masukkan Berat (gram): ");

        Mie mie = new Mie(id, nama, harga, stok, rasa, berat);
        listProduct.add(mie);
        view.showMessage("Produk Mie berhasil ditambahkan!");
    }

    private void tambahBuah() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double harga = InputUtil.readDouble("Masukkan Harga (Rp): ");
        int stok = InputUtil.readInt("Masukkan Stok: ");
        
        String inputJenis = InputUtil.readString("Masukkan Jenis (Lokal/Import): ");
        JENIS jenis = inputJenis.equalsIgnoreCase("Import") ? JENIS.IMPORT : JENIS.LOKAL;

        double berat = InputUtil.readDouble("Masukkan Berat (kg): ");
        String tglKadaluarsa = InputUtil.readString("Masukkan Tanggal Kadaluarsa (YYYY-MM-DD): ");

        Buah buah = new Buah(id, nama, harga, stok, jenis, berat, tglKadaluarsa);
        listProduct.add(buah);
        view.showMessage("Produk Buah-buahan berhasil ditambahkan!");
    }

    private void tambahFrozenFood() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double harga = InputUtil.readDouble("Masukkan Harga (Rp): ");
        int stok = InputUtil.readInt("Masukkan Stok: ");
        double suhu = InputUtil.readDouble("Masukkan Suhu Penyimpanan (°C): ");
        String tglKadaluarsa = InputUtil.readString("Masukkan Tanggal Kadaluarsa (YYYY-MM-DD): ");

        FrozenFood frozen = new FrozenFood(id, nama, harga, stok, suhu, tglKadaluarsa);
        listProduct.add(frozen);
        view.showMessage("Produk Frozen Food berhasil ditambahkan!");
    }
}