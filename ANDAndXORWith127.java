public class ANDAndXORWith127 {
    public static void main(String[] args) {
        // Initialize the string
        String str = "Hello world";

        System.out.println("Original String: " + str);
        System.out.println("Results after AND and XOR with 127:");

        // Iterate through each character
        for (int i = 0; i < str.length(); i++) {
            char original = str.charAt(i);
            char andResult = (char) (original & 127); // AND with 127
            char xorResult = (char) (original ^ 127); // XOR with 127

            // Display the original character, AND result, and XOR result
            System.out.println("Character: " + original 
                               + " -> AND Result: " + andResult 
                               + ", XOR Result: " + xorResult);
        }
    }
}
