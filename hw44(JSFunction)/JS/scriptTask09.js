function unique(arr) {
    let uniqueArr = [];
    let counter = 0;
    for (let i = 0; i < arr.length; i++) {
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] === arr[j]) {
                counter++;
                i++;
                break;
            }
        }
        if (counter === 0) {
            uniqueArr.push(arr[i]);
        }
        counter = 0;
    }
    return uniqueArr;
}

console.log(unique([7, 9, 0, -2]));
console.log(unique([7, 7, 0, -2]));
console.log(unique([7, 9, 9, -2]));
console.log(unique([1, 1, 1, 1]));