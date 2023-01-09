package View;

import java.util.Scanner;

public class StartMenu {

    StaffPage staff = new StaffPage();
    AdminPage admin = new AdminPage();
    static Scanner input = new Scanner(System.in);
    public StartMenu(){
        startMenu();
    }
    public void startMenu(){
        int pilih;
        do {
            System.out.println("-----------");
            System.out.println("1.LOGIN");
            System.out.println("2.EXIT");
            System.out.print("INPUT  : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> loginSelect();
                case 2 -> exit();
                default -> System.out.println("INPUTAN TIDAK ADA");
            }
        }while(pilih!=2);
    }

    public void loginSelect(){
        int pilih;
        do {
            System.out.println("-------------");
            System.out.println("1.STAFF");
            System.out.println("2.ADMIN");
            System.out.println("3.BACK");
            System.out.println("-------------");
            System.out.print("INPUT  : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> staff.LoginStaff();
                case 2 -> admin.LoginAdmin();
                case 3 -> System.out.println("BACK");
                default -> System.out.println("INPUTAN TIDAK ADA");
            }
        }while(pilih!=3);
    }

    public void exit(){
        System.out.println("EXIT");
    }
}
