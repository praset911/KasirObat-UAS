package entity;

public class entity_detTransaksi {
    private int id_transaksi;
    private int jumlah;
    private entity_obat obat;
    private int total;

    public entity_detTransaksi(int id_transaksi, int jumlah, entity_obat obat) {
        this.id_transaksi = id_transaksi;
        this.jumlah = jumlah;
        this.obat = obat;
        this.total = jumlah*obat.getHarga();
    }

    public int getTotal() {
        return total;
    }

    public void cetak()
    {
        System.out.println("id transaksi :"+this.id_transaksi);
        System.out.println("jumlah :"+ this.jumlah);
        System.out.println("id barang :"+obat.getKodeBarang());
        System.out.println("nama barang :"+obat.getMerk());
        System.out.println("harga    :"+obat.getHarga());
        System.out.println("total :"+this.jumlah*obat.getHarga());
        System.out.println("================================");
    }

    public int getId_transaksi() {
        return id_transaksi;
    }
}
