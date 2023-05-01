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
    
	<%@ include file="/WEB-INF/views/include/head.jsp" %>

    <title>Register</title>
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

    
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>

    <div class="hero hero-inner">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 mx-auto text-center">
                    <div class="intro-wrap">
                        <h1 class="mb-0">Join Us For Free!</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="untree_co-section">
        <div class="container">
            <div class="row justify-content-center">
                <div>
                    <h2>회원가입</h2>
					<form action="${root}/member" method="post">
						<input type="hidden" id="action" name="action" value="registryaf">
						<div class="mb-3 mt-3">
							<label for="user_id">사용자 아이디:</label> <input type="text"
								class="form-control" id="user_id" placeholder="아이디 입력"
								name="user_id">
						</div>
						<div class="mb-3 mt-3">
							<label for="user_name">사용자 이름:</label> <input type="text"
								class="form-control" id="user_name" placeholder="이름 입력"
								name="user_name">
						</div>
						<div class="mb-3">
							<label for="user_password">사용자 패스워드:</label> <input
								type="password" class="form-control" id="user_password"
								placeholder="패스워드입력" name="user_password">
						</div>
						<div class="mb-1">
							<label for="email_id">이메일:</label>
						</div>
						<div class="input-group mt-1 mb-3">
							<input type="text" class="form-control" id="email_id"
								placeholder="이메일" name="email_id">@ <select
								class="form-select" id="email_domain" name="email_domain">
								<option value="naver.com">naver.com</option>
								<option value="ssafy.com">ssafy.com</option>
								<option value="google.com">google.com</option>
								<option value="anna.com">anna.com</option>
							</select>
						</div>
						<div class="mb-3">
							<label for="student_no">SSAFY 학번 (비밀번호 찾기 질문) :</label> <input
								type="password" class="form-control" id="student_no"
								placeholder="학번 입력" name="student_no">
						</div>
						<button type="submit" class="btn btn-primary">회원가입</button>
						&nbsp;&nbsp;<a href='${root}/member?action=signin'>로그인 </a>
					</form>
                </div>
            </div>
        </div>
    </div>



<%@ include file="/WEB-INF/views/include/footer.jsp" %>