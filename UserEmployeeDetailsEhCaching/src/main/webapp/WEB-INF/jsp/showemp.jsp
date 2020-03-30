<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

	<h2>this is show emp</h2>
	<form>
	

		<table id="customers" style="width: 100%">
			<tr>
				<th>Emloyee id</th>
				<th>Employee Firstname</th>
				<th>Employee Lastname</th>
				<th>Employee Email</th>
				<th>Employee gender</th>
				<th>Employee dob</th>
				<th>Employee vehicle</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>Upload</th>
<a href="/addE">addEmployee</a>
			</tr>

			<c:forEach var="list" items="${lists}">
			
				<tr>
					<td>${list.id}</td>
					<td>${list.firstname}</td>
					<td>${list.lastname}</td>
					<td>${list.email}</td>
					<td>${list.gender}</td>
					<td>${list.dob}</td>
					<td>${list.vehicle}</td>
					
					<td><a href="/edit?id=${list.id}">Edit</a></td>
					<td><a href="/delete/${list.id}">Delete</a></td>
					<td><a href="/uploadimage/${list.id}">UploadImage</a></td>
					
				</tr>
			</c:forEach>

		</table>

	</form>
</body>



</html>