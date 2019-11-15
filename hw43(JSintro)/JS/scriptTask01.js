let start;
let finish;
let sum=0;
start= +prompt("Введине нижнюю границу для подсчета суммы: ");
finish= +prompt("Введине верхнюю границу для подсчета суммы: ");
for(let i=start;i<=finish;i++){
    sum+=i;
}
alert(`Сумма чисел в заданном диапазоне равна ${sum}`);
console.dir(`Сумма чисел в заданном диапазоне равна ${sum}`);
