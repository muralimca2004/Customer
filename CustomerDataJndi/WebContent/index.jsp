<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="ISO-8859-1"></meta>
<title>CustomerData</title>

<link href="<spring:url value='/resources/css/navstyle.css'/>" type="text/css" rel="stylesheet"> </link>
<!-- link rel="stylesheet" type="text/css" href="resources/css/navstyle.css"></link-->

</head>
<body>

<ul>
        <li><a href="/">Home</a></li>
        <li><a href="#">Accounts</a></li>
        <li>
            <a href="#">Funds Transfer &#9662;</a>            
            <ul class="dropdown">
                <li><a href="#">With in the Bank</a></li>
                <li><a href="#">Partner Bank</a></li>            
                <li><a href="#">ThirdParty</a></li>
            </ul>
        </li>
        <li><a href="#">Deposits</a></li>
        <li><a href="#">Foreign Exchange</a></li>
    </ul>
<hr></hr>
<div class="headerdiv">Welcome to <a href="/mybank">MyBank</a></div>

<!--  a href="./login.html" class="button1">Existing User</a-->
<!--  a href="./register" class="button2">NewUser</a-->

<spring:url value="/customer/login" var="existingUserLink" />
<a href="${existingUserLink}" class="button1">Existing User</a>

<spring:url value="/register" var="springLink" />
<a href='<spring:url value="/register"/>' class="button2"> NewUser</a>


<hr></hr>
<div class="footerdiv">
<section><a href="#">About Us</a></section><section><a href="#">Contact Us</a></section><section><a href="#">CopyWright</a></section>

</div>
<!-- div class="navdiv">
 <ul>
  <li><a href="default.html">Home</a></li>
  <li><a href="news.html">News</a></li>
  <li><a href="contact.html">Contact</a></li>
  <li><a href="about.html">About</a></li>
</ul> 
</div -->
</body>
</html>