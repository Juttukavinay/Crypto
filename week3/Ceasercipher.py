def caesar_cipher(text, shift, mode="encrypt"):
    result = ""
    if mode == "decrypt":
        shift = -shift  # Reverse the shift for decryption
    
    for char in text:
        if char.isalpha():
            shift_amount = shift % 26
            new_char = chr(((ord(char.lower()) - 97 + shift_amount) % 26) + 97)
            result += new_char.upper() if char.isupper() else new_char
        else:
            result += char
    return result

# Get user input
text = input("Enter text: ")
shift = int(input("Enter shift value: "))
mode = input("Enter mode (encrypt/decrypt): ").strip().lower()

# Encrypt or decrypt based on mode
output_text = caesar_cipher(text, shift, mode)
print(f"Result ({mode}ed text): {output_text}")
