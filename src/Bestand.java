import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bestand {
    String opslagPlek = "\\src\\";
    String baseDir = System.getProperty("user.dir");
    File opslagBestand;

    public boolean checkBestaan(File opslagBestand) {
        if (!opslagBestand.exists()) {
            try {
                opslagBestand.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Het bestand werd niet gevonden. Het is aangemaakt");
        } else {
            System.out.println("Bestand gevonden.");
        }
        return true;
    }

    public void vragenCijfers() throws IOException {
        opslagBestand = new File(baseDir+opslagPlek+"LabelCijfers.txt");
        checkBestaan(opslagBestand);
        Scanner scan = new Scanner(System.in);

        System.out.println("Wat is het start cijfer?");
        int min = scan.nextInt();
        System.out.println("Wat is het laatste cijfer?");
        int max = scan.nextInt();
        lijstCijfers(min,max);
        scan.close();
    }

    public void vragenLetters(){
        opslagBestand = new File(baseDir+opslagPlek+"LabelLijst.txt");
        checkBestaan(opslagBestand);
        Scanner scan = new Scanner(System.in);

        System.out.println("Uit hoeveel letter bestaat de letter reeks?");
        int aantalLetters = scan.nextInt();
        System.out.println("Hoeveel letter reeksen zijn er nodig?");
        int aantalReeks = scan.nextInt();
        lijstAlfabet(aantalLetters, aantalReeks);
        scan.close();
    }

    public void lijstCijfers(int min, int max) throws IOException {
        MaakUUID nieuwUUID = new MaakUUID();
        FileWriter opslag = new FileWriter(opslagBestand, true);

        int loop = min;
        while (!(loop >= (max+1))) {
            String uuid = nieuwUUID.aanvraag();
            String nr = String.valueOf(loop++);
            opslag.write(uuid+"::"+ nr +"\n");
        }
        opslag.close();
    }

    public void lijstAlfabet(int aantalLetters, int aantalLabels) {
        MaakUUID nieuwUUID = new MaakUUID();
        MaakLetter letterReeks = new MaakLetter();

        int AantalKeren = 0;
        try {
            FileWriter opslag = new FileWriter(opslagBestand,true);
            while  (AantalKeren != aantalLabels) {
                String nieuw = nieuwUUID.aanvraag();
                String id = letterReeks.reeks(aantalLetters);
                opslag.write(nieuw + "::" + id + "\n");
                AantalKeren++;
            }
            opslag.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
