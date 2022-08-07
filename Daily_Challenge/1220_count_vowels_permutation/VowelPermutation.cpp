#include <iostream>
#include <unordered_map>
#include <vector>
#include <cmath>


int recur(int n, int l, int& modulo, std::vector<std::vector<int>>& vowels, std::vector<std::vector<int>>& cache) {
    
    if (cache[l][n] > 0) {
        return cache[l][n];
    }
    if (n == 0) {
        return 1;
    }
    int result = 0;
    for (int i = 0; i < vowels[l].size(); i++) {
        result += recur(n - 1, vowels[l][i], modulo, vowels, cache);
        result %= modulo;
    }
    cache[l][n] = result;
    return result;
}   

int countVowelPermutation(int n) {

    std::vector<std::vector<int>> vowels = {
        {1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}
    };
    
    std::vector<std::vector<int>> cache(vowels.size(), std::vector<int>(n, 0));

    int result = 0;
    int modulo = 1e9 + 7;
    for (int i = 0; i < vowels.size(); i++) {
        result += recur(n - 1, i, modulo, vowels, cache);
        result %= modulo;
    }

    return result;
}

int main() {

    int n = 1000;

    std::cout << "n : " << n << " | result : " << countVowelPermutation(n) << std::endl;

    return 0;
}