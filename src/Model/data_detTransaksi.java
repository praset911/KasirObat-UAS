package Model;
import entity.entity_detTransaksi;
import entity.entity_obat;
import java.util.ArrayList;

public class data_detTransaksi {
    private ArrayList<entity_detTransaksi> detTr=new ArrayList<>();

    public void create(int idTransaksi, int jumlah, entity_obat obat){
        detTr.add(new entity_detTransaksi(idTransaksi,jumlah,obat));
    }

    public void view_byId(int idTransaksi)
    {
        for(entity_detTransaksi detTransaksi : detTr){
            if(idTransaksi==detTransaksi.getId_transaksi()){
                detTransaksi.cetak();
            }
        }
    }

    public void view()
    {
        for(entity_detTransaksi detTransaksi : detTr){
            detTransaksi.cetak();

        }
    }

    public int getTotalbyId(int idTransaksi)
    {
        int total = 0;
        for(entity_detTransaksi detTransaksi : detTr){
            if(idTransaksi==detTransaksi.getId_transaksi()){
                total = total + detTransaksi.getTotal();
            }
        }
        return total;
    }
}
