def encrypt_autokey(plain_text, key):
    """Encrypts the given plaintext using the Autokey Cipher."""
    cipher_text = ""
    autokey = key  # Start with the given key

    for p in plain_text:
        encrypted_char = chr(((ord(p) - ord('A') + (ord(autokey[0]) - ord('A'))) % 26) + ord('A'))
        cipher_text += encrypted_char
        autokey += p  # Append plaintext to the key dynamically

    return cipher_text

def decrypt_autokey(cipher_text, key):
    """Decrypts the given ciphertext using the Autokey Cipher."""
    plain_text = ""
    autokey = key  # Start with the given key

    for c in cipher_text:
        decrypted_char = chr(((ord(c) - ord('A') - (ord(autokey[0]) - ord('A'))) % 26) + ord('A'))
        plain_text += decrypted_char
        autokey += decrypted_char  # Append decrypted text to the key dynamically

    return plain_text

# Example usage
plaintext = "HELLO"
key = "KEY"

# Encrypt
cipher_text = encrypt_autokey(plaintext, key)
print(f"Original Text:  {plaintext}")
print(f"Cipher Text:    {cipher_text}")

# Decrypt
decrypted_text = decrypt_autokey(cipher_text, key)
print(f"Decrypted Text: {decrypted_text}")
