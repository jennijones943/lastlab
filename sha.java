import java.security.MessageDigest;
import java.util.Scanner;

public class SHA256Example {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Step 2: Create SHA-256 object
        MessageDigest md =
            MessageDigest.getInstance("SHA-256");

        // Step 3: Generate hash
        byte[] hash = md.digest(
            text.getBytes("UTF-8")
        );

        // Step 4: Convert bytes into hexadecimal
        StringBuilder hex = new StringBuilder();

        for (byte b : hash) {
            hex.append(
                String.format("%02x", b & 0xff)
            );
        }

        // Step 5: Print hash
        System.out.println("SHA-256 Hash: " + hex);

        sc.close();
    }
}
