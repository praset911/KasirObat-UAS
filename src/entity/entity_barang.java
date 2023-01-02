package entity;

public class entity_barang {
    public String merk;
    public int harga;

    public entity_barang(String merk, int harga) {
        this.merk = merk;
        this.harga = harga;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void cetak(){
        System.out.println("MERK  : " + merk);
        System.out.println("HARGA : " + harga);
    }
}
