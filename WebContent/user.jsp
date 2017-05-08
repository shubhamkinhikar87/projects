
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>




<html>

<head>
<%@ include file = "head.jsp" %>

<meta charset="UTF-8">
<title>Responstable 2.0: a responsive table solution</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="table css/style.css">

</head>

<body id="page-top" class="index">
	<div id="skipnav">
		<a href="#maincontent">Skip to main content</a>
	</div>

 <!-- Navigation -->
	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#page-top">ATMECS</a>
            </div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a></li>
				<li ><a href="index.jsp">Home</a></li>
				<li class="page-scroll"><a href="logoutHandler">Log out</a></li>
				<li ><a href="signup.jsp">Sign Up</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>


	<!-- /.container-fluid --> </nav>

	
	
	<!-- Header -->
	<header>
	<div class="container" id="maincontent" tabindex="-1">
		</div>
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
		
                       <h1><span><center>Upcoming tech-talk</center></span></h1>
                        <h3><center>${sessionScope.status}</center></h3>
                       

	<table class="responstable">

		<tr>
		<th>Tech-Talk Id</th>
			<th>Date</th>
			<th ><span>Title</span></th>
			<th>Description</th>
			<th>Presenter</th>
			<th></th>

		</tr>

	
		<c:forEach items="${sessionScope.techTonicData}" var="techtalk">
			<tr>
			<tr><td><c:out value="${techtalk.id}" /></td>
				<td><c:out value="${techtalk.presentationDate}" /></td>
				<td><c:out value="${techtalk.title}" /></td>
				<td><c:out value="${techtalk.description}" /></td>
				<td><c:out value="${techtalk.presenterName}" /></td>
				<td><a href="registerHandler?id=${techtalk.id}"><button>Register</button></a></td> 

			</tr>
		</c:forEach>

  </table>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>

	</section>




<%@ include file = "footer.jsp" %>






</body>
</html>



















