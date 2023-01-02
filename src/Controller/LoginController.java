package Controller;

import Model.data_kasir;
import entity.entity_kasir;

public class LoginController {

    entity_kasir kasir;

    public entity_kasir getStaffLogged(){
        return kasir;
    }
    public boolean loginStaff(String nip,String pass){
        for(entity_kasir login : data_kasir.ArrStaff){
            if(login.getNip().equals(nip) && login.getPassword().equals(pass)){
                kasir = login;
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(String nip,String pass){
        for(entity_kasir login : data_kasir.ArrAdmin){
            if(login.getNip().equals(nip) && login.getPassword().equals(pass)){
                kasir = login;
                return true;
            }
        }
        return false;
    }
}
