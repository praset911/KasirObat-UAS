package Model;

import java.util.ArrayList;
import entity.entity_transaksi;

public class data_transaksi {
    private ArrayList<entity_transaksi> DBtransaksi = new ArrayList<>();
    int idIncrement = 0;

    public void create(String nipKasir,String tanggal){
        this.DBtransaksi.add(new entity_transaksi(this.idIncrement,tanggal,nipKasir,0));
        this.idIncrement++;
    }

    public void setTotal(int total)
    {
        this.DBtransaksi.get(this.idIncrement-1).setTotal(total);
    }

    public void cetak(int id)
    {
        for(entity_transaksi entity_transaksi : DBtransaksi){
            if(id==entity_transaksi.getId_transaksi()){
                entity_transaksi.cetak();
            }
        }
    }

    public int getIdIncrement() {
        return idIncrement-1;
    }
}
