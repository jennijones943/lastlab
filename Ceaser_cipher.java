import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CaesarCipher {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.print("Enter any String: ");
        String str = br.readLine();

        System.out.print("Enter the Key: ");
        int key = sc.nextInt();

        String encrypted = encrypt(str, key);
        System.out.println("\nEncrypted String is : " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted String is : " + decrypted);
    }

    public static String encrypt(String str, int key) {
        StringBuilder encrypted = new StringBuilder();
        key = key % 26;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ('A' + (c - 'A' + key + 26) % 26);
            } else if (Character.isLowerCase(c)) {
                c = (char) ('a' + (c - 'a' + key + 26) % 26);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static String decrypt(String str, int key) {
        return encrypt(str, 26 - (key % 26));
    }
}