import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("inputFile.txt");
        if (!file.exists()) {
            FileWriter writer = new FileWriter(file);
            writer.write("Hello World");
            writer.close();
        }

        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        Key secretKey = keyGenerator.generateKey();

        Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] iv = cipherOut.getIV();
        if (iv != null) {
            String ivString = Base64.getEncoder().encodeToString(iv);
            System.out.println("Initialization Vector of the Cipher: " + ivString);
        }

        FileInputStream fin = new FileInputStream("inputFile.txt");
        FileOutputStream fout = new FileOutputStream("outputFile.txt");
        CipherOutputStream cout = new CipherOutputStream(fout, cipherOut);

        int input = 0;
        while ((input = fin.read()) != -1) {
            cout.write(input);
        }

        fin.close();
        cout.close();

        System.out.print("Contents of inputFile.txt: ");
        FileInputStream printIn = new FileInputStream("inputFile.txt");
        while ((input = printIn.read()) != -1) {
            System.out.print((char) input);
        }
        printIn.close();
        System.out.println();

        System.out.print("Contents of outputFile.txt: ");
        FileInputStream printOut = new FileInputStream("outputFile.txt");
        while ((input = printOut.read()) != -1) {
            System.out.print((char) input);
        }
        printOut.close();
        System.out.println();
    }
}