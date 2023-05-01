function signin() {
    // 문서에서 id로 input data 가져오기
    let id = document.getElementById("id").value;
    let password = document.getElementById("password").value;

    // 로컬스토리지에 "user" 키로 저장된 item 가져와서 json 객체로 만들기
    const user = JSON.parse(localStorage.getItem("users"));

    let check = 0;
    var userId;
    var username;

    if (user === null) {
        alert("회원가입을 먼저 해주세요");
    } else {
        for (let i = 0; i < user.length; i++) {
            // 입력값 검증
            if (id == user[i].id && password == user[i].password) {
                check = 1;
                userId = user[i].id;
                username = user[i].username;
                break;
            }
        }
    
        // 입력값 검증
        if (check == 1) {
            if (userId == "admin") {
                sessionStorage.setItem("username", "관리자");
                alert("관리자 로그인");
                window.location.replace("index-signed-in-admin.html");
            } else {
                sessionStorage.setItem("username", username);
                alert("사용자 로그인");
                window.location.replace("index-signed-in-user.html");
            }
        } else {
            alert("로그인 실패 !");
        }
    }
}