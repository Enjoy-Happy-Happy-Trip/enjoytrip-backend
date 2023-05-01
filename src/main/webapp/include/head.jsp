<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<meta charset="UTF-8">
<%-- 부트스트랩 사용을 위한 코드 --%>




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

	<link rel="stylesheet" href="${root}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${root}/css/owl.carousel.min.css" />
	<link rel="stylesheet" href="${root}/css/owl.theme.default.min.css" />
	<link rel="stylesheet" href="${root}/css/jquery.fancybox.min.css" />
	<link rel="stylesheet" href="${root}/fonts/icomoon/style.css" />
	<link rel="stylesheet" href="${root}/fonts/flaticon/font/flaticon.css" />
	<link rel="stylesheet" href="${root}/css/daterangepicker.css" />
	<link rel="stylesheet" href="${root}/css/aos.css" />
	<link rel="stylesheet" href="${root}/css/style.css" />


<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
<script>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>
</script>
