<%@ page import="javax.servlet.http.*,javax.servlet.*, javax.servlet.http.HttpSession"%>
<%!static int i=1;%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>NewCustomerData</title>
<link rel="stylesheet" type="text/css" href="staticresources/css/navstyle.css"></link>
<style>

 .logout {
    		background-color: white;
    		border: 2px solid #008CBA; /* Blue */
    		color: black;
    		padding: 10px 24px;
	   		text-align: center;
		    text-decoration: none;
    		display: inline-block;
    		font-size: 16px;
    		border-radius: 2px;
    		transition-duration: 0.4s;    		
		}
	
		.logout:hover {
   	 		background-color: #008CBA; /* Blue */;
     		color: white;
		}
		</style>
</head>
<body>
<hr></hr>
<%
    if ((session.getAttribute("foreName") == null) || (session.getAttribute("lastName") == "")) {
    	
%>
Sorry.. your session is invalidated.Please try again.
<a href="index.html">Enter your Details</a>
<%} else {	
%>

Welcome <b><%=session.getAttribute("foreName")%></b>
Here is your details: 

 <div align="center">
  <table style="border: 1px solid Orange; background-color: Orange; color: blue; width: auto;">
	<caption>Customer Details</caption>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("foreName") %></td></tr>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("lastName") %></td></tr>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("email") %></td></tr>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("fname") %></td></tr>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("street") %></td></tr>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("state") %></td></tr>
	<tr id="tr"><td><%=i++%></td><td><%=session.getAttribute("pincode") %></td></tr>
</table>
</div>

<a href=./index.html class="logout">LogOut</a>
<%
    session.invalidate();
}
%>

<hr></hr>
<div class="footerdiv">
	<section><a href="#">About Us</a></section><section><a href="#">Contact Us</a></section><section><a href="#">CopyWright</a></section>
</div>
<!-- div class="navdiv">
 <ul>
  <li><a href="default.html">Home</a></li>
  <li><a href="news.html">News</a></li>
  <li><a href="contact.asphtml">Contact</a></li>
  <li><a href="about.html">About</a></li>
</ul> 
</div -->
</body>
</html>