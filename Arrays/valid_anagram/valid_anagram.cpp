
#include <iostream>
#include <string>
using namespace std;

int idx(char x) {
    return int(x) - 97;
}

bool isAnagram(string s, string t) {

    int i;
    int hashmap[26] = {0};

    if (s.size() != t.size()) {
        return false;
    }

    for (i = 0; i < s.size(); i++) {
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

int main() {

    string s = "anagram"; string t = "nagaram";

    cout << "test case 1: " << endl;
    cout << "s : " << s << endl;
    cout << "t : " << t << endl;
    cout << "is anagram : " << isAnagram(s, t) << endl;

    s = "rat"; t = "car";

    cout << "test case 2: " << endl;
    cout << "s : " << s << endl;
    cout << "t : " << t << endl;
    cout << "is anagram : " << isAnagram(s, t) << endl;

    return 0;
}
