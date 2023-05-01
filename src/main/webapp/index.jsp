<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /*
* Template Name: Tour
* Template Author: Untree.co
* Tempalte URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!DOCTYPE html>
<html lang="en">

<head>
	
	<%@ include file="/include/head.jsp" %>

	<title>Home</title>
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

	<div class="hero">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-7">
					<div class="intro-wrap">
					
						<h1 class="mb-5">
							<span>Let's </span>
							<span class="d-block font-weight-bolder">Enjoy Your Trip</span> In
							<span class="typed-words"></span>
						</h1>

						<div class="row">
							<div class="col-12">
								<!-- <form class="form">
                    <div class="row mb-2">
                      <div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-4">
                        <select name="" id="" class="form-control custom-select">
                          <option value="">Destination</option>
                          <option value="">Peru</option>
                          <option value="">Japan</option>
                          <option value="">Thailand</option>
                          <option value="">Brazil</option>
                          <option value="">United States</option>
                          <option value="">Israel</option>
                          <option value="">China</option>
                          <option value="">Russia</option>
                        </select>
                      </div>
                      <div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-5">
                        <input type="text" class="form-control" name="daterange" />
                      </div>
                      <div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-3">
                        <input type="text" class="form-control" placeholder="# of People" />
                      </div>
                    </div>
                    <div class="row align-items-center">
                      <div class="col-sm-12 col-md-6 mb-3 mb-lg-0 col-lg-4">
                        <input type="submit" class="btn btn-primary btn-block" value="Search" />
                      </div>
                      <div class="col-lg-8">
                        <label class="control control--checkbox mt-3">
                          <span class="caption">Save this search</span>
                          <input type="checkbox" checked="checked" />
                          <div class="control__indicator"></div>
                        </label>
                      </div>
                    </div>
                  </form> -->
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-5">
					<div class="slides">
						<img src="images/hero-slider-1.jpg" alt="Image" class="img-fluid active" />
						<img src="images/hero-slider-2.jpg" alt="Image" class="img-fluid" />
						<img src="images/hero-slider-3.jpg" alt="Image" class="img-fluid" />
						<img src="images/hero-slider-4.jpg" alt="Image" class="img-fluid" />
						<img src="images/hero-slider-5.jpg" alt="Image" class="img-fluid" />
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="untree_co-section">
		<div class="container">
			<div class="row text-center justify-content-center mb-5">
				<div class="col-lg-7">
					<h2 class="section-title text-center">Popular Destination</h2>
				</div>
			</div>

			<div class="owl-carousel owl-3-slider">
				<div class="item">
					<a class="media-thumb" href="images/hero-slider-1.jpg" data-fancybox="gallery">
						<div class="media-text">
							<h3>Pragser Wildsee</h3>
							<span class="location">Italy</span>
						</div>
						<img src="images/hero-slider-1.jpg" alt="Image" class="img-fluid" />
					</a>
				</div>

				<div class="item">
					<a class="media-thumb" href="images/hero-slider-2.jpg" data-fancybox="gallery">
						<div class="media-text">
							<h3>Oia</h3>
							<span class="location">Greece</span>
						</div>
						<img src="images/hero-slider-2.jpg" alt="Image" class="img-fluid" />
					</a>
				</div>

				<div class="item">
					<a class="media-thumb" href="images/hero-slider-3.jpg" data-fancybox="gallery">
						<div class="media-text">
							<h3>Perhentian Islands</h3>
							<span class="location">Malaysia</span>
						</div>
						<img src="images/hero-slider-3.jpg" alt="Image" class="img-fluid" />
					</a>
				</div>

				<div class="item">
					<a class="media-thumb" href="images/hero-slider-4.jpg" data-fancybox="gallery">
						<div class="media-text">
							<h3>Rialto Bridge</h3>
							<span class="location">Italy</span>
						</div>
						<img src="images/hero-slider-4.jpg" alt="Image" class="img-fluid" />
					</a>
				</div>

				<div class="item">
					<a class="media-thumb" href="images/hero-slider-5.jpg" data-fancybox="gallery">
						<div class="media-text">
							<h3>San Francisco, United States</h3>
							<span class="location">United States</span>
						</div>
						<img src="images/hero-slider-5.jpg" alt="Image" class="img-fluid" />
					</a>
				</div>

				<div class="item">
					<a class="media-thumb" href="images/hero-slider-1.jpg" data-fancybox="gallery">
						<div class="media-text">
							<h3>Lake Thun</h3>
							<span class="location">Switzerland</span>
						</div>
						<img src="images/hero-slider-2.jpg" alt="Image" class="img-fluid" />
					</a>
				</div>
			</div>
		</div>
	</div>

	
	<script>
		(function () {
			var slides = $(".slides"),
				images = slides.find("img");

			images.each(function (i) {
				$(this).attr("data-id", i + 1);
			});

			var typed = new Typed(".typed-words", {
				strings: [" 순천.", " 서울.", " 경주.", " 부산.", " 여수.", " 제주.", " 속초."],
				typeSpeed: 80,
				backSpeed: 80,
				backDelay: 4000,
				startDelay: 1000,
				loop: true,
				showCursor: true,
				preStringTyped: (arrayPos, self) => {
					arrayPos++;
					console.log(arrayPos);
					$(".slides img").removeClass("active");
					$('.slides img[data-id="' + arrayPos + '"]').addClass("active");
				},
			});
		});
	</script>


<%@ include file="/include/footer.jsp" %>
