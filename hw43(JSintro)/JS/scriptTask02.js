let min;
let max;
let nod;
min = +prompt("Введите первое целое число");
max = +prompt("Введите второе целое число");

while (min !== max) {
    if (min === 0) {
        nod = undefined;
        break;
    }
    if (max === 0) {
        nod = undefined;
        break;
    }
    if (min > max) {
        min = min - max;
    } else {
        max = max - min;
    }
    nod = min;
}
console.dir(`Наибольший общий делитель введенных чисел равен ${nod}`);
alert(`Наибольший общий делитель введенных чисел равен ${nod}`);