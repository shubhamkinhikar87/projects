

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file = "head.jsp" %>
</head>

<body id="page-top" class="index" ng-app="formApp" ng-controller="formController" >
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
				<li class="page-scroll"><a href="index.jsp">Login</a></li>
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







<!-- logic -->

	<section id="signup">
	<div class="container">
		
                        <div class="col-sm-3"></div>
                        	
                        <div class="col-sm-7">
                        	
                        	<div class="form-box">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Sign up now</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            
	                            
	                            <div class="form-bottom">
				                    <form role="form" action="SignUp" method="post" class="registration-form" name= "form1">
				                    	
				                    	  <div class="form-group">
				                        	<label class="sr-only" for="form-email">Email</label>
				                        	<input type="text" name="email" placeholder="Email..." class="form-email form-control" id="form-email"  ng-model="email" ng-pattern="/@atmecs.com$/i" required >
				                        	 <span ng-show="form1.email.$error.required">Email required!!</span>
								             <span ng-show="form1.email.$dirty && form1.email.$error.pattern">Email should @atmecs.com!!</span>
				                        
				                        </div>
				                        <div class="form-group">
				                    		<label class="sr-only" for="form-first-name">Username</label>
				                        	<input type="text" name="username" placeholder="username..." class="form-first-name form-control" id="username">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
				                        </div>
				                      
				                        
				                        <button type="submit" class="btn"  ng-disabled="form1.$invalid">Sign me up!</button>
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

