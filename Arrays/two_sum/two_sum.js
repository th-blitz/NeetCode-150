

function twoSum(nums, target) {

    let hashmap = new Map();
    
    for (let i = 0; i < nums.length; i++) {
        if (hashmap.has(target - nums[i])) {
            return [hashmap.get(target - nums[i]), i]
        }
        hashmap.set(nums[i], i)
    }
    return [-1, -1]   
}


testCase1 = [2,7,11,15];
target = 9;

console.log('testCase1 : ', testCase1);
console.log('target : ', target);
console.log('result : ', twoSum(testCase1, target));

