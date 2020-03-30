<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<form action="/update">
 <pre>
  
  <input type="hidden" name="id" value=${lists.id}>
   First name:<br>
  <input type="text" name="firstname" value =${lists.firstname}>
  <br>
  Last name:<br>
  <input type="text" name="lastname" value=${lists.lastname}>
 <br>
  Email:
  <input type="text" name="email" value=${lists.email}>
  <br>
  <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other 
  <input type="submit" value="EditEmployee">

</pre>

</form>
</body>
</html>