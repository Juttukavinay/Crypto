#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char str[] = "Hello World"; // Original message
    char encrypted[12];         // To store encrypted message
    char decrypted[12];         // To store decrypted message
    int i, len;

    len = strlen(str);

    // Encryption process
    for (i = 0; i < len; i++) {
        encrypted[i] = str[i] ^ 127; // XOR each character with 127
    }
    encrypted[len] = '\0'; // Null-terminate the encrypted string

    // Decryption process
    for (i = 0; i < len; i++) {
        decrypted[i] = encrypted[i] ^ 127; // XOR again with 127 to get original
    }
    decrypted[len] = '\0'; // Null-terminate the decrypted string

    // Print original, encrypted, and decrypted messages
    printf("Original Message: %s\n", str);
    printf("Encrypted Message: %s\n", encrypted);
    printf("Decrypted Message: %s\n", decrypted);

    return 0;
}
