+prompt("Загадайте целое число от 0 до 100.");
let N =50;
let max=100;
let min=0;
let count=1;
let bool=true;
while (bool) {
    let res = prompt(`Ваше число >, < или = ${N}?`);
    switch (res) {
        case '>':
            min=N;
            N = N + Math.floor((max - min) / 2);
            count++;
            break;
        case '<':
            max=N;
            N = N - Math.floor((max - min) / 2);
            count++;
            break;
        case '=':
            alert(`Ваше число ${N} угадано за ${count} попыток!`);
            bool=false;
            break;
        default:
            alert('Введите корректный символ: ">","<","="!!!');
            break;
    }
}