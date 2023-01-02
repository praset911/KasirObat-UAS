package Model;
import entity.entity_kasir;
import java.util.ArrayList;

public class data_kasir {
    public static ArrayList<entity_kasir> ArrStaff = new ArrayList<>();
    public static ArrayList<entity_kasir> ArrAdmin = new ArrayList<>();

    public static void initialDataDummy(){
        initialAdmin();
        initialStaff();
    }

    public static void initialStaff(){
        ArrStaff.add(new entity_kasir("Prasetya","123","111"));
        ArrStaff.add(new entity_kasir("Prasetya","234","111"));
    }

    public static void initialAdmin(){
        ArrAdmin.add(new entity_kasir("Pras","07413","111"));
    }

    public static void createAccount(String nama,String nip,String password){
        ArrStaff.add(new entity_kasir(nama,nip,password));
    }

    public static void delAccount(entity_kasir kasir){
        ArrStaff.remove(kasir);
    }

    public static entity_kasir cariDataKasir(String nipKasir){
        for (entity_kasir cariKasir : ArrStaff){
            if(cariKasir.getNip().equals(nipKasir)){
                return cariKasir;
            }
        }
        return null;
    }

    public static void lihatStaff(){
        for(entity_kasir kasir : ArrStaff){
            kasir.display();
        }
    }

}
