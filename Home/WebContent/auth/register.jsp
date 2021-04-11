<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<base href="/Home/"/>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<div class="container-fluid">
			<a class="navbar-brand" href="#">PT15301-UD</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row">
		<div class="col-12">
			<div class="col-6 offset-3">
				<form method="post" action="RegisterServlet">
					<div class="mt-3">
						<label for="name" class="form-label">Name</label> <input
							type="text" value="${user.name }" class="form-control" id="name" name="name" />
					</div>
					<div class="mt-3">
						<label for="number" class="form-label">Number</label> <input
							type="number" value="${user.number }" class="form-control" id="number" name="number" />
					</div>
					<div class="mt-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" value="${user.email}" class="form-control" id="email" name="email" />
					</div>
					<div class="mt-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" value="${user.password}" class="form-control" id="password"
							name="password" />
					</div>
					<div class="mt-3">
						<label for="gender" class="form-label">Gender</label> <select
							class="form-select" name="gender">
							<option ${user.gender ==0? 'selected':''} value="0" >Male</option>
							<option ${user.gender==1 ? 'selected':''}  value="1">Female</option>
						</select>
					</div>
					<div class="mt-3">
					<button class="btn btn-primary" formaction="RegisterServlet/create">Create</button>
    				<button class="btn btn-warning" formaction="RegisterServlet/update?userId=${user.id }">Update</button>
    				<button class="btn btn-danger" formaction="RegisterServlet/delete?userId=${user.id }">Delete</button>
    				<button class="btn btn-info" formaction="RegisterServlet/reset">Reset</button>
					</div>
				</form>

				<div class="row mt-4">
					<div class="col">
						<table class="table table-stripe">
							<tr>
								<td>User ID</td>
								<td>Name</td>
								<td>Number</td>
								<td>Email</td>
								<td>Password</td>
								<td>Gender</td>
						
								<td>&nbsp;</td>
							</tr>
							<c:forEach var="item" items="${listAll }">
								<tr>
									<td>${item.id }</td>
									<td>${item.name }</td>
									<td>${item.number }</td>
									<td>${item.email }</td>
									<td>${item.password }</td>
									<td>${item.gender ==0?"Nam":"Nữ"}</td>
									<td><a href="RegisterServlet/edit?userId=${item.id }">Edit</a>
									 <a href="RegisterServlet/delete?userId=${item.id }">Delete</a></td>
								</tr>
							</c:forEach>


						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>