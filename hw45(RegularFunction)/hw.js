function isUpperCaseFirstLetter(str) {
    return /^[A-ZА-ЯёЁ]/g.test(str);
}

function isValidEmail(str) {
    return /\w+@\w+\.\w+/g.test(str);
}

function trimString(str) {
    str = str.replace(/^\s*/, "")
        .replace(/\s*$/, "")
        .replace(/\s{2+,}/g, " ");
    return str;
}

function thousandsSeparators(num) {
    num=num.toString().replace(/(\d)(?=((\d{3})+)(\D|$))/g, '$1,');
    return num;
}
