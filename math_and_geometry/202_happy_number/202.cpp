

class Solution {
public:
    
    int get_next(int num) {
        int next_num = 0;
        while (num != 0) {
            next_num += ((num % 10) * (num % 10));
            num = (int)(num / 10);
        }
        return next_num;
    }
    
    bool isHappy(int n) {
        int slow = n;
        int fast = get_next(slow);
        while (fast != 1 && slow != fast) {
            slow = get_next(slow);
            fast = get_next(get_next(fast));
        }
        return fast == 1;
    }
};