package View;

import Controller.LoginController;
import Model.data_detTransaksi;
import Model.data_obat;
import Model.data_transaksi;
import entity.entity_obat;
import utils.DateString;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffPage {
    static data_transaksi DB_Transaksi = new data_transaksi();
    static data_detTransaksi DB_DetTr = new data_detTransaksi();
    LoginController authentication = new LoginController();
    Scanner input = new Scanner(System.in);
    public void LoginStaff(){
        boolean status = false;
        do {
            System.out.print("NIP  : ");
            String nip = input.nextLine();
            System.out.print("PASS : ");
            String pass = input.nextLine();
            status = authentication.loginStaff(nip, pass);
            if (status) {
                System.out.println("LOGIN BERHASIL");
                System.out.println();
                staffHomePage();
            } else {
                System.out.println("LOGIN GAGAL");
                System.out.println();
            }
        }while(status==false);
    }

    public void staffHomePage(){
        int pilih=0;
        do {
            System.out.println("""
                    1.KELOLA PRODUCT
                    2.TRANSAKSI
                    3.BACK""");
            System.out.print("INPUT  : ");
            try {
                pilih = input.nextInt();
                input.nextLine();
            }
            catch (InputMismatchException e) {
                input.nextLine();
                System.out.println(e);
            }
            switch (pilih) {
                case 1 -> kelolaPage();
                case 2 -> menuTransaksi();
                case 3 -> System.out.println("BACK");
                default -> System.out.println("INPUTAN TIDAK ADA");
            }
        }while (pilih!=3);
    }

    public void menuTransaksi(){
        String nip1 = authentication.getStaffLogged().getNip();
        String tanggal = DateString.now();
        DB_Transaksi.create(nip1,tanggal);
        System.out.println("==<DAFTAR-OBAT>==");
        data_obat.view();
        System.out.println("==<MENU-TRANSAKSI>==");
        String ulang;
        do{
            System.out.print("MASUKKAN KODE BARANG   : ");
            int kode = input.nextInt();
            input.nextLine();
            entity_obat obat =data_obat.cariDataProduk(kode);
            System.out.print("MASUKKAN JUMLAH BARANG : ");
            int jml = input.nextInt();
            input.nextLine();
            obat.setJumlah(obat.getJumlah()-jml);
            DB_DetTr.create(DB_Transaksi.getIdIncrement(),jml,obat);
            System.out.print("INPUT LAGI ? <y/t> : ");
            ulang = input.nextLine();
        }while(ulang.equals("y"));
        DB_DetTr.view_byId(DB_Transaksi.getIdIncrement());
        DB_Transaksi.setTotal(DB_DetTr.getTotalbyId(DB_Transaksi.getIdIncrement()));
        DB_Transaksi.cetakById(DB_Transaksi.getIdIncrement());
    }

    public void kelolaPage() {
        int pilih;
        do {
            System.out.print("""
                    --------------------
                    1.TAMBAH OBAT
                    2.HAPUS OBAT
                    3.LIHAT OBAT
                    4.EDIT OBAT
                    5.BACK
                    --------------------
                    INPUT  : """);
            pilih= input.nextInt();
            input.nextLine();
            switch(pilih){
                case 1->tambahObat();
                case 2->hapusProduct();
                case 3->lihatProduct();
                case 4->editProduk();
                case 5-> System.out.println("BACK");
                default -> System.out.println("INPUTAN TIDAK ADA");
            }
        }while(pilih!=5);
    }

    public void tambahObat(){
        System.out.println("--------------------");
        System.out.print("MERK        : ");
        String merk = input.nextLine();
        System.out.print("HARGA       : ");
        int harga = input.nextInt();
        input.nextLine();
        System.out.print("JUMLAH      : ");
        int jumlah = input.nextInt();
        input.nextLine();
        System.out.print("KODE BARANG : ");
        int kodeBarang = input.nextInt();
        input.nextLine();
        data_obat.createProduct(merk,harga,jumlah,kodeBarang);
    }

    public void hapusProduct(){
        System.out.print("KODE BARANG YANG AKAN DI HAPUS : ");
        int kode = input.nextInt();
        input.nextLine();
        entity_obat cariObat = data_obat.cariDataProduk(kode);
        if(cariObat!=null){
            data_obat.delProduct(cariObat);
            System.out.println("PRODUCT < " + cariObat.getMerk() + " > BERHASIL DI HAPUS");
        }else{
            System.out.println("DATA TIDAK DITEMUKAN");
        }

    }

    public void lihatProduct(){
        data_obat.view();
    }

    public void editProduk(){
        System.out.print("MASUKKAN KODE BARANG PRODUK YANG AKAN DI EDIT : ");
        int kode = input.nextInt();
        input.nextLine();
        entity_obat cariObat = data_obat.cariDataProduk(kode);
        if(cariObat!=null){
            System.out.print("MASUKKAN MERK BARU   : ");
            String merk = input.nextLine();
            System.out.print("MASUKKAN HARGA BARU  : ");
            int harga = input.nextInt();
            input.nextLine();
            System.out.print("MASUKKAN JUMLAH BARU : ");
            int jumlah = input.nextInt();
            input.nextLine();
            entity_obat obat = new entity_obat(merk,harga,jumlah,kode);
            data_obat.updateByKode(obat,kode);
            System.out.println("KODE PRODUK < " + cariObat.getKodeBarang() + " > BERHASIL DI EDIT");
        }else{
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }
}
