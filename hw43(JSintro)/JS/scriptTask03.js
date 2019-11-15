let numb;
numb = +prompt("Введите число, у которого будут найдены все делители:");
let arr=[];
for(let i=1;i<=numb;i++){
    if(numb%i===0){
        arr.push(i);
    }
}
alert("Все делители этого числа: "+ arr);