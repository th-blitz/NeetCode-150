

int max(unsigned int a, unsigned int b) {
    if (a > b) return a;
    return b;
}

int idx(char x) {
    int idx = x - 32;
    return idx;
}

int lengthOfLongestSubstring(char * s){
    bool* window = (bool*)malloc(sizeof(bool) * 96);
    for (int i = 0; i < 96; i++) {
        window[i] = false;
    }
    int max_count = 0;
    int count = 0;
    int i = 0;
    int j = 0;

    while (s[j] != '\0') {
        if ((i == j) || (window[idx(s[j])] == false)) {
            window[idx(s[j])] = true;
            count += 1;
            max_count = max(count, max_count);
            j += 1;
        } else {
            window[idx(s[i])] = false;
            count -= 1;
            i += 1;
        }
    }
    return max_count;
}