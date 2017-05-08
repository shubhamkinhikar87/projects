<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file = "head.jsp" %>

</head>

<body id="page-top" class="index" ng-app="formApp"
	ng-controller="formController">
	<div id="skipnav">
		<a href="#maincontent">Skip to main content</a>
	</div>






	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="#page-top">ATMECS</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a></li>
				<li><a href="index.jsp">Home</a></li>
				<li class="page-scroll"><a href="#login">Login</a></li>
				<li><a href="signup.jsp">Sign Up</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>


	<!-- /.container-fluid --> </nav>



	<!-- Header -->
	<header>
	<div class="container" id="maincontent" tabindex="-1">
		<div class="row">
			<div class="col-lg-12">
				<img class="img-responsive" src="img/profile.png" alt="">
				<div class="intro-text">
					<h1 class="name">tech-talk</h1>
					<hr class="star-light">
					<span class="skills">Aspire - Think - Manage - Engage -
						Create - Succeed</span>
				</div>
				<div class="w3-content w3-section" style="width: 100%">
					<center>
						<br>
						<br> <img class="mySlides" src="img/aspire.jpg"
							style="width: 100%"> <img class="mySlides"
							src="img/think.jpg" style="width: 100%"> <img
							class="mySlides" src="img/manage.jpg" style="width: 100%">
						<img class="mySlides" src="img/engage.jpg" style="width: 100%">
						<img class="mySlides" src="img/create.jpg" style="width: 100%">
						<img class="mySlides" src="img/succeed.jpg" style="width: 100%">
					</center>
				</div>

				<script>
					var myIndex = 0;
					carousel();

					function carousel() {
						var i;
						var x = document.getElementsByClassName("mySlides");
						for (i = 0; i < x.length; i++) {
							x[i].style.display = "none";
						}
						myIndex++;
						if (myIndex > x.length) {
							myIndex = 1
						}
						x[myIndex - 1].style.display = "block";
						setTimeout(carousel, 2000); // Change image every 2 seconds
					}
				</script>

			</div>
		</div>
	</div>
	</header>







	<!-- logic -->

	<section id="login">
	<div class="container">
		<h3>
			<center>
				<font color="red">${sessionScope.loginStatus}</font>
			</center>
		</h3>
		<div class="col-sm-3"></div>
		<div class="col-sm-6">

			<div class="form-box">
				<div class="form-top">
					<div class="form-top-left">
						<h3>Login to our site</h3>
						<p>Enter username and password to log on:</p>
					</div>
					<div class="form-top-right">
						<i class="fa fa-lock"></i>
					</div>
				</div>
				<div class="form-bottom">
					<form action="validateUsersAndAdmin" method="post" role="form"
						class="login-form" name="form1">
						<div class="form-group">
							<label class="sr-only" for="form-email">Email</label> <input
								type="text" name="email" placeholder="Email..."
								class="form-email form-control" id="email" ng-model="email"
								ng-pattern="/@atmecs.com$/i" required> <span
								ng-show="form1.email.$error.required">Email required!!</span> <span
								ng-show="form1.email.$dirty && form1.email.$error.pattern">Email
								should @atmecs.com!!</span>
						</div>

						<!-- 
						<input type="text" name="user" placeholder="User name" ng-model="email" ng-pattern="/@atmecs.com$/i" required></td></tr>
			<tr><td></td></tr>
			<tr><td></td></tr> -->

						<div class="form-group">
							<label class="sr-only" for="form-password">Password</label> <input
								type="password" name="password" placeholder="Password..."
								class="form-password form-control" id="password">
						</div>
						<div class="checkbox">
							<label><input name="checkAdmin" id="checkAdmin"
								type="checkbox" value="">Login as a admin </label>

						</div>
						<button type="submit" class="btn" ng-disabled="form1.$invalid">Sign
							in!</button>
					</form>
				</div>
			</div>
		</div>
	</section>

<%@ include file = "footer.jsp" %>

</body>

</html>


<script type="text/javascript" src="angular.min.js"></script>
<script>
var app = angular.module("formApp",[]);
app.controller("formController",function(){});
</script>
