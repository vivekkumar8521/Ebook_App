<%@ page import="com.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting Page</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
a{
text-decoration: none;
color: black;
} 
a:hover{
text-decoration: none;
}


</style>
</head>
<body style="background-color: #f0f1f2">

<%
User userobj = (User) session.getAttribute("userobj");
if (userobj == null) {
    response.sendRedirect("login.jsp");
}
%>

	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<h3 class="text-center">Hello,${userobj.name}</h3> 
		<div class="row p-5">
			<div class="col-md-6">
				<a href="sell_book.jsp">
					<div class="card">
						<div class="card-body text-center">
						<div class="text-primary">
						<i class="fa-solid fa-book-open fa-3x"></i>
						</div>
						<h3>Sell Old Book</h3>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-6">
				<a href="edit_profile.jsp">
					<div class="card">
						<div class="card-body text-center">
						<div class="text-primary">
						<i class="fas fa-edit fa-3x"></i>
						</div>
						<h4>Login & Security (Edit Profile)</h4>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4 mt-4">
				<a href="user_address.jsp">
					<div class="card">
						<div class="card-body text-center">
						<div class="text-warning">
						<i class="fa-solid fa-location-dot fa-3x"></i>
						</div>
						<h4>Your Address</h4>
						<p>Edit Address</p>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4 mt-4">
				<a href="order.jsp">
					<div class="card">
						<div class="card-body text-center">
						<div class="text-danger">
						<i class="fa-solid fa-box-open fa-3x"></i>
						</div>
						<h4>My Order</h4>
						<p>Track your Order</p>
						</div>
					</div>
				</a>
			</div>
			
			<div class="col-md-4 mt-4">
				<a href="helpline.jsp">
					<div class="card">
						<div class="card-body text-center">
						<div class="text-primary">
						<i class="fas fa-user-circle fa-3x"></i>
						</div>
						<h4>Help Center</h4>
						<p>24*7 Service</p>
						</div>
					</div>
				</a>
			</div>
			
		</div>
	</div>

</body>
</html>