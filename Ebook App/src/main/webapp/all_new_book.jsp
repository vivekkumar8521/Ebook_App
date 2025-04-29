<%@ page import="java.util.List"%>
<%@ page import="com.DAO.BookDAOImpl"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page import="com.entity.BookDtls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Recent Book</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #ECECEA;
}
</style>
</head>
<body>

	<%
	com.entity.User u = (com.entity.User) session.getAttribute("userobj");
	%>

	<%@include file="all_component/navbar.jsp"%>

   <%-- Show Add Cart Messages Here--%> 
	<%
	String addCart = (String) session.getAttribute("addCart");
	String failed = (String) session.getAttribute("failed");

	if (addCart != null) {
	%>
	<div class="alert alert-success" role="alert"><%=addCart%></div>
	<%
	session.removeAttribute("addCart");
	}

	if (failed != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=failed%></div>
	<%
	session.removeAttribute("failed");
	}
	%>

	<div class="container">
		<div class="row">
			<%
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			List<BookDtls> list = dao.getNewBook();

			for (BookDtls b : list) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">

						<img alt="" src="book/<%=b.getPhotoName()%>"
							style="width: 100px; height: 150px;" class="img-thumblin">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories:<%=b.getBookCategory()%>
						</p>
						<div class="row">

							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=b.getBookId()%>&&uid=<%=u.getId()%>"
								class="btn btn-danger btn-sm ml-1"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>
							<%
							}
							%>

							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1 ">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1">₹<%=b.getPrice()%></a>

						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>
		</div>
	</div>

</body>
</html>