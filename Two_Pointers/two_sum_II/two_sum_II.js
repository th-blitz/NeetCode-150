

function twoSum(numbers, target) {
    
    let i = 0;
    let j = numbers.length;
    let summation = -1

    while ( i < j) {

        summation = numbers[i] + numbers[j];

        if (summation == target) {
            return [i + 1, j + 1];
        }
        if (summation < target) {
            i += 1;
        } else {
            j -= 1;
        }
    }

    return [-1, -1];

}


let numbers = [2, 7, 11, 15];
let target = 9;

console.log('result : ', twoSum(numbers, target));

