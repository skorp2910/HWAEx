let listItems = document.getElementById('ulToDo');
let inputItem = document.getElementById('input');
let btnAdd = document.getElementById('btnAdd');

function createLi(text) {
    let li = document.createElement("li");
    let inputCheck = document.createElement('input');
    inputCheck.type = "checkbox";
    inputCheck.id = "checkId";
    li.appendChild(inputCheck);
    let span = document.createElement('span');
    span.appendChild(document.createTextNode(text));
    li.appendChild(span);
    let btnDel = document.createElement('button');
    btnDel.id = "btnDel";
    btnDel.appendChild(document.createTextNode("delete"));
    li.appendChild(btnDel);
    li.appendChild(document.createElement('hr'));

    function deleteItem() {
        this.parentNode.parentNode.removeChild(this.parentNode);
    }

    btnDel.addEventListener('click', deleteItem);

    function show() {
        if (inputCheck.checked) {
            let span = inputCheck.nextElementSibling;
            span.style.textDecoration = "line-through";
            span.style.color = "darkgray";
        } else {
            let span = inputCheck.nextElementSibling;
            span.style.textDecoration = "none";
            span.style.color = "black";
        }
    }

    inputCheck.addEventListener('click', show);
    return li;
}

function addList() {
    if (inputItem.value !== "") {
        let item = createLi(inputItem.value);
        listItems.appendChild(item);
        inputItem.value = '';
    }
}

btnAdd.addEventListener('click', addList);
document.addEventListener('keydown', function (e) {
    if (e.code === 'Enter') {
        addList();
    }
});






