#include <vector>
#include <string>

using namespace std;

struct TrieNode {
    vector<TrieNode*> nextNodes;
    bool end;
    TrieNode() : end(false), nextNodes(26, nullptr) {}
};

class Trie {

private:
    
    int index(char character) {
        return int(character) - 97;
    }
    
    void set_end(TrieNode* node) {
        node -> end = true;
    }
    
    void add(TrieNode* node, char character, TrieNode* newNode) {
        node -> nextNodes[index(character)] = newNode;
    }
    
    TrieNode* get(TrieNode* node, char character) {
        return node -> nextNodes[index(character)];
    }
    
    TrieNode* create() {
        TrieNode* node = new TrieNode();
        return node;
    }
    
    void insertRecur(TrieNode* node, int index, int &wordLen, string &word) {
        if (index == wordLen) {
            return set_end(node);
        }
        if (get(node, word[index]) == nullptr) {
            add(node, word[index], create());
        }
        return insertRecur(get(node, word[index]), index + 1, wordLen, word);
    }
    
    bool searchRecur(TrieNode* node, int index, int &wordLen, string &word) {
        if (index == wordLen) {
            return node -> end;
        }
        if (get(node, word[index]) == nullptr) {
            return false;
        }
        return searchRecur(get(node, word[index]), index + 1, wordLen, word);
    }
    
    bool startsWithRecur(TrieNode* node,int index,int &wordLen, string &word) {
        if (index == wordLen) {
            return true;
        }
        if (get(node, word[index]) == nullptr) {
            return false;
        }
        return startsWithRecur(get(node, word[index]), index + 1, wordLen, word);
    }
    
public:
    
    TrieNode* root;
    
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        int wordLen = word.size();
        return insertRecur(root, 0, wordLen, word);
    }
    
    bool search(string word) {
        int wordLen = word.size();
        return searchRecur(root, 0, wordLen, word);
    }
    
    bool startsWith(string prefix) {
        int wordLen = prefix.size();
        return startsWithRecur(root, 0, wordLen, prefix);
    }
};
