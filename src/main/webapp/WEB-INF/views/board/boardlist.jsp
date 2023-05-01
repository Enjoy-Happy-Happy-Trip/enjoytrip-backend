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
<%@include file="/WEB-INF/views/include/head.jsp"%>

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

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>


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
							<h1>글목록</h1>
							
							<form class="d-flex" id="form-search" action="${root}/board" method="post">
								<input type="hidden" name="action" value="filter" /> 
								<select name="key"
									id="key" class="form-select form-select-sm ms-5 me-1 w-50"
									aria-label="검색조건">
									<option selected>검색조건</option>
									<option value="subject">제목</option>
									<option value="user_id">작성자</option>
									<option value="content">글내용</option>
								</select>
								<div class="input-group input-group-sm">
									<input type="text" name="word" id="word" class="form-control"
										placeholder="검색어..." />
									<input type="submit" value="검색" />
								</div>
							</form><br>

							<table class="table table-bordered">
								<col width="10%">
								<col width="20%">
								<col width="50%">
								<col width="10%">
								<col width="10%">
								<tr>
									<th>번호</th>
									<th>작성자</th>
									<th>제목</th>
									<th>조회수</th>
									<th>관리</th>
								</tr>
								<c:forEach var="board" items="${boards}" varStatus="vs">
									<tr style="text-align: center">
										<td><a
											href='${root}/board?action=detail&article_no=${board.article_no}'>${vs.count}</a></td>
										<td>${board.user_id}</td>
										<td>${board.subject}</td>
										<td>${board.hit}</td>
										<td><c:if
												test="${login.user_id == board.user_id || login.user_id == 'admin'}">
												<form action="${root}/board" method="post">
													<input type="hidden" name="action" value="updateBoard" />
													<input type="hidden" name="article_no"
														value="${board.article_no}" /> <input type="submit"
														value="수정" />
												</form>
												<form action="${root}/board" method="post">
													<input type="hidden" name="action" value="delete" /> <input
														type="hidden" name="article_no"
														value="${board.article_no}" /> <input type="submit"
														value="삭제" />
												</form>
											</c:if></td>
									</tr>
								</c:forEach>
							</table>
							<c:if test="${not empty sessionScope.login}">
								<button type="button" class="btn btn-primary btn-lg btn-block"
									onclick="location.href='${root}/board?action=boardwrite'">글쓰기</button>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>

</html>
