function evenDash(num) {
    let newNum = [];
    let numString = num.toString();
    for (let i = 0; i < numString.length; i++) {
        for (let j = 0; j < numString.length; j++) {
            if (numString.charAt(i) % 2 === 0) {
                newNum[i] = numString[i] + "-";
            } else {
                newNum[i] = numString[i];
            }
        }
    }
    return newNum.join("");
}

console.log(evenDash(28584736485));