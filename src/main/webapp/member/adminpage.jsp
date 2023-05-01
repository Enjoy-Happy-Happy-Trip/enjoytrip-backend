<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- /*
* Template Name: Tour
* Template Author: Untree.co
* Tempalte URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!doctype html>
<html lang="en">
<head>
<%@include file="/include/head.jsp"%>

<title>회원 관리 페이지</title>
</head>

<body>

	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close">
				<span class="icofont-close js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<%@ include file="/include/nav.jsp"%>


	<div class="hero hero-inner">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 mx-auto text-center">
					<div class="intro-wrap">
						<h1 class="mb-0">회원 관리</h1>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="untree_co-section">
		<div class="container my-5">
			<div class="row justify-content-center">
				<div class="col-sm-10">
					<div class="row mb-5">
						<div class="table-responsive" style="width: 100%">
							<h1>회원 목록</h1>
							<table class="table table-bordered">
								<col width="10%">
								<col width="10%">
								<col width="10%">
								<col width="20%">
								<col width="20%">
								<col width="20%">
								<col width="10%">
								<tr>
									<th>아이디</th>
									<th>닉네임</th>
									<th>비밀번호</th>
									<th>이메일</th>
									<th>도메인</th>
									<th>회원가입 날짜</th>
									<th>학번</th>
									<th>관리</th>									
								</tr>
								<c:forEach var="member" items="${members}">
									<tr style="text-align: center">
										<td>${member.user_id}</td>
										<td>${member.user_name}</td>
										<td>${member.user_password}</td>
										<td>${member.email_id}</td>
										<td>${member.email_domain}</td>
										<td>${member.join_date}</td>
										<td>${member.student_no}</td>
										<td>
											<form action="${root}/member?action=detail" method="post">
												<input type="hidden" name="action" value="updateBoard" /> <input
													type="hidden" name="user_id" value="${member.user_id}" />
												<input type="submit" value="수정" />
											</form>
											<form action="${root}/member?action=delete" method="post">
												<input type="hidden" name="action" value="delete" /> <input
													type="hidden" name="user_name" value="${member.user_id}" />
												<input type="submit" value="삭제" />
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/include/footer.jsp"%>

</body>

</html>
