let num;
let colShift;
num= prompt("Введите любое число:");
colShift= +prompt("На сколько цифр его надо сдвинуть?");
alert(num.substring(colShift)+num.substring(0,colShift));