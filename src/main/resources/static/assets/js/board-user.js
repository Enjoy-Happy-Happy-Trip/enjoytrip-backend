window.onload = function () {
    let contents = localStorage.getItem("contents");

    let contentsList = document.querySelector("#board-contents");

    contents = JSON.parse(contents);

    let tbody = document.querySelector("#board-contents");
    initTable();

    if (contents != null) {
        for (let i = 0; i < contents.length; i++) {
            let tr = document.createElement("tr");

            let num = document.createElement("td");
            num.appendChild(document.createTextNode(contents[i].num));
            tr.appendChild(num);

            let name = document.createElement("td");
            name.appendChild(document.createTextNode(contents[i].name));
            tr.appendChild(name);

            let date = document.createElement("td");
            date.appendChild(document.createTextNode(contents[i].date));
            tr.appendChild(date);

            let title = document.createElement("td");
            title.appendChild(document.createTextNode(contents[i].title));
            tr.appendChild(title);

            let message = document.createElement("td");
            message.appendChild(document.createTextNode(contents[i].message));
            tr.appendChild(message);

            tbody.appendChild(tr);
        }
    }
}

function submitContent() {
    let user = sessionStorage.getItem("username");
    if (user === null) {
        alert("게시물을 등록하려면 로그인을 하셔야 합니다.");
    } else {
        
    let today = new Date();

    let year = today.getFullYear(); // 년도
    let month = today.getMonth() + 1;  // 월
    let day = today.getDate();  // 날짜
    let num = 0;
    let localContents = localStorage.getItem("contents");
    
    if (localContents != null) {
        let size = JSON.parse(localContents).length;
        num = size + 1;
    } else {
        num = 1;
    }

    let name = sessionStorage.getItem("username");
    let date = year + "/" + month + "/" + day;
    let title = document.getElementById("title").value;
    let message = document.getElementById("message").value;

    const content = {
        num: num,
        name: name,
        date: date,
        title: title,
        message: message
    };

    if (localContents === null) {
        localContents = [content];
    } else {
        localContents = JSON.parse(localContents);
        localContents.push(content);
    }

    localStorage.setItem("contents", JSON.stringify(localContents));
    alert("게시물 등록 성공!");
    window.location.replace("board-user.html");
    }
}

function initTable() {
    let tbody = document.querySelector("#board-contents");
    let len = tbody.rows.length;

    for (let i = len - 1; i >= 0; i--) {
        tbody.deleteRow(i);
    }
}