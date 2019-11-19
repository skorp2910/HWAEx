function first(arr, n = 1) {
    let firstItem = [];
    if (arr.length >= n) {
        for (let i = 0; i < n; i++) {
            firstItem[i] = arr[i];
        }
    } else {
        for (let i = 0; i < arr.length; i++) {
            firstItem[i] = arr[i];
        }
    }
    return firstItem;
}

console.log(first([7, 9, 0, -2]));
console.log(first([], 3));
console.log(first([7, 9, 0, -2], 3));
console.log(first([7, 9, 0, -2], 6));
console.log(first([7, 9, 0, -2], -3));