use std::collections::HashMap;

impl Solution { 

    pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
        
        let mut anagram: [u8; 26] = [0; 26];
        let mut hashmap: HashMap<[u8; 26], Vec<String>> = HashMap::new();

        for string in strs.iter() {
            for chr in string.chars() {
                anagram[chr as usize - 97] += 1;
            }
            hashmap.entry(anagram).or_insert(Vec::new()).push(string.clone());
            for i in 0..26 {
                anagram[i] = 0;
            }
        }
        return hashmap.values().cloned().collect();
    }
}