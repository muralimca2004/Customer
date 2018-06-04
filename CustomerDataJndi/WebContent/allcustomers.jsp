<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>MyBank App</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }

		table{
			border: 1px solid FFA500;
		}
    </style>
 
</head>
 
 
<body>
    <h2>List of Customers</h2>  
    <table>
        <tr>
            <td>First Name</td><td>Last Name</td><td>Gender</td><td>Passport No</td><td>Address Line1</td><td>Address Line2</td>
        </tr>        
        <c:forEach items="${customers}" var="customer">
            <tr>
            <td>${customer.cust_first_name}</td>
            <td>${customer.cust_last_name}</td>
            <td>${customer.cust_gender}</td>
            <td>${customer.cust_passport_no}</td>
			<td>${customer.cust_address_line1}</td>
			<td>${customer.cust_address_line2}</td>
            <td><a href="<c:url value='/edit-${customer.cust_passport_no}-customer' />">${customer.cust_passport_no}</a></td>
            <td><a href="<c:url value='/delete-${customer.cust_accnt_no}-customer' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='./register' />">Add New Customer</a>
</body>
</html>