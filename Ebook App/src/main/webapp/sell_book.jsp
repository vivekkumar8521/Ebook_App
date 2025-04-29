<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sell Book</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-4 mt-3">
				<div class="card">
					<div class="card-body">

						<h5 class="text-center text-primary p-1">Sell Old Book</h5>
						<form action="add_old_book" method="post"
							enctype="multipart/form-data">
							<div class="form-group">

								<%
								String succMsg = (String) session.getAttribute("succMsg");
								String errorMsg = (String) session.getAttribute("errorMsg");

								if (succMsg != null) {
								%>
								<div class="alert alert-success" role="alert"><%=succMsg%></div>
								<%
								session.removeAttribute("succMsg");
								}

								if (errorMsg != null) {
								%>
								<div class="alert alert-success" role="alert"><%=errorMsg%></div>
								<%
								session.removeAttribute("errorMsg");
								}
								%>


								<input type="hidden" value="${userobj.email}" name="user">

								<label for="exampleInputEmail1">Book Name*</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									name="author" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">Price*</label> <input
									name="price" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>


							<div class="form-group">
								<label for="exampleFormConrolFile1">Upload Photo</label> <input
									name="bimg" type="file" class="form-control-file"
									id="exampleFormConrolFile1">
							</div>

							<button type="Submit" class=" btn btn-primary">Sell</button>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>