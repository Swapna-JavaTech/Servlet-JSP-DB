<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Student</title>
</head>
<body>
<h1>Student Registration</h1>
 <form action="${pageContext.request.contextPath}/SaveDataInDB" method="post">
 	Enter StudentId : <input type = "text" name="sid" /><br />
 	Enter StudentName : <input type = "text" name="sname" /><br />
 	Enter StudentAge : <input type = "text" name="sage" /><br />
 	<input type="submit" value="Register" />
</form>
</body>
</html>