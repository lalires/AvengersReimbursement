<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1,initial-scale=1,user-scalable=1" />
	<title>Reimbursement - Login</title>

	
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/login.css">
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


   
    
<div id="login-button1">
  <img src="images/thor.png">
</div>
<div id="login-button2">
  <img src="images/america.png">
</div>
<div id="login-button3">
  <img src="images/hulk.png">
</div>

<div id="reimbursement" style="margin: 20px">
  <h1>Current Reimbursement</h1>
    </div> 
    
<div id="container" style="margin: 20px">
  <h1>Log In <img src="css/Avengers-logo.png"></h1>
  <span class="close-btn">
    <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
  </span>

  <form method="POST" action="Login">
    <input type="text" name="username" placeholder="User">
    <input type="password" name="password" placeholder="Password">
    <input type="submit"value="Login">
    </form>
       <button id="register" class="register-btn">Register</button>
    </div>    

<!-- Register Container -->
<div id="register-container" style="margin: 20px">
   <h1>Register</h1>
  <span class="close-btn">
    <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
  </span>

  <form method="POST" action="Register">
    <input type="text" name="username" placeholder="User Name">
    <input type="password" name="password" placeholder="Password" id="newPassword">
    <input type="password" name="password2" placeholder="Re-enter Password" id="confirmPassword" onChange="checkPasswordMatch();" >
    
    <input type="text" name="fname" placeholder="First Name">
    <input type="text" name="lname" placeholder="Last Name">
    <input type="text" name="email" placeholder="E-mail">
    <input type="submit" value="Register">
    <div class="registrationFormaAlert" id="divCheckPasswordMatch" style="text-align: center"></div>
</form>
</div>
<script>function checkPasswordMatch() {
    var password = $("#newPassword").val();
    var confirmPassword = $("#confirmPassword").val();

    if (password != confirmPassword)
        $("#divCheckPasswordMatch").html("Passwords do not match!");
    else
        $("#divCheckPasswordMatch").html("Passwords match!");

}</script>
<script src="//cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="bootstrap/js/login.js"></script>
</body>
</html>