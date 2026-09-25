package controller;

import model.*;
import view.ProductView;
import view.InputUtil;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private final List<Product> listProducts;
    private final ProductView view;

    public ProductController(ProductView view) {
        this.listProducts = new ArrayList<>();
        this.view = view;
    }

    public void start() {
        boolean running = true;

        while (running) {
            view.showMainMenu();
            int pilihan = InputUtil.readInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahPerangkat();
                    break;
                case 2:
                    view.printProductList(listProducts);
                    break;
                case 3:
                    running = false;
                    view.showMessage("Terima kasih telah menggunakan sistem Smart Home.");
                    break;
                default:
                    view.showMessage("Pilihan tidak valid!");
            }
        }
    }

    private void tambahPerangkat() {
        view.showSubMenu();
        int subPilihan = InputUtil.readInt("Pilih tipe perangkat: ");

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
                view.showMessage("Tipe produk tidak ditemukan!");
        }
    }

    private void tambahMie() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double harga = InputUtil.readDouble("Masukkan Harga: ");
        int stok = InputUtil.readInt("Masukkan stok: ");
        String rasa = InputUtil.readString("Masukkan Rasa: ");
        double berat  = InputUtil.readDouble("Masukkan Jenis: ");

        Mie mie = new Mie(id, nama, harga, stok, rasa, berat);
        listProducts.add(mie);
        view.showMessage("Mie berhasil ditambahkan!");
    }

    private void tambahBuah() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double harga = InputUtil.readDouble("Masukkan Harga: ");
        int stok = InputUtil.readInt("Masukkan stok: ");
        double berat = InputUtil.readDouble("Masukkan Berat: ");

        String connInput = InputUtil.readString("Pilih Jenis (LOKAL/IMPORT): ");
        JENIS jenis = connInput.equalsIgnoreCase("LOKAL") ? JENIS.LOKAL : JENIS.IMPORT;

        Buah buah = new Buah(id,nama,harga,stok,berat,);

        String st = InputUtil.readString("Nyalakan perangkat sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            speaker.turnOn();
        } else {
            speaker.turnOf();
        }

        listDevice.add(speaker);
        view.showMessage("Smart Speaker berhasil ditambahkan!");
    }

    private void tambahFrozenFood() {
        String id = InputUtil.readString("Masukkan ID: ");
        String nama = InputUtil.readString("Masukkan Nama: ");
        double daya = InputUtil.readDouble("Masukkan Daya (W): ");
        String pin = InputUtil.readString("Masukkan PIN asli: ");

        SmartDoorLock lock = new SmartDoorLock(id, nama, daya, pin);

        String st = InputUtil.readString("Kunci pintu sekarang? (y/n): ");
        if (st.equalsIgnoreCase("y")) {
            lock.lock();
        } else {
            lock.unlock();
        }

        listProducts.add(lock);
        view.showMessage("Smart Door Lock berhasil ditambahkan!");
    }
}