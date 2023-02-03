

function valid_anagram(s, t) {

    let hashmap = new Uint8Array(26);
    
    if (s.length != t.length) {
        return false;
    }
    
    function idx(x) {
        return x.charCodeAt() - 97;
    }
    
    for (let i = 0; i < s.length; i++) {
        hashmap[idx(s[i])]++;
        hashmap[idx(t[i])]--;
    }
    
    for (i = 0; i < 26; i++) {
        if (hashmap[i] != 0) {
            return false;
        }
    }
    return true;
}

let s = "anagram";
let t = "nagaram";

console.log('s :', s);
console.log('t :', t);

console.log('valid anagram: ', valid_anagram(s, t));

s = "car";
t = "rat";

console.log('s :', s);
console.log('t :', t);

console.log('valid anagram: ', valid_anagram(s, t));