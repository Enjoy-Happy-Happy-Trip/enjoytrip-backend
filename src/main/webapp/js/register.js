function regist() {
    // 문서에서 id 로 input data 가져오기
    let id = document.getElementById("id").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;
    let username = document.getElementById("username").value;

    // 입력값 검증
    if (id == "" || password == "" || email == "" || username == "") {
        alert("빈칸이 없도록 입력해주세요.");
        return;
    } else {
        let localUsers = localStorage.getItem("users");

         // input data로 user 만들기
        const user = {
            id: id,
            password: password,
            email: email,
            username: username
        };    

        if (localUsers === null) {
            localUsers = [user];
        } else {
            localUsers = JSON.parse(localUsers);
            localUsers.push(user);
        }

        // user 객체 문자열로 바꿔서 로컬스토리지에 저장
        localStorage.setItem("users", JSON.stringify(localUsers));
        alert("사용자 등록 성공!");
        // 로그인 화면으로 돌아가기
        window.location.replace("signin.html");
    }
}