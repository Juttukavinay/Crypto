package week7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Scanner;

public class MD5Example {
    
    // Method to generate MD5 hash
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // Create MD5 instance
            byte[] messageDigest = md.digest(input.getBytes()); // Compute hash
            
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert hash into hexadecimal format
            String hashtext = no.toString(16);

            // Pad with leading zeros to make it 32 characters
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to hash: ");
        String text = scanner.nextLine();
        scanner.close();

        System.out.println("MD5 Hash: " + getMD5(text));
    }
}
