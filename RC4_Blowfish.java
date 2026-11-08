import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");

        SecretKey secretkey = keygenerator.generateKey();

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretkey);

        System.out.print("Input your message: ");
        String inputText = br.readLine();

        byte[] encrypted = cipher.doFinal(inputText.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, secretkey);

        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("\nEncrypted text: " + new String(encrypted));
        System.out.println("Decrypted text: " + new String(decrypted));
    }
}