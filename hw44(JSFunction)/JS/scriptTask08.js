function shuffleArray(arr) {
    for (let j= arr.length - 1; j >0; j--) {
        let i = Math.floor(Math.random() * (j + 1));
        let tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
    return arr;
}
arr=[1,4,6,44,33,45,66,3,4444,76,98];
shuffleArray(arr);
console.log(arr);