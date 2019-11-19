function sumSquare(arr) {
    let sumSq=0;
    for(let i=0;i<arr.length;i++){
        if(typeof arr[i] == "number"){
            sumSq +=arr[i]*arr[i];
        }
    }
    return sumSq;
}
let arr=[1,5,3,"friend",2,"hello"];
console.log(sumSquare(arr));