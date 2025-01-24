import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Bestand {
    String opslagPlek = "\\src\\";
    String baseDir = System.getProperty("user.dir");
    File opslagBestand = new File(baseDir+opslagPlek+"LabelLijst.txt");

    public boolean checkBestaan() {
    if (!opslagBestand.exists()) {
            try {
                opslagBestand.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Bestand is aangemaakt");
        } else {
            System.out.println("Bestand gevonden.");
        }
        return true;
    }

    public void vragenCijfers() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wat is het start cijfer?");
        int min = scan.nextInt();
        System.out.println("Wat is het laatste cijfer?");
        int max = scan.nextInt();
        lijstCijfers(min,max);
        scan.close();
    }

    public void vragenLetters(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Uit hoeveel letter bestaat de letter reeks?");
        int aantalLetters = scan.nextInt();
        System.out.println("Hoeveel letter reeksen zijn er nodig?");
        int aantalReeks = scan.nextInt();
        lijstAlfabet(aantalLetters, aantalReeks);
        System.out.println(opslagBestand);
    }

    public void lijstCijfers(int min, int max) throws IOException {
        checkBestaan();
        MakeUUID nieuwUUID = new MakeUUID();
        FileWriter opslag = new FileWriter(opslagBestand, true);
        int loop =0;
        while (!(loop >= (max+1))) {
            String uuid = nieuwUUID.aanvraag();
            String nr = String.valueOf(loop++);
            opslag.write(uuid+"::"+ nr +"\n");
        }
        opslag.close();
    }

    public void lijstAlfabet(int aantalLetters, int aantalLabels) {
        MakeUUID nieuwUUID = new MakeUUID();
        StringBuilder id = new StringBuilder();
        int AantalKeren = 0;
        try {
            FileWriter opslag = new FileWriter(opslagBestand,true);
            while  (AantalKeren != aantalLabels) {
                while (id.length() != aantalLetters) {
                    Random random = new Random();
                    int randomNumber = random.nextInt(65, 91);
                    char letterA = 'A';
                    char let = (char) (letterA + randomNumber);
                    System.out.println("Deze letter is toegevoegd: "+ let);
                    String letter = String.valueOf(let);
                    id.append(letter);
                }
                String nieuw = nieuwUUID.aanvraag();
                opslag.write(nieuw + "::" + id + "\n");
                AantalKeren++;
                System.out.println(AantalKeren);
            }
            opslag.close();
            System.out.println(opslagBestand);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
