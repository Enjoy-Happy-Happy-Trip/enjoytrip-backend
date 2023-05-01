<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>회원관리</title>
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
						<h1 class="mb-0">회원 정보</h1>
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
							<h1>상세보기</h1>
							<form action="${root}/member" method="post">
								<table>
									<col width="40%">
									<col width="60%">
									<tr>
										<th>회원 아이디</th>
										<td><input type="text" name="user_id" width="50"
											readonly="readonly" value="${member.user_id}" /></td>
									</tr>
									<tr>
										<th>회원 이름</th>
										<td><input type="text" name="user_name" width="50"
											value="${member.user_name}" /></td>
									</tr>
									<tr>
										<th>비밀번호</th>
										<td><input type="text" name="user_password" width="50"
											value="${member.user_password}" /></td>
									</tr>
									<tr>
										<th>이메일 아이디</th>
										<td><input type="text" name="email_id" width="50"
											value="${member.email_id}" /></td>
									</tr>
									<tr>
										<th>이메일 도메인</th>
										<td><input type="text" name="email_domain" width="50"
											value="${member.email_domain}" /></td>
									</tr>
									<tr>
										<th>가입일</th>
										<td><input type="text" name="join_date" width="50"
											readonly="readonly" value="${member.join_date}" /></td>
									</tr>
									<tr>
										<th>학번</th>
										<td><input type="text" name="student_no" width="50"
											readonly="readonly" value="${member.student_no}" /></td>
									</tr>
								</table>
								<input type="hidden" name="action" value="updateGo" /> <input
									type="hidden" name="user_id" value="${member.user_id}" />
								<input type="submit" value="수정" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/include/footer.jsp"%>

</body>

</html>
