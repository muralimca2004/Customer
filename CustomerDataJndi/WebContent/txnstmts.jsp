<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="ISO-8859-1"/>
<title>CustomerData</title>
<link rel="stylesheet" type="text/css" href="staticresources/css/navstyle.css"> </link>

</head>
<body>
<ul>
        <li><a href="#">Home</a></li>
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
<hr/>
<div class="headerdiv">Welcome to <a href="/mybank">MyBank</a></div>

<p class="headerdiv">${txnList}</p>

<table>
  <c:forEach items="${txnList}" var="txn">
    <tr>
      <td><c:out value="${txn}" /></td>
    </tr>
  </c:forEach>
</table>

<hr/>
<div class="footerdiv">
<section><a href="#">About Us</a></section><section><a href="#">Contact Us</a></section><section><a href="#">CopyWright</a></section>

</div>

</body>
</html>
</jsp:root>