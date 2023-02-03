

def hashmap_method(nums, target):
        
    hashmap = {}
    for i, x in enumerate(nums):
        
        if target - x in hashmap.keys():
            return [i, hashmap[target-x]]
        hashmap.update({x:i})
    return [-1, -1]



nums = [2,7,11,15]
target = 9

print('test_case_1: ', nums)
print('target : ', target)
print('result : ', hashmap_method(nums, target))
            