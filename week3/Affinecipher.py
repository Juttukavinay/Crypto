# Function to encrypt using Affine Cipher
def affine_encrypt(text):
    encrypted_text = ""
    for char in text.upper():
        if char.isalpha():
            x = ord(char) - 65  # Convert A-Z to 0-25
            c = (3 * x + 12) % 26  # Affine encryption formula
            encrypted_text += chr(c + 65)  # Convert back to A-Z
        else:
            encrypted_text += char  # Keep spaces and symbols unchanged
    return encrypted_text

# Function to decrypt using Affine Cipher
def affine_decrypt(text):
    decrypted_text = ""
    for char in text.upper():
        if char.isalpha():
            c = ord(char) - 65  # Convert A-Z to 0-25
            x = (9 * (c - 12)) % 26  # Affine decryption formula
            decrypted_text += chr(x + 65)  # Convert back to A-Z
        else:
            decrypted_text += char  # Keep spaces and symbols unchanged
    return decrypted_text

# Example usage
plaintext = "HELLO"
encrypted_text = affine_encrypt(plaintext)
decrypted_text = affine_decrypt(encrypted_text)

print("Original Text:", plaintext)
print("Encrypted Text:", encrypted_text)
print("Decrypted Text:", decrypted_text)
