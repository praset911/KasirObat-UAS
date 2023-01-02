package entity;

public class entity_obat extends entity_barang{
    public int jumlah;
    public int kodeBarang;

    public entity_obat(String merk, int harga, int jumlah,int kodeBarang) {
        super(merk, harga);
        this.jumlah = jumlah;
        this.kodeBarang=kodeBarang;
    }

    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public int getKodeBarang(){
        return kodeBarang;
    }

    public void cetak(){
        super.cetak();
        System.out.println("JUMLAH : "+ getJumlah());
        System.out.println("KODE BARANG : "+getKodeBarang());
    }
}
