import math

def encryptMessage(msg, key):
    msg = msg.replace(" ", "_")  # Preserve spaces using underscores
    cipher = ""

    key_indices = []
    key_order = sorted(list(set(key)))  # Sort the key alphabetically (unique)

    # Mapping characters in key to their respective indices
    for char in key:
        key_indices.append(key_order.index(char))

    col = len(key)
    row = math.ceil(len(msg) / col)

    # Padding with '_'
    msg += "_" * (row * col - len(msg))

    # Creating the matrix
    matrix = [list(msg[i:i + col]) for i in range(0, len(msg), col)]

    # Reading matrix column-wise based on key order
    for index in key_indices:
        cipher += "".join(matrix[row][index] for row in range(len(matrix)))

    return cipher


def decryptMessage(cipher, key):
    msg = ""
    key_indices = []
    key_order = sorted(list(set(key)))

  
    for char in key:
        key_indices.append(key_order.index(char))

    col = len(key)
    row = math.ceil(len(cipher) / col)


    dec_cipher = [[""] * col for _ in range(row)]

    index = 0
    for key_index in key_indices:
        for r in range(row):
            dec_cipher[r][key_index] = cipher[index]
            index += 1

    msg = "".join("".join(row) for row in dec_cipher)
    msg = msg.replace("_", " ")  # Restore spaces

    return msg.strip("_")


msg = input("Enter your message: ")
key = input("Enter your key: ").upper()  

cipher = encryptMessage(msg, key)
print(" Encrypted Message:", cipher)

decrypted_msg = decryptMessage(cipher, key)
print(" Decrypted Message:", decrypted_msg)
