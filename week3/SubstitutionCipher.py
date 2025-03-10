import string

def create_substitution_cipher_key():
    # Create a list of all letters in the alphabet
    alphabet = string.ascii_lowercase
    # Shuffle the alphabet to create a random substitution
    shuffled_alphabet = ''.join(sorted(alphabet, key=lambda x: random.random()))
    return dict(zip(alphabet, shuffled_alphabet))

def encrypt(text, key):
    encrypted_text = ''
    for char in text:
        if char.lower() in key:
            new_char = key[char.lower()]
            encrypted_text += new_char.upper() if char.isupper() else new_char
        else:
            encrypted_text += char  # For non-alphabet characters, keep unchanged
    return encrypted_text

def decrypt(text, key):
    reversed_key = {v: k for k, v in key.items()}  # Reverse the substitution key
    decrypted_text = ''
    for char in text:
        if char.lower() in reversed_key:
            new_char = reversed_key[char.lower()]
            decrypted_text += new_char.upper() if char.isupper() else new_char
        else:
            decrypted_text += char  # For non-alphabet characters, keep unchanged
    return decrypted_text

# Example usage
import random

# Create a substitution cipher key (mapping each letter to another)
cipher_key = create_substitution_cipher_key()
print("Substitution Cipher Key:", cipher_key)

text = "Hello, World!"
encrypted_text = encrypt(text, cipher_key)
decrypted_text = decrypt(encrypted_text, cipher_key)

print("Original Text: ", text)
print("Encrypted Text:", encrypted_text)
print("Decrypted Text:", decrypted_text)
