import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HillCipher {
    static float[][] a = new float[3][3];
    static float[][] b = new float[3][3];
    static float[][] mes = new float[3][1];
    static float[][] res = new float[3][1];
    static float[][] decrypt = new float[3][1];

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        getKeyMes();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                res[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    res[i][j] += a[i][k] * mes[k][j];
                }
            }
        }

        System.out.print("\nEncrypted string is : ");
        for (int i = 0; i < 3; i++) {
            int val = ((int) res[i][0]) % 26;
            if (val < 0) val += 26;
            System.out.print((char) (val + 97));
        }
        System.out.println();

        inverse();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                decrypt[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    decrypt[i][j] += b[i][k] * res[k][j];
                }
            }
        }

        System.out.print("\nDecrypted string is : ");
        for (int i = 0; i < 3; i++) {
            int val = Math.round(decrypt[i][0]) % 26;
            if (val < 0) val += 26;
            System.out.print((char) (val + 97));
        }
        System.out.println();
    }

    public static void getKeyMes() throws IOException {
        System.out.println("Enter 3x3 matrix for key (Row by row): ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = sc.nextFloat();
            }
        }

        System.out.print("\nEnter a 3 letter string: ");
        String msg = br.readLine().toLowerCase();
        for (int i = 0; i < 3; i++) {
            mes[i][0] = msg.charAt(i) - 97;
        }
    }

    public static void inverse() {
        float p, q;
        float[][] c = new float[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = a[i][j];
                b[i][j] = (i == j) ? 1.0f : 0.0f;
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    p = c[i][k];
                    q = c[k][k];
                    for (int j = 0; j < 3; j++) {
                        c[i][j] = c[i][j] * q - p * c[k][j];
                        b[i][j] = b[i][j] * q - p * b[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = b[i][j] / c[i][i];
            }
        }

        System.out.println("\nInverse Matrix is : ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%10.6f ", b[i][j]);
            }
            System.out.println();
        }
    }
}