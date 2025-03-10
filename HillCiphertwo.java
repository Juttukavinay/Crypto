import java.util.Scanner;

public class HillCiphertwo {
    public static int[][] inverse(int[][] matrix) {
        int determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        int mod = 26;
        determinant = (determinant + mod) % mod;
        int invDet = modInverse(determinant, mod);
        int[][] inverse = new int[2][2];
        inverse[0][0] = matrix[1][1] * invDet % mod;
        inverse[0][1] = -matrix[0][1] * invDet % mod;
        inverse[1][0] = -matrix[1][0] * invDet % mod;
        inverse[1][1] = matrix[0][0] * invDet % mod;
        return inverse;
    }

    public static int modInverse(int a, int mod) {
        a = a % mod;
        for (int x = 1; x < mod; x++) {
            if ((a * x) % mod == 1) {
                return x;
            }
        }
        return 1;
    }

    public static String encrypt(String plaintext, int[][] keyMatrix) {
        StringBuilder ciphertext = new StringBuilder();
        int[] plaintextVector = new int[2];
        for (int i = 0; i < plaintext.length(); i += 2) {
            plaintextVector[0] = plaintext.charAt(i) - 'A';
            plaintextVector[1] = plaintext.charAt(i + 1) - 'A';
            int[] ciphertextVector = new int[2];
            for (int j = 0; j < 2; j++) {
                ciphertextVector[j] = (keyMatrix[j][0] * plaintextVector[0] + keyMatrix[j][1] * plaintextVector[1]) % 26;
            }
            ciphertext.append((char) (ciphertextVector[0] + 'A'));
            ciphertext.append((char) (ciphertextVector[1] + 'A'));
        }
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext (even length): ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        
        int[][] keyMatrix = { { 6, 24 }, { 1, 16 } };  // Example matrix
        String ciphertext = encrypt(plaintext, keyMatrix);
        System.out.println("Ciphertext: " + ciphertext);
    }
}
