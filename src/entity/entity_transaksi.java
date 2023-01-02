package entity;

public class entity_transaksi {
    private int id_transaksi;
    private String tanggal;
    private String id_kasir;
    private int total = 0;

    public entity_transaksi(int id_transaksi, String tanggal, String id_kasir, int total) {
        this.id_transaksi = id_transaksi;
        this.tanggal = tanggal;
        this.id_kasir = id_kasir;
        this.total = total;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void cetak()
    {
        System.out.println("id transaksi    :"+this.id_transaksi);
        System.out.println("tanggal         :"+this.tanggal);
        System.out.println("id_kasir        :"+this.id_kasir);
        System.out.println("total           :"+this.total);
    }
}
