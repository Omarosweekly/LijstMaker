import java.util.Random;

public class MaakLetter {
    public String reeks(int aantalLetters) {
        StringBuilder id = new StringBuilder();
        while (id.length() != aantalLetters) {
            Random random = new Random();
            int randomNumber = random.nextInt(26) + 65;
            char letter = (char) randomNumber;
            String letterStr = String.valueOf(letter);
            id.append(letterStr);
        }
        return id.toString();
    }
}
