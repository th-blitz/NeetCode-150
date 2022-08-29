use std::collections::HashMap;


#[derive(Debug)]
struct TrieNode {
    next_nodes: HashMap<char, TrieNode >,
    end: bool,
}

impl TrieNode {
    fn new() -> Self {
        return TrieNode { next_nodes: HashMap::new(), end: false };
    }
}

struct Trie {
    root: TrieNode,
}

pub impl Trie {
    
    fn new() -> Self {
        return Trie {root: TrieNode::new()};
    }

    fn insert(&mut self, word: String) {
        let mut current_node = &mut self.root;

        for c in word.chars() {
            let next_node = current_node.next_nodes.entry(c).or_insert(TrieNode::new());
            current_node = next_node;
        }
        current_node.end = true;
    }

    fn search(&self, word: String) -> bool {
        let mut current_node = &self.root;
        
        for c in word.chars() {
            match current_node.next_nodes.get(&c) {
                Some(next_node) => current_node = next_node,
                None => return false,
            }
        }
        return current_node.end;
    }

    fn starts_with(&self, prefix: String) -> bool {
        let mut current_node = &self.root;

        for c in prefix.chars() {
            match current_node.next_nodes.get(&c) {
                Some(next_node) => current_node = next_node,
                None => return false,
            }
        }
        return true;
    }
}



