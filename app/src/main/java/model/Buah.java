package model;

public class Buah extends Product implements Discountable, Expireable {
    private JENIS jenis;
    private double berat;
    private String tanggalKadaluarsa;

    public Buah(String id, String nama, double harga, int stok, JENIS jenis, double berat, String tanggalKadaluarsa) {
        super(id, nama, harga, stok);
        this.jenis = jenis;
        this.berat = berat;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public JENIS getJenis() { return jenis; }
    public void setJenis(JENIS jenis) { this.jenis = jenis; }

    public double getBerat() { return berat; }
    public void setBerat(double berat) { this.berat = berat; }

    public String getTanggalKadaluarsa() { return tanggalKadaluarsa; }
    public void setTanggalKadaluarsa(String tanggalKadaluarsa) { this.tanggalKadaluarsa = tanggalKadaluarsa; }

    @Override
    public String getExpiry() {
        return tanggalKadaluarsa;
    }

    @Override
    public double calculateDiscount(int amount) {
        if (amount >= 15) {
            return getHarga() * amount * 0.05;
        } else if (amount >= 10) {
            return getHarga() * amount * 0.03;
        } else if (amount >= 5) {
            return getHarga() * amount * 0.02;
        }
        return 0.0;
    }

    @Override
    public double calculateSubTotal(int amount) {
        return (getHarga() * amount) - calculateDiscount(amount);
    }

    @Override
    public String getProductDetail() {
        String jenisStr = (jenis == JENIS.IMPORT) ? "Import" : "Lokal";
        return String.format("• Buah-buahan [%s] (ID: %s) - Harga: Rp%.0f | Stok: %d | Jenis: %s | Berat: %.1fkg | Kadaluarsa: %s",
                getNama(), getId(), getHarga(), getStok(), jenisStr, berat, getExpiry());
    }
}