import java.util.Scanner;
import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Public values
        BigInteger p = BigInteger.valueOf(23);
        BigInteger g = BigInteger.valueOf(5);

        // Generate private keys
        SecureRandom random = new SecureRandom();

        BigInteger alicePrivate =
            new BigInteger(5, random).add(BigInteger.ONE);

        BigInteger bobPrivate =
            new BigInteger(5, random).add(BigInteger.ONE);

        // Generate public keys
        BigInteger alicePublic =
            g.modPow(alicePrivate, p);

        BigInteger bobPublic =
            g.modPow(bobPrivate, p);

        // Display public keys
        System.out.println("Alice Public Key: " + alicePublic);
        System.out.println("Bob Public Key: " + bobPublic);

        // Calculate shared secret keys
        BigInteger aliceSecret =
            bobPublic.modPow(alicePrivate, p);

        BigInteger bobSecret =
            alicePublic.modPow(bobPrivate, p);

        // Display shared secret
        System.out.println("Alice Shared Key: " + aliceSecret);
        System.out.println("Bob Shared Key: " + bobSecret);

        // Verify shared keys
        if (aliceSecret.equals(bobSecret)) {
            System.out.println("Key Exchange Successful!");
        } else {
            System.out.println("Key Exchange Failed!");
        }

        sc.close();
    }
}
