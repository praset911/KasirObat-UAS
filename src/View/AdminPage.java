package View;
import Controller.LoginController;
import Model.data_kasir;
import Model.data_transaksi;
import entity.entity_kasir;

import java.util.Scanner;

public class AdminPage {

    LoginController authentication = new LoginController();
    Scanner input = new Scanner(System.in);
    public void LoginAdmin(){
        boolean status = false;
        do {
            System.out.print("NIP  : ");
            String nip = input.nextLine();
            System.out.print("PASS : ");
            String pass = input.nextLine();
            status = authentication.loginAdmin(nip, pass);
            if (status) {
                System.out.println("LOGIN BERHASIL");
                adminHomePage();
            } else {
                System.out.println("LOGIN GAGAL");
            }
        }while(status==false);
    }

    public void adminHomePage(){
        int pilih;
        do {
            System.out.print("""
                    ------------------
                    1.TAMBAH STAFF
                    2.HAPUS STAFF
                    3.LIHAT STAFF
                    4.EDIT PASS STAFF
                    5.DATA PENJUALAN
                    6.BACK
                    -----------------
                    INPUT  : """);
            pilih = input.nextInt();
            input.nextLine();
            switch (pilih){
                case 1 ->tambahStaff();
                case 2 ->hapusStaff();
                case 3 ->lihatStaff();
                case 4 ->editPassStaff();
                case 5 ->dataPenjualan();
                case 6 -> System.out.println("BACK");
                default -> System.out.println("INPUTAN TIDAK ADA");
            }
        }while (pilih!=6);
    }

    public void tambahStaff(){
        System.out.print("NAMA : ");
        String nama = input.nextLine();
        System.out.print("NIP  : ");
        String nip = input.nextLine();
        System.out.print("PASS : ");
        String pass = input.nextLine();
        data_kasir.createAccount(nama,nip,pass);
    }

    public void hapusStaff(){
        System.out.print("NIP STAFF YANG AKAN DI HAPUS : ");
        String nip = input.nextLine();
        entity_kasir cariNipStaff = data_kasir.cariDataKasir(nip);
        if(cariNipStaff!=null){
            data_kasir.delAccount(cariNipStaff);
            System.out.println("STAFF < " + cariNipStaff.getNama() + " > BERHASIL DI HAPUS");
        }else{
            System.out.println("DATA TIDAK DITEMUKAN");
        }

    }

    public void lihatStaff(){
        data_kasir.lihatStaff();
    }

    public void editPassStaff(){
        System.out.print("MASUKKAN NIP YANG AKAN DI EDIT : ");
        String nip = input.nextLine();
        entity_kasir cariNipStaff = data_kasir.cariDataKasir(nip);
        if(cariNipStaff!=null){
            System.out.print("MASUKKAN NEW PASSWORD : ");
            String pass = input.nextLine();
            cariNipStaff.setPassword(pass);
            System.out.println("PASSWORD STAFF < " + cariNipStaff.getNama() + " > BERHASIL DI EDIT");
        }else{
            System.out.println("DATA TIDAK DITEMUKAN");
        }
    }

    public void dataPenjualan(){
        StaffPage.DB_DetTr.view();
    }

}
