<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<form name="register" action="register" method="post" accept-charset="utf-8">
  <ul>
    <li><label for="username">Name</label>
    <input type="text" name="username" placeholder="yourname" required></li>
    <li><label for="password">Password</label>
    <input type="password" name="password" placeholder="password" required></li>
    <li><label for="firstName">First name</label>
    <input type="text" name="firstName" placeholder="firstName"></li>
    <li><label for="lastName">Last name</label>
    <input type="text" name="lastName" placeholder="lastName"></li>
    <li><label for="phone">Phone</label>
    <input type="text" name="phone" placeholder="your phone"></li>
    <li><label for="email">e-mail</label>
    <input type="text" name="email" placeholder="your email" required></li>
    <li><label for="location">Location</label>
    <input type="text" name="location" placeholder="location"></li>
    <li>
    <input type="submit" value="Register"></li>
  </ul>
</form>
</body>
</html>