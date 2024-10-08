



class Codec:

    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        encoded_array = b''
        head = b''
        head_len = 0

        for string in strs:
            encoded_string = str.encode(string, 'cp437')
            head += len(encoded_string).to_bytes(1, 'big')
            head_len += 1
            encoded_array += encoded_string

        encoded_array = head_len.to_bytes(1, 'big') + head + encoded_array

        return encoded_array.decode('cp437')

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """
        encoded_array = s.encode('cp437')
        head_len = encoded_array[0]

        head = [0] * head_len
        for i in range(head_len):
            head[i] = encoded_array[i + 1]

        decoded_strings = []
        j = head_len + 1
        for i in range(head_len):
            decoded_strings.append(encoded_array[j: j + head[i]].decode('cp437'))
            j += head[i]

        return decoded_strings 



# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))

