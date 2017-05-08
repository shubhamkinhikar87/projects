

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file = "head.jsp" %>

</head>

<body id="page-top" class="index">
	<div id="skipnav">
		<a href="#maincontent">Skip to main content</a>
	</div>

<script src="http://cdn.jsdelivr.net/webshim/1.12.4/extras/modernizr-custom.js"></script>
	<script src="http://cdn.jsdelivr.net/webshim/1.12.4/polyfiller.js"></script>
	




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
				<li class="page-scroll"><a href="logoutHandler">Log out</a></li>
				<li><a href="signup.jsp">Sign Up</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>


	<!-- /.container-fluid --> </nav>



	<!-- Header -->
	<header>
	<div class="container" id="maincontent" tabindex="-1"></div>
	</header>




<%

//session handling
HttpSession hs=request.getSession(); 
String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
if(userName == null) 
	response.sendRedirect("session.jsp"); 
	

%>


	<!-- logic -->

	<section id="signup">
	<div class="container">

		<div class="col-sm-3"></div>

		<div class="col-sm-6">

			<div class="form-box">
				<div class="form-top">
					<div class="form-top-left">
						<h3>Add Tech-Talk</h3>
						<p>Fill in the form below to add tech-talk:</p>
					</div>
					<div class="form-top-right">
						<i class="fa fa-pencil"></i>
					</div>
				</div>

				<div class="form-bottom">
					<form role="form" action="addTechTalkController" method="post"
						class="registration-form">

						<div class="form-group">
							<label>Presentation Date</label> <label class="sr-only"
								for="form-email">Presentation Date</label>
								 <input type="date" name="presentationDate" placeholder="Presentation Date..."
								class="form-email form-control" required>
							<div class="form-group">

								<label>Title</label> <label class="sr-only"
									for="form-first-name">title</label> <input type="text"
									name="title" placeholder="Title..."
									class="form-first-name form-control" required>
							</div>
							<div class="form-group">
								<label>Description </label> <label class="sr-only"
									for="form-password">description</label> <input type="textarea"
									rows="4" cols="50" name="description"
									placeholder="Description..." class="form-password form-control" required>
							</div>
							<div class="form-group">

								<label>Presenter Name </label> 
								<label class="sr-only" for="form-password">presenterName</label> 
								<input type="text" name="presenterName" placeholder="Presenter Name..." class="form-password form-control" required>
							</div>


							<button type="submit" class="btn">Add!</button>
					</form>
				</div>
			</div>
	</section>

<%@ include file = "footer.jsp" %>

</body>

</html>
