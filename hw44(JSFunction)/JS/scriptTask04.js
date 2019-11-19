function array_clone(arr) {
    let newArr=[];
    for(let i=0;i<arr.length;i++){
        newArr[i]=arr[i];
    }
    return newArr;
}
let arr = [1,2,5,0,45];
console.log(array_clone(arr));
newArray= array_clone([1,2,5,0,45]);
console.log(newArray);
arr[7]=555;
console.log(arr);
console.log(newArray);
newArray[7]=888;
console.log(arr);
console.log(newArray);
console.log(array_clone(arr));
newArray2=array_clone(['hello',55,'world',77,'dogs']);
console.log(newArray2);
