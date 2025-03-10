import numpy as np


def mod_inverse(a, mod=26):
    for x in range(1, mod):
        if (a * x) % mod == 1:
            return x
    return None

def create_key_matrix(key):
    return np.array([[ord(key[0]) - 97, ord(key[1]) - 97],
                     [ord(key[2]) - 97, ord(key[3]) - 97]])


def hill_encrypt(text, key):
    key_matrix = create_key_matrix(key)
    text = text.lower()
   
    if len(text) % 2 != 0:
        text += 'x'
    
    encrypted_text = ""
    for i in range(0, len(text), 2):
        block = text[i:i+2]
        block_vector = np.array([ord(block[0]) - 97, ord(block[1]) - 97])
        encrypted_block = np.dot(key_matrix, block_vector) % 26
        encrypted_text += chr(encrypted_block[0] + 97) + chr(encrypted_block[1] + 97)
    
    return encrypted_text

def hill_decrypt(encrypted_text, key):
    key_matrix = create_key_matrix(key)
    det = int(np.linalg.det(key_matrix)) % 26
    det_inv = mod_inverse(det)  
    if det_inv is None:
        raise ValueError("Key matrix is not invertible.")
 
    adjugate = np.round(det_inv * np.linalg.inv(key_matrix) * np.linalg.det(key_matrix)).astype(int) % 26
    inverse_key_matrix = adjugate
    
    decrypted_text = ""
    for i in range(0, len(encrypted_text), 2):
        block = encrypted_text[i:i+2]
        block_vector = np.array([ord(block[0]) - 97, ord(block[1]) - 97])
        decrypted_block = np.dot(inverse_key_matrix, block_vector) % 26
        decrypted_text += chr(decrypted_block[0] + 97) + chr(decrypted_block[1] + 97)
    
    return decrypted_text

key = "hill"  
text = "hello"

encrypted_text = hill_encrypt(text, key)
decrypted_text = hill_decrypt(encrypted_text, key)

print("Original Text:", text)
print("Encrypted Text:", encrypted_text)
print("Decrypted Text:", decrypted_text)
