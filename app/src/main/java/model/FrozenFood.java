package model;

public class FrozenFood extends Product implements Discountable, Expireable {
    private double suhuPenyimpanan;
    private String tanggalKadaluarsa;

    public FrozenFood(String id, String nama, double harga, int stok, double suhuPenyimpanan, String tanggalKadaluarsa) {
        super(id, nama, harga, stok);
        this.suhuPenyimpanan = suhuPenyimpanan;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public double getSuhuPenyimpanan() { 
        return suhuPenyimpanan; 
    }
    public void setSuhuPenyimpanan(double suhuPenyimpanan) { 
        this.suhuPenyimpanan = suhuPenyimpanan; 
    }

    public String getTanggalKadaluarsa() {
         return tanggalKadaluarsa; 
    }
    public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
         this.tanggalKadaluarsa = tanggalKadaluarsa; 
    }

    @Override
    public String getExpiry() {
        return tanggalKadaluarsa;
    }

    @Override
    public double calculateDiscount(int amount) {
        if (amount >= 8) {
            return getHarga() * amount * 0.08;
        } else if (amount >= 4) {
            return getHarga() * amount * 0.04;
        }
        return 0.0;
    }

    @Override
    public double calculateSubTotal(int amount) {
        return (getHarga() * amount) - calculateDiscount(amount);
    }

    @Override
    public String getProductDetail() {
        return String.format("• Frozen Food [%s] (ID: %s) - Harga: Rp%.0f | Stok: %d | Suhu: %.1f°C | Kadaluarsa: %s",
                getNama(), getId(), getHarga(), getStok(), suhuPenyimpanan, getExpiry());
    }
}