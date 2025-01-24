import java.util.Random;
import java.util.UUID;

public class MakeUUID {
    public String aanvraag(){
        Random uuid = new Random();
        long mostSigBits = uuid.nextLong();
        long leastSigBits = uuid.nextLong();
        UUID nieuwUUID = new UUID(mostSigBits, leastSigBits);
        return nieuwUUID.toString();
    }
}
