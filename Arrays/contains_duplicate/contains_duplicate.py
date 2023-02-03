


if __name__ == "__main__":
    Main()

def brute_force(array):

    for i in range(len(array)):
        for j in range(i + 1, len(array)):
            if nums[i] == nums[j]:
                return True

    return False

def hashmap(array):

    hashmap = set()

    for x in array:
        if x in hashmap:
            return True

    return False

def Main():

    test_case_1 = [1, 2, 3, 4, 5, 6]
    test_case_2 = [1, 2, 2, 3, 4, 5]

    print(f'test case 1: {test_case_1}')
    print(f'test case 2: {test_case_2}')
    print(f'brute force: {brute_force(test_case_1)}')
    print(f'brute force: {brute_force(test_case_2)}')
    print(f'hashmap: {hashmap(test_case_1)}')
    print(f'hashmap: {hashmap(test_case_2)}')

    
