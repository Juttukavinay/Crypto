public class XORWithZero {
    public static void main(String[] args) {
        // Initialize the string
        String str = "Hello world.";

        System.out.println("Original String: " + str);
        System.out.println("Result after XOR with 0:");

        // Iterate through each character and XOR with 0
        for (int i = 0; i < str.length(); i++) {
            char original = str.charAt(i);
            char result = (char) (original ^ 0); // XOR with 0
            System.out.print(result); // Print the character
        }

        System.out.println(); // New line for better readability
    }
}
