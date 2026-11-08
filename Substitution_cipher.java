import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstitutionCipher {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final String KEY      = "zyxwvutsrqponmlkjihgfedcba";

    public static void main(String[] args) throws IOException {
        System.out.print("Enter any string: ");
        String str = br.readLine().toLowerCase();

        String encrypted = encrypt(str);
        System.out.println("The encrypted data is: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("The decrypted data is: " + decrypted);
    }

    public static String encrypt(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = ALPHABET.indexOf(c);
            if (idx != -1) {
                result.append(KEY.charAt(idx));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = KEY.indexOf(c);
            if (idx != -1) {
                result.append(ALPHABET.charAt(idx));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}