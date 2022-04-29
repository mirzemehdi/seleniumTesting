import java.util.Random;

public class Helper {
    public static String generateRandomTenCharacterString() {
        int start = 97; // 'a'
        int end = 122; // 'z'
        int length = 10;
        Random random = new Random();

        return random.ints(start, end + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String[] generateRandomStringArray(int nbElements) {
        String[] randomStrings = new String[nbElements];
        for (int i = 0; i < nbElements; i++) {
            String randomString = generateRandomTenCharacterString();
            randomStrings[i] = randomString;
        }
        return randomStrings;
    }
}
