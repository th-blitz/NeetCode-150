/**
 * M: size of key word, N number of words in the Trie.
 * addWord: T: O(M), S: O(M) -> In case all the letter of the word are not already present.
 * searchWord: T: O(M ^ 26), S: O(1)
 */

class TreeNode {

    HashMap<Character, TreeNode> kids;
    boolean isWord = false;

    TreeNode() {
        kids = new HashMap<Character, TreeNode>();
    }
}

class WordDictionary {

    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curNode = root;

        for (char c : word.toCharArray()) {

            if (!curNode.kids.containsKey(c)) {
                curNode.kids.put(c, new TreeNode());
            }

            curNode = curNode.kids.get(c);
        }

        curNode.isWord = true;
    }

    public boolean search(String word) {

        return searchWord(word, root);
    }

    private boolean searchWord(String word, TreeNode curNode) {


        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curNode.kids.containsKey(c)) {

                if (c == '.') {

                    for (char x : curNode.kids.keySet()) {

                        if (searchWord(word.substring(i + 1), curNode.kids.get(x))) {
                            return true;
                        }
                    }
                }

                return false;

            } else {
                curNode = curNode.kids.get(c);
            }
        }

        return curNode.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */