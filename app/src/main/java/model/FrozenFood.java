package model;

import java.time.LocalDate;

public class FrozenFood extends Product implements Discountable, Expireable{
    private String jenis;
    private double berat;
    private String tanggalKadaluarsa;

    public FrozenFood (String id,String nama,double harga,int stok,String jenis,double berat,String tanggalKadaluarsa){
        super(id,nama,harga,stok);
        this.jenis = jenis;
        this.berat = berat;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }
}
