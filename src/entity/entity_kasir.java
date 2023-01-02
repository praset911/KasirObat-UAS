package entity;

public class entity_kasir {

    private String nama,nip,password;

    public entity_kasir(String nama, String nip, String password) {
        this.nama = nama;
        this.nip = nip;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void display(){
        System.out.println("NAMA : " + getNama());
        System.out.println("NIP  : " + getNip());
        System.out.println("PASS : " + getPassword());
    }
}
