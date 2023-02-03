

function brute_force(array) {
    for (let i = 0; i < array.length; i++) {
        for (let j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
                return true;
            }
        }
    }
    return false;
}

function hash_set(array) {

    let hashset = new Set();

    for (let i = 0; i < array.length; i++) {
        if (hashset.has(array[i])) {
            return true;
        }
        hashset.add(array[i])
    }
    return false;
}

let test_case_1 = [1, 2, 3, 4, 5, 6];
let test_case_2 = [1, 2, 2, 3, 4, 5];

console.log('test case 1 :', test_case_1);
console.log('test case 2 :', test_case_2);

console.log('brute_force 1: ', brute_force(test_case_1));
console.log('brute_force 2: ', brute_force(test_case_2));

console.log('hashset 1: ', hash_set(test_case_1));
console.log('hashset 2: ', hash_set(test_case_2));
