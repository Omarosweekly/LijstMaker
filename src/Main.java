import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        System.out.println("Welkom bij de lijstmaker.\nDit is het hoofdmenu.");
        menu.vraagMenu();
    }
}