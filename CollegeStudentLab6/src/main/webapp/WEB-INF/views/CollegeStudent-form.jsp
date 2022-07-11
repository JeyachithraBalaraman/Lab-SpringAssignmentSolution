<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save College Student</title>
</head>

<body>

	<div class="container">

		<h3>College Student Directory</h3>
		<hr>

		<p class="h4 mb-4">Enter College Student</p>

		<form action="/CollegeStudentLab6/collegeStudents/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${CollegeStudent.id}" />

			<div class="form-inline">
				<input type="text" name="firstname" value="${CollegeStudent.firstname}"
					class="form-control mb-4 col-4" placeholder="firstname">



			</div>

			<div class="form-inline">

				<input type="text" name="lastname" value="${CollegeStudent.lastname}"
					class="form-control mb-4 col-4" placeholder="lastname">



			</div>

			<div class="form-inline">

				<input type="text" name="course" value="${CollegeStudent.course}"
					class="form-control mb-4 col-4" placeholder="course">



			</div>
			<div class="form-inline">

				<input type="text" name="country" value="${CollegeStudent.country}"
					class="form-control mb-4 col-4" placeholder="country">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CollegeStudentLab6/collegeStudents/list">Back to College Students List</a>

	</div>
</body>

</html>










