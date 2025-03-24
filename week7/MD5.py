import hashlib

def get_md5(input_text):
    # Create an MD5 hash object
    md5_hash = hashlib.md5()
    
    # Update the hash object with the input string (encoded as bytes)
    md5_hash.update(input_text.encode('utf-8'))
    
    # Get the hexadecimal representation of the hash
    return md5_hash.hexdigest()

if __name__ == "__main__":
    text = input("Enter text to hash: ")
    print("MD5 Hash:", get_md5(text))
