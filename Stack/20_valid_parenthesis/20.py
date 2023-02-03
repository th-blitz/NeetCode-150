import collections

def isValid(s):

    brackets = {
        ')' : '(',
        '}' : '{',
        ']' : '['
    }

    stack = collections.deque()

    for x in s:
        if x not in brackets:
            stack.append(x)
        elif len(stack) != 0 and brackets[x] == stack.pop():
            continue
        else:
            return False
        
    if len(stack) == 0:
        return True
    return False


s = '(()())'
print(f'test case : {s}  result : {isValid(s)}')

s = '{({[]})}}'
print(f'test case : {s}  result : {isValid(s)}')

