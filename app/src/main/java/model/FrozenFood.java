package model;

import java.time.LocalDate;

public class FrozenFood extends Product implements Discountable, Expireable{
    private double suhuPenyimpanan;
    private String tanggalKadaluarsa;

    public FrozenFood (String id,String nama,double harga,int stok,double suhuPenyimpanan,String tanggalKadaluarsa){
        super(id,nama,harga,stok);
        this.suhuPenyimpanan = suhuPenyimpanan;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }
}
