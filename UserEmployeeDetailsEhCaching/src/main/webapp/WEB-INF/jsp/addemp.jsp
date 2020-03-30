<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>it is add emp</h2>
	<form action="/emp">
		<pre>
  First name:<br>
  
  <input type="text" name="firstname">
  <br>
  Last name:<br>
  <input type="text" name="lastname">
 <br>
  Email:  
  <input type="text" name="email">
  <br>
  Dob:
  <input type="Date" name="dob">
  <br>
  Vehicle:
<input type="checkbox" name="vehicle" value="Bike"> I have a bike<br>
<input type="checkbox" name="vehicle" value="Car"> I have a car<br>
<input type="checkbox" name="vehicle" value="Boat" checked> I have a boat<br>
  
  <br>
  <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other 
  <input type="submit" value="AddEmployee">

</pre>

	</form>

</body>
</html>