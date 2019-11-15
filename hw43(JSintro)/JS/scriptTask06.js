let num1;
let num2;
let sign;
let result;

while (true) {
    num1 = +prompt("Введите первое число:");
    num2 = +prompt("Введите второе число:");
    sign = prompt("Введите арифметический знак:");
    switch (sign) {
        case '+':
            result = num1 + num2;
            alert(`Результат сложения этих чисел равен = ${result}`);
            break;
        case '-':
            result = num1 - num2;
            alert(`Результат вычитания этих чисел равен = ${result}`);
            break;
        case '*':
            result = num1 * num2;
            alert(`Результат умножения этих чисел равен = ${result}`);
            break;
        case '/':
            if (num2 !== 0) {
                result = num1 / num2;
            } else {
                alert("на ноль делить нельзя!");
                break;
            }
            alert(`Результат деления этих чисел равен = ${result}`);
            break;
    }
    if (!confirm("Хотите решить еще один пример?")) {
        break;
    }
}
