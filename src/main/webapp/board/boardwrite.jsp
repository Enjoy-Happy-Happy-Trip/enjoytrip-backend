<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<title>게시판</title>
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

	<%@ include file="/include/nav.jsp" %>

	<div class="hero hero-inner">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 mx-auto text-center">
					<div class="intro-wrap">
						<h1 class="mb-0">게시판</h1>
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
							<h1>글작성</h1>
							<form action="${root}/board" method="post">
								<input type="hidden" name="action" value="bwrite" />
								<table>
									<col width="40%">
									<col width="60%">
									<tr>
										<th>작성자</th>
										<td><input type="text" name="user_id" readonly="readonly"
											width="50" value="${login.user_id}" /></td>
									</tr>
									<tr>
										<th>제목</th>
										<td><input type="text" name="subject" width="50" /></td>
									</tr>
									<tr>
										<th>내용</th>
										<td><textarea name="content" rows="10" cols="50"></textarea>
										</td>
									</tr>
									<tr>
										<td colspan="2"><button type="submit" class="btn btn-primary">글쓰기</button></td>
									</tr>
								</table>
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
