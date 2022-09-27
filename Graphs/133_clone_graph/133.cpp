#include <vector>
using namespace std;

/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution {
public:
    
    Node* clone_node(Node* node, vector<Node*> &hashset) {
        if (node == nullptr) return node;
        if (hashset[node -> val - 1] != nullptr) return hashset[node -> val - 1];
        
        Node* new_node = new Node(node -> val, vector<Node*>(node -> neighbors.size(), nullptr));
        hashset[node -> val - 1] = new_node;
        for (int i = 0; i < node -> neighbors.size(); i++) {
            new_node -> neighbors[i] = clone_node(node -> neighbors[i], hashset);
        }
        return new_node;
    }
    
    Node* cloneGraph(Node* node) {
        vector<Node*> hashset(100, nullptr);
        Node* node_clone = clone_node(node, hashset);
        return node_clone;
    }
};