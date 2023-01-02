import Model.data_kasir;
import Model.data_obat;
import View.StartMenu;

public class Main {
    public static void main(String[] args) {
        data_kasir.initialDataDummy();
        data_obat.initialObat();
        new StartMenu();
    }
}