package model;

public class Buah extends Product implements Discountable,Expireable{
    private double berat;
    private String tanggalKadaluarsa;

    public Buah (String id,String nama,double harga,int stok,double berat,String tanggalKadaluarsa){
        super(id,nama,harga,stok);
        this.berat = berat;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public 

}
