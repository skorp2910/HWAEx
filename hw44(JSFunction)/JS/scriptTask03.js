let arr=[3,'b',45, 'a','a','b','test','b',3,'a','b',8,9,'b'];
let counter=0;
let maxCounter=0;
let element;
for(let i=0;i<arr.length;i++){
    for(let j=0;j<arr.length;j++){
        if(arr[i]===arr[j]){
            counter++;
        }
        if(counter>maxCounter){
            maxCounter=counter;
            element=arr[i];
        }
    }
    counter=0;
}

function printArr(){
    for(let i=0;i<arr.length;i++){
        document.write(`${arr[i]} `);
    }
}
document.writeln(`<div>Исходный массив:</div>`);
printArr();
document.writeln(`<div>Наиболее часто встречающийся элемент в этом массиве:</div>`);
document.write(`<div>${element} ( ${maxCounter} times )</div>`);
console.log(` ${element} ( ${maxCounter} times )`);
