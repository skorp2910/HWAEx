'use strict';
var color = "red";
//Задание цвета локальной и глобальной переменной с вероятностью 50%
function setColorRandom() {
    var color;
    return function () {
        if (Math.floor(Math.random() * 100) <= 50) {
            return window.color = "red";
        } else {
            return color = "black";
        }
    }
}
//Задание черного цвета локальной переменной
function setColor() {
    var color;
    return function () {
        return color = "black";
    }
}
//Вывод в консоль цвета локальной и глобальной переменной
function printColor() {
    var color = setColor();
    console.log(`Local color = ${color()} global color = ${window.color}`);
}

printColor();

color = setColorRandom();
drawBox(color);

function drawBox(color) {
    document.writeln(`<div style="background:${color()};color:white;height:20px;width:200px;text-align:center">This is Div with text</div>`)
}
