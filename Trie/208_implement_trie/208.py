# http://www.cse.yorku.ca/~oz/hash.html

class TrieNode:
    
    def __init__(self):
        # self.char = None
        self.next_nodes = [None] * 26
        self.end = False
        
    def index(self, char):
        return ord(char) - 97
    
    def set_end(self):
        self.end = True
    
    def add(self, char, node):
        self.next_nodes[self.index(char)] = node
        return
    
    def get(self, char):
        return self.next_nodes[self.index(char)]



class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        def recur(node, idx):
            if idx == len(word):
                node.set_end()
                return 
            if node.get(word[idx]) == None:
                node.add(word[idx], TrieNode())
            return recur(node.get(word[idx]), idx + 1)
        idx = 0
        return recur(self.root, idx)

    def search(self, word: str) -> bool:
        def recur(node, idx):
            if idx == len(word):
                return node.end 
            if node.get(word[idx]) == None:
                return False
            return recur(node.get(word[idx]), idx + 1)
        idx = 0
        return recur(self.root, idx)
            

    def startsWith(self, prefix: str) -> bool:
        def recur(node, idx):
            if idx == len(prefix):
                return True
            if node.get(prefix[idx]) == None:
                return False
            return recur(node.get(prefix[idx]), idx + 1)
        return recur(self.root, 0)
            


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)