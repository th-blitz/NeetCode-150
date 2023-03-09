

int getSum(int a, int b){
    int mask = 0xffffffff;
    unsigned int x = a;
    unsigned int y = b;
    unsigned int result;
    unsigned int carry;
    while (y != 0) {
        result = (x ^ y) & mask;
        carry = ((x & y) & mask) << 1;
        x = result;
        y = carry;
    }
    return x < 0x7fffffff ? x : ~(x ^ mask);
}