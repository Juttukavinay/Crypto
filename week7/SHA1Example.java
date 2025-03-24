import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA1Example {
    
    // Method to generate SHA-1 hash
    public static String getSHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1"); // Create SHA-1 instance
        byte[] hashBytes = md.digest(input.getBytes()); // Compute hash
        StringBuilder hexString = new StringBuilder();

        // Convert bytes to hexadecimal format
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString(); // Return final hash
    }

    public static void main(String[] args) {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();

        try {
            // Compute SHA-1 hash
            String sha1Hash = getSHA1(text);
            System.out.println("SHA-1 Hash: " + sha1Hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-1 Algorithm not found.");
        }
    }
}
