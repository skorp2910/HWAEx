let row = 9;
let col = 10;

document.write("<table><caption>Multiplication table</caption>");
document.write("<tr><td></td>");
for (let i = 1; i <= col; i++) {
    document.write("<td>" + i + "</td>");
}
document.write("</tr>");
for (let i = 2; i <= row; i++) {
    document.write("<tr><td>" + i + "</td>");
    for (let j = 1; j <= col; j++) {
        document.write("<td style='background-color: dodgerblue'>" + (i * j) + "</td>");
    }
    document.write("</tr>");
}
document.write("</table>");