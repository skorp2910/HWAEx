const url = 'http://localhost:8080/spring-binding-data/api/students';

// function loadData() {
//     let tbody = document.querySelector("tbody");
//     tbody.innerText = "";
//     var xhr = new XMLHttpRequest();
//     xhr.open("GET",'<spring:url value="/api/students"/>',true);
//     xhr.onreadystatechange = function () {
//         if(xhr.readyState===4 && xhr.status===200){
//             var students = JSON.parse(xhr.responseText);
//
//             students.forEach((s) =>{
//                 let tr = document.createElement("tr");
//                 for(let val in s){
//                     let td = document.createElement("td");
//                     td.appendChild(document.createTextNode(s[val]));
//                     tr.appendChild(td);
//                 }
//                 let td = document.createElement("td");
//                 let btn =document.createElement("button");
//                 let btn2 =document.createElement("button");
//                 btn.setAttribute('data-id',s.id);
//                 btn2.setAttribute('data-id',s.id);
//                 btn.appendChild(document.createTextNode('Delete'));
//                 btn2.appendChild(document.createTextNode('Update'));
//
//                 addDeleteHandler(btn);
//                 addUpdateHandler(btn2);
//
//                 td.appendChild(btn);
//                 td.appendChild(btn2);
//                 tr.appendChild(td);
//                 tbody.appendChild(tr);
//             });
//         }
//
//     };
//     xhr.send();
// }

function loadData() {
    fetch(url, {method: 'GET'})
        .then(resp => resp.json())
        .then(student => {
            let tbody = document.querySelector("tbody");
            tbody.innerText = "";
            students.forEach((s) => {
                let tr = document.createElement("tr");
                for (let val in s) {
                    let td = document.createElement("td");
                    td.appendChild(document.createTextNode(s[val]));
                    tr.appendChild(td);
                }
                let td = document.createElement("td");
                let btn = document.createElement("button");
                let btn2 = document.createElement("button");
                btn.setAttribute('data-id', s.id);
                btn2.setAttribute('data-id', s.id);
                btn.appendChild(document.createTextNode('Delete'));
                btn2.appendChild(document.createTextNode('Update'));

                addDeleteHandler(btn);
                addUpdateHandler(btn2);

                td.appendChild(btn);
                td.appendChild(btn2);
                tr.appendChild(td);
                tbody.appendChild(tr);
            }).catch(error => {
                console.error("Error remove: " + error);
            })
        });
}
loadData();

function addDeleteHandler(btn) {
    btn.addEventListener("click", function () {
        let id = this.getAttribute('data-id');
        let url = '<spring:url value="/api/students/"/>' + id;
        fetch(url, {method: 'DELETE'})
            .then(resp => {
                console.log("Ok");
                let tr = btn.parentElement.parentElement;
                let tbody = tr.parentElement;
                tbody.removeChild(tr);
            }).catch(error => {
            console.error("Error remove: " + error);
        });
    });
}

function addUpdateHandler(btn2) {
    btn2.addEventListener("click", function () {
        let id = this.getAttribute('data-id');
        let url = '<spring:url value="/api/students/"/>' + id;
        fetch(url, {method: 'PUT'})
            .then(resp => {
                console.log("Update hello!");
                let tr = btn2.parentElement.parentElement;
                let tbody = tr.parentElement;
                tbody.childNodes
            }).catch(error => {
            console.error("Error remove: " + error);
        });
    });
}