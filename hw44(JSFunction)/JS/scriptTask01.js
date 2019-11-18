'use strict';
let color;

function setColor() {
    let color;
    if (Math.floor(Math.random() * 100) <= 50) {
        window.color = "red";
        return window.color;
    } else {
        color="black";
        return color;
    }
}
function printColor(){
    let color;
    setColor();
    console.log(`Local color = ${color} global color = ${window.color}`);
}
printColor();
color=setColor();
drawBox(color);

function drawBox() {
    document.writeln(`<div style="background:${color};color:white;height:20px;width:200px;text-align:center">This is Div with text</div>`)
}




