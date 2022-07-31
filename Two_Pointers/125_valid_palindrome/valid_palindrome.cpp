
#include <iostream>
#include <cctype>
using namespace std;

bool isPalindrome(string s) {

    int i = 0;
    int j = s.size() - 1;

    while (i < j) {
    
            while ((i < j) && (isalnum(s[i]) == false)) {
                i++;
            }
            
            while ((i < j) && (isalnum(s[j]) == false)) {
                j--;
            }
            
            if (tolower(s[i]) != tolower(s[j])) {
                return false;
            }
            
            i++;
            j--;
        }
        return true; 
}


int main() {

    string s = "A man, a plan, a canal: Panama";

    cout << "result : " << isPalindrome(s) << endl;

    return 0;
}