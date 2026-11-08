```java
import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Generate RSA key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        Cipher cipher = Cipher.getInstance("RSA");

        // Encryption using public key
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(msg.getBytes());

        System.out.println("Encrypted: " +
            Base64.getEncoder().encodeToString(encrypted));

        // Decryption using private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println("Decrypted: " + new String(decrypted));

        sc.close();
    }
}
```
