import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void vraagMenu() throws IOException {
        /*Instances inventaris*/
        StringBuilder menuLijst = new StringBuilder();
        Scanner input = new Scanner(System.in);

        Bestand bestand = new Bestand();
        menuLijst.append("""
                 Kies het soort label dat u wilt gebruiken:
                 1. Cijfers
                 2. Letters
                """);
        System.out.println(menuLijst);
        int menuInput = input.nextInt();
        switch (menuInput) {
            case 1:
                bestand.vragenCijfers();
                break;
            case 2:
                bestand.vragenLetters();
                break;
            default: System.out.println("Graag optie 1 of optie 2 invoeren.");
        }
    }
}
