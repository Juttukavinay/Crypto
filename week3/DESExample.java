import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class DESExample {

    private static final String UNICODE_FORMAT = "UTF-8";
    private static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private Cipher cipher;
    private SecretKey key;
    private String myEncryptionKey = "ThisIs24ByteKeyFor3DES"; // Exactly 24 bytes

    public DESExample() throws Exception {
        // Ensure the key is exactly 24 bytes
        if (myEncryptionKey.length() > 24) {
            myEncryptionKey = myEncryptionKey.substring(0, 24); // Trim to 24 bytes
        } else if (myEncryptionKey.length() < 24) {
            myEncryptionKey = String.format("%-24s", myEncryptionKey).replace(' ', '0'); // Pad with zeros
        }

        byte[] keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        DESedeKeySpec myKeySpec = new DESedeKeySpec(keyAsBytes);
        SecretKeyFactory mySecretKeyFactory = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
        cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
        key = mySecretKeyFactory.generateSecret(myKeySpec);
    }

    public String encrypt(String unencryptedString) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            return Base64.getEncoder().encodeToString(encryptedText);
        } catch (Exception e) {
            throw new RuntimeException("Error during encryption", e);
        }
    }

    public String decrypt(String encryptedString) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.getDecoder().decode(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            return new String(plainText, UNICODE_FORMAT);
        } catch (Exception e) {
            throw new RuntimeException("Error during decryption", e);
        }
    }

    public static void main(String args[]) throws Exception {
        DESExample myEncryptor = new DESExample();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string to encrypt: ");
        String stringToEncrypt = scanner.nextLine();

        String encryptedString = myEncryptor.encrypt(stringToEncrypt);
        System.out.println("Encrypted String: " + encryptedString);

        String decryptedString = myEncryptor.decrypt(encryptedString);
        System.out.println("Decrypted String: " + decryptedString);

        scanner.close();
    }
}
