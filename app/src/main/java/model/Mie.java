package model;

public class Mie extends MiniMarket implements Discountable {
    private String rasa;
    private double berat;

    public Mie (String id,String nama,double harga,int stok,String rasa,double berat){
        super(id,nama,harga,stok);
        this.rasa = rasa;
        this.berat = berat;
    }

    
}
