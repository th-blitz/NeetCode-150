#include "iostream"
#include "string"
#include "unordered_map"
#include "stack"

bool isValid(std::string s) {

    std::unordered_map<char, char> brackets;
    std::stack<char> stack;

    brackets[')'] = '(';
    brackets['}'] = '{';
    brackets[']'] = '[';

    for(int i = 0; i < s.size(); i++) {
        if(brackets.count(s[i]) == false) {
            stack.push(s[i]);
        } else if((stack.size() != 0) && (brackets[s[i]] == stack.top())) {
            stack.pop();
            continue;
        } else {
            return false;
        }
    }
    
    return stack.size() == 0;
}


int main() {

    std::string s = "{(){}[]}";
    std::cout << "test case : " << s << " result : " << isValid(s) << std::endl;

    s = "{}()[]{)";
    std::cout << "test case : " << s << " result : " << isValid(s) << std::endl;
    return 0;
}