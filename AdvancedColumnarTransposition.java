import java.util.Scanner;

public class AdvancedColumnarTransposition {
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int columns = key.length();
        int rows = (int) Math.ceil((double) plaintext.length() / columns);
        char[][] matrix = new char[rows][columns];
        
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < plaintext.length()) {
                    matrix[i][j] = plaintext.charAt(index++);
                } else {
                    matrix[i][j] = 'X';  // Padding character
                }
            }
        }
        
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int column = key.indexOf(ch);
            for (int j = 0; j < rows; j++) {
                ciphertext.append(matrix[j][column]);
            }
        }
        
        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
    }
}
