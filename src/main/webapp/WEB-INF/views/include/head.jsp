<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="author" content="Untree.co" />
	<link rel="shortcut icon" href="favicon.png" />

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap4" />

	<link rel="preconnect" href="https://fonts.googleapis.com" />
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
	<link
		href="https://fonts.googleapis.com/css2?family=Inter:wght@400;700&family=Source+Serif+Pro:wght@400;700&display=swap"
		rel="stylesheet" />

	<link rel="stylesheet" href="${root}/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${root}/assets/css/owl.carousel.min.css" />
	<link rel="stylesheet" href="${root}/assets/css/owl.theme.default.min.css" />
	<link rel="stylesheet" href="${root}/assets/css/jquery.fancybox.min.css" />
	<link rel="stylesheet" href="${root}/assets/fonts/icomoon/style.css" />
	<link rel="stylesheet" href="${root}/assets/fonts/flaticon/font/flaticon.css" />
	<link rel="stylesheet" href="${root}/assets/css/daterangepicker.css" />
	<link rel="stylesheet" href="${root}/assets/css/aos.css" />
	<link rel="stylesheet" href="${root}/assets/css/style.css" />

</head>
<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
<script>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>
</script>
