#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char str[] = "Hello World"; 
    char encrypted[12];         
    char decrypted[12];        
    int i, len;

    len = strlen(str);

    // Encryption process
    for (i = 0; i < len; i++) {
        encrypted[i] = str[i] ^ 127; 
    }
    encrypted[len] = '\0'; 

    // Decryption process
    for (i = 0; i < len; i++) {
        decrypted[i] = encrypted[i] ^ 127; 
    }
    decrypted[len] = '\0'; 


    printf("Original Message: %s\n", str);
    printf("Encrypted Message: %s\n", encrypted);
    printf("Decrypted Message: %s\n", decrypted);

    return 0;
}
