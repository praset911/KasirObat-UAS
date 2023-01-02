package Model;
import entity.entity_obat;

import java.util.ArrayList;

public class data_obat {

    static ArrayList<entity_obat> obat = new ArrayList<>();

    public static void initialObat(){
        obat.add(new entity_obat("ctm",1,1,001));
        obat.add(new entity_obat("antimo",2,2,002));
    }

    public static void view(){
        for (entity_obat obat : obat){
            obat.cetak();
        }
    }

    public static void createProduct(String merk,int harga,int jumlah,int kodeBarang){
        obat.add(new entity_obat(merk,harga,jumlah,kodeBarang));
    }

    public static void delProduct(entity_obat obat1){
        obat.remove(obat1);
    }

    public static entity_obat cariDataProduk(int kodeBarang){
        for (entity_obat cariObat : obat){
            if(cariObat.getKodeBarang() == kodeBarang ){
                return cariObat;
            }
        }
        return null;
    }

    public static void updateByKode(entity_obat obat , int kode){
        entity_obat obat1 = cariDataProduk(kode);
        obat1.setMerk(obat.merk);
        obat1.setJumlah(obat.jumlah);
        obat1.setHarga(obat.harga);
    }

}
