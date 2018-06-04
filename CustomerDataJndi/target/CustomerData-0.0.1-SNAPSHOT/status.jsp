<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="ISO-8859-1"></meta>
<title>CustomerData</title>

<link rel="stylesheet" type="text/css" href="resources/css/navstyle.css"></link>
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
<h1><spring:message code="page.header" /> </h1><br></br><br></br><br></br>
<p class="headerdiv">${status}</p>

<hr></hr>
<div class="footerdiv">
<section><a href="#">About Us</a></section><section><a href="#">Contact Us</a></section><section><a href="#">CopyWright</a></section>

</div>

</body>
</html>