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


<%@ include file="/include/head.jsp"%>

<title>Sign In</title>
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
						<h1 class="mb-0">Sign In And Get Started!</h1>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="untree_co-section">
		<div class="container">
			<div class="row justify-content-center">
				<div>
					<form class="signin-form" action="${root}/member" method="post"
						data-aos="fade-up" data-aos-delay="200">
						<input type="hidden" id="action" name="action" value="loginaf">
						<div class="row justify-content-center">
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="user_id">ID</label> <input
										type="text" class="form-control" id="user_id" name="user_id">
								</div>
							</div>
							<div class="col-6">
								<div class="form-group">
									<label class="text-black" for="user_password">Password</label>
									<input type="password" class="form-control" id="user_password" name="user_password">
								</div>
							</div>
							<button type="submit" class="btn btn-primary btn-lg btn-block">Sign
								In</button>
							<a href="${root}/member/findpassword.jsp">Forgot password?</a>
						</div>
					</form>
					<div class="row justify-content-center">
						<p class="text-black mt-5">Not a member yet?</p>
						<button type="button" class="btn btn-primary btn-lg btn-block"
							onclick="location.href='${root}/member?action=registry'">Register</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="/include/footer.jsp"%>