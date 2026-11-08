import java.security.MessageDigest;
import java.util.Scanner;

public class MD5Example {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Create MD5 MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Generate MD5 hash
        byte[] hash = md.digest(text.getBytes("UTF-8"));

        // Convert hash to hexadecimal
        StringBuilder hex = new StringBuilder();

        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }

        System.out.println("MD5 Hash: " + hex);

        sc.close();
    }
}

