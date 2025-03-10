import java.util.Scanner;

public class AutoKeyCipher {
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            char ptChar = plaintext.charAt(i);
            char keyChar = key.charAt(keyIndex);
            ciphertext.append((char) (((ptChar - 'A' + keyChar - 'A') % 26) + 'A'));
            keyIndex = (keyIndex + 1) % key.length();
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char ctChar = ciphertext.charAt(i);
            char keyChar = key.charAt(keyIndex);
            plaintext.append((char) (((ctChar - 'A' - (keyChar - 'A') + 26) % 26) + 'A'));
            keyIndex = (keyIndex + 1) % key.length();
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);

        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
