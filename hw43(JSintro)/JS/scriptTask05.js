let pol = 0;
let otr = 0;
let odd = 0;
let even = 0;
let zero = 0;
let numb;
for (let i = 0; i < 10; i++) {
    numb = +prompt("Введите любое число(положительное или отрицательное):");
    if (numb > 0) {
        pol++;
        if (numb % 2 === 0) {
            even++;
        } else {
            odd++;
        }
    } else if (numb < 0) {
        otr++;
        if (numb % 2 === 0) {
            even++;
        } else {
            odd++;
        }
    } else {
        zero++;
    }
}
alert(`Из этих чисел:\n положительных - ${pol},\n отрицательных - ${otr},\n нулей - ${zero};\n из них нечетных чисел - ${odd},\n четных чисел - ${even}.`);
