class TrieNode {

    TrieNode[] root;
    private static final int letters = 26;
    boolean isWord;

    public TrieNode() {
        root = new TrieNode[letters];
        isWord = false;
    }

    public boolean containsKey(char ch) {
        return root[ch - 'a'] != null;
    }

    public TrieNode insertKey(char ch) {
        TrieNode newNode = new TrieNode();
        root[ch - 'a'] = newNode;
        return newNode;
    }

    public TrieNode getKey(char ch) {
        return root[ch - 'a'];
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord() {
        isWord = true;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curNode = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (!curNode.containsKey(curr)) {
                curNode = curNode.insertKey(curr);
            } else {
                curNode = curNode.getKey(curr);
            }
        }

        curNode.setWord();
    }

    public boolean search(String word) {
        TrieNode search = searchWord(word);
        return (search != null && search.isWord());
    }

    public boolean startsWith(String prefix) {
        TrieNode search = searchWord(prefix);
        return search != null;
    }

    private TrieNode searchWord(String word) {

        TrieNode curNode = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (curNode.containsKey(curr)) {
                curNode = curNode.getKey(curr);
            } else {
                return null;
            }
        }

        return curNode;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */