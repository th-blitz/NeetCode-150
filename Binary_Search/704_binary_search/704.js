
function binarySearch(left, right, nums, target) {

    if (left > right) {
        return -1;
    }

    let mid = Math.floor((left + right) / 2);

    if (nums[mid] == target) {
        return mid;
    }

    if (nums[mid] > target) {
        return binarySearch(left, mid - 1, nums, target);
    }
    return binarySearch(mid + 1, right, nums, target);
}


let nums = [-1,0,3,5,9,12];
let target = 9;

console.log("nums : ", nums, " target : ", target, " result : ", binarySearch(0, nums.length - 1, nums, target));