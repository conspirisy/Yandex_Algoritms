package Sprint_4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class B {

    public static void main(String[] args) throws IOException {
        Map<Long, String> hashes = new HashMap<>();
        while (true) {
            int leftLimit = 97; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = new Random().nextInt(20);
            Random random = new Random();
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            long hash = getHash(generatedString);
            if (hashes.containsKey(hash) && !generatedString.equals(hashes.get(hash))) {
                System.out.println(hashes.get(hash) + " " + generatedString);
                break;
            } else {
                hashes.put(hash, generatedString);
            }
        }

    }

    public static long getHash(String str) {
        long a = 1000L;
        long m = 123987123L;
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = ((result * a) % m + str.charAt(i)) % m;
        }
        return result;
    }
}
