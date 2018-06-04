<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>		
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/navstyle.css"></link>
 	<style type="text/css">                       
        
        .block2{
        	display: inline-block;
        	border: 1px solid blue;
        }
                 
        #body {
        	#background-color: #33beff;        	
		}
		
    </style>
<meta charset="ISO-8859-1"></meta>
<title>Register New Customer</title>
</head>
<body id="body">
<ul>
        <li><a href="/">Home</a></li>
        <li><a href="#">Accounts</a></li>
        <li>
            <a href="#">Funds Transfer &#9662;</a>            
            <ul class="dropdown">
                <li><a href="#">Laptops</a></li>
                <li><a href="#">Monitors</a></li>            
                <li><a href="#">Printers</a></li>
            </ul>
        </li>
        <li><a href="#">Deposits</a></li>
        <li><a href="#">Foreign Exchange</a></li>
    </ul>
<hr></hr>
<div id="outerdiv">
	<div class="usrRegFormHeader">Sign up to create your account</div>
	<div class="usrRegForm">
	<form:form action="/customerregister" method="post" modelAttribute="customer">
		<form:errors></form:errors>
		<form:label for="title" path="cust_gender" class="required">Title:</form:label>
		
		<form:input type="radio" path="cust_gender" class="text_" value="Mr"></form:input>
		<form:label for="male" path="cust_gender" class="text_">Mr</form:label>
  		<form:input type="radio" path="cust_gender" class="text_" value="Mrs"></form:input>
  		<form:label for="Mrs" path="cust_gender" class="text_">Mrs</form:label>
  		<form:input type="radio" path="cust_gender" class="text_" value="Miss"></form:input>
		<form:label for="Miss" path="cust_gender" class="text_">Miss</form:label><br/>
  		  		
		<form:label for="ForeName" path="cust_first_name" class="required">ForeName:</form:label>
    	<form:input type="text" path="cust_first_name" class="text_"></form:input><br/>
    	
    	<form:label for="LastName" path="cust_last_name" class="required">LastName:</form:label>
    	<form:input type="text" path="cust_last_name" class="text_"></form:input><br/>
    	    
    	<form:label for="fName" path="fname" class="required">Father/Husband'sName:</form:label>
    	<form:input type="text" path="fname" class="text_" value=""></form:input><br/>
		
		<form:label for="fullname" path="fname" class="required">Full Name:</form:label>
    	<form:input type="text" path="fullname" class="text_" value=""></form:input><br/>
    	
    	<form:label for="email" path="cust_email" class="required">Email:</form:label>
    	<form:input type="text" path="cust_email" class="text_" value=""></form:input><br/>
    	
    	<form:label for="cust_address_line1" path="cust_address_line1" class="required">AddressLine1:</form:label>
    	<form:input type="text" path="cust_address_line1" class="text_" value=""></form:input><br/>
    	
    	<form:label for="cust_passport_no" path="cust_passport_no" class="required">PassportNo:</form:label>
    	<form:input type="text" path="cust_passport_no" class="text_" value=""></form:input><br/>
    	
    	<form:label for="cust_post_code" path="cust_post_code" class="required">PostCode:</form:label>
    	<form:input type="text" path="cust_post_code" class="text_" value=""></form:input><br/>
    	
    	<form:label for="cust_phone_no" path="cust_phone_no" class="required">PhoneNo:</form:label>
    	<form:input type="text" path="cust_phone_no" class="text_" value=""></form:input><br/>
    	
    	<form:label for="cust_address_town" path="cust_address_town" class="required">AddressTown:</form:label>
    	<form:input type="text" path="cust_address_town" class="text_" value=""></form:input><br/>
    	
    	<form:label for="cust_address_county" path="cust_address_county" class="required">AddressCounty:</form:label>
    	<form:input type="text" path="cust_address_county" class="text_" value=""></form:input><br/>
    	
		<b>Address:</b><br/>
		<form:label for="street" path="street" class="required">Street:</form:label>
    	<form:input type="text" path="street" id="street"class="text_" value=""> </form:input><br/>
    	<form:label for="state" path="state" class="required">State:</form:label>
		<form:input type="text" path="state" class="text_" value="" size="2"></form:input><br/>
		<form:label for="pincode" path="pincode" class="required">Pin code:</form:label>
		<form:input type="text" path="pincode" class="text_" value="" size="6"></form:input> <br/>
		
    	<form:button path="Submit" type="submit" class="btn-submit" value="submit"></form:button>
	</form:form>
	</div>
	<!-- div class="block2">
		<section><a href="#">Need help?</a></section><br/>
		<section><a href="#">Useful Links</a></section><br/>
		<section><a href="#">Frequently asked questions</a></section><br/>	
	</div-->
</div>
<hr/>
<div class="footerdiv">
<section><a href="#">About Us</a></section><section><a href="#">Contact Us</a></section><section><a href="#">CopyWright</a></section>

</div>

</body>
</html>