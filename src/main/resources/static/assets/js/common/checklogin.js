const navLinkInfos = {
    board: {
        href: "/board/boardlist",
        content: "Board",
    },
    tourInfo: {
        href: "/tourinfo.html",
        content: "TourInfo",
    },
    signIn: {
        href: "/member/signin",
        content: "Sign In",
    },
    signOut: {
        href: "/member/signout",
        content: "Sign Out",
    },
    myPlan: {
        href: "/plan/myplanlist",
        content: "My Plans",
    },
    adminPage: {
        href: "/member/memberlist",
        content: "Admin Page",
    },
};

const navLinks = document.querySelector("#nav-links");

// login의 여부를 컨트롤러에 물어보고 nav-link를 동적으로 구성한다.
const loginCheckUrl = "/member/check";
fetch(loginCheckUrl)
    .then((response) => response.json())
    .then((data) => makeNav(data.isLogin));

function makeNav(isLogin) {
    navLinks.appendChild(makeNavList("board"));
    navLinks.appendChild(makeNavList("tourInfo"));
    if (isLogin === 1) {
        // 일반 사용자라면
        navLinks.appendChild(makeNavList("myPlan"));
        navLinks.appendChild(makeNavList("signOut"));
    } else if (isLogin === 2) {
        // admin 이라면
        navLinks.appendChild(makeNavList("adminPage"));
        navLinks.appendChild(makeNavList("signOut"));
    } else {
        // login 안되어 있으면
        navLinks.appendChild(makeNavList("signIn"));
    }
}

function makeNavList(navName) {
    const li = document.createElement("li");
    const a = document.createElement("a");
    a.classList.add("nav-link");
    a.setAttribute("href", navLinkInfos[navName].href);
    a.innerText = navLinkInfos[navName].content;
    li.appendChild(a);
    return li;
}
