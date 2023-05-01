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

            let deleteButton = document.createElement("td");
            let button = document.createElement("button");
            button.setAttribute("id", i);
            button.setAttribute("type", "button");
            button.setAttribute("class", "rounded");
            button.setAttribute("onclick", "deleteContent(this.id)");
            button.innerHTML = "삭제";
            deleteButton.appendChild(button);
            tr.appendChild(deleteButton);

            tbody.appendChild(tr);
        }
    }
}

function deleteContent(idx) {
    let localContents = localStorage.getItem("contents");
    localContents = JSON.parse(localContents);

    let index = 0;

    if (localContents.length == 1) {
        localStorage.removeItem("contents");
    } else {
        for (let i = 0; i < localContents.length; i++) {
            console.log(localContents[i].num + " " + (parseInt(idx)+parseInt(1)));
            if (localContents[i].num === (parseInt(idx)+parseInt(1))) {
                index = i;
                break;
            }
        }
        
        for (let i = index; i < localContents.length - 1; i++) {
            localContents[i] = localContents[i + 1];
            localContents[i].num -= 1;
        }
    
        localStorage.setItem("contents", JSON.stringify(localContents.slice(0, localContents.length-1)));
    
    }

    window.location.replace("board-admin.html");
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
        window.location.replace("board-admin.html");
    }
}

function initTable() {
    let tbody = document.querySelector("#board-contents");
    let len = tbody.rows.length;

    for (let i = len - 1; i >= 0; i--) {
        tbody.deleteRow(i);
    }
}