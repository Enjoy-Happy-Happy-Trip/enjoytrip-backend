<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="site-nav">
	<div class="container">
		<div class="site-navigation">
			<a href="${root}/index.jsp" class="logo m-0">Enjoy Trip <span
				class="text-primary">.</span></a>
			<ul
				class="js-clone-nav d-none d-lg-inline-block text-left site-menu float-right">
				<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
				<!-- @@@@@@@@@@@@@@오른쪽 네비게이션 바 @@@@@@@@@@@@@@@@@@@@ -->
				<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
				<c:if test="${empty sessionScope.login}">
					<li><a href="${root}/board/boardlist">Board</a></li>
					<li><a href="${root}/tourinfo.html">TourInfo</a></li>
					<li><a href="${root}/member/signin">Sign In</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.login}">
					<c:if test="${sessionScope.login.user_id != 'admin'}">
						<li><a>[${login.user_name}]님 안녕하세요</a></li>
						<li><a href="${root}/board/boardlist">Board</a></li>
						<li><a href="${root}/tour/tourinfo.html">TourInfo</a></li>
						<li><a href="${root}/member/signout">Sign Out</a></li>
					</c:if>
					<c:if test="${sessionScope.login.user_id == 'admin'}">
						<li><a>[${login.user_name}]님 안녕하세요</a></li>
						<li><a href="${root}/board/boardlist">Board</a></li>
						<li><a href="${root}/tour/tourinfo.html">TourInfo</a></li>
						<li><a href="${root}/member/memberlist">Admin Page</a></li>
						<li><a href="${root}/member/signout">Sign Out</a></li>					
					</c:if>
				</c:if>
			</ul>

			<a href="#"
				class="burger ml-auto float-right site-menu-toggle js-menu-toggle d-inline-block d-lg-none light"
				data-toggle="collapse" data-target="#main-navbar"> <span></span>
			</a>
		</div>
	</div>
</nav>