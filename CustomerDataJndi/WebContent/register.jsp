<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>		
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="resources/css/navstyle.css"></link>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/postrequest.js"></script>
 	<style type="text/css">                       
        
        .block2{
        	display: inline-block;
        	border: 1px solid blue;
        }
                 
        #body {
        	#background-color: #33beff;        	
		}
		.error {
    		color: #ff0000;
		}
 
		.errorblock {
	    	padding:10px;
	    	margin: 15px;
	    	color: #000;
	    	background-color: #ffEEE0;
	    	border: 3px solid #ff0000;
		}
		
    </style>
<meta charset="ISO-8859-1"></meta>
<title>Register New Customer</title>
</head>
<body id="body">
<ul>
        <li><a href="/mybank">Home</a></li>
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
	<form:form action="./customer/register" method="post" modelAttribute="customerForm" name="customerForm">
		<form:errors path="*" cssClass="errorblock" element="div" />
		
		<form:label for="title" path="cust_gender" cssClass="required">Title<font color="red">*</font>:</form:label>
		<form:radiobutton path="cust_gender" value="M" label="Male" id="cust_gender" name="cust_gender"/>
        <form:radiobutton path="cust_gender" value="F" label="Female" id="cust_gender" name="cust_gender"/>
        <form:radiobutton path="cust_gender" value="O" label="Not Known" id="cust_gender" name="cust_gender"/>
		<form:errors path="cust_gender" cssClass="error"/><br></br>
		
		<form:label for="ForeName" path="cust_first_name" cssClass="required">ForeName<font color="red">*</font>:</form:label>
    	<form:input path="cust_first_name" cssClass="text_" id="cust_first_name" name="cust_first_name"></form:input>
    	<form:errors path="cust_first_name" cssClass="error"/><br></br>
    	
    	<form:label for="LastName" path="cust_last_name" cssClass="required">LastName<font color="red">*</font>:</form:label>
    	<form:input path="cust_last_name" cssClass="text_" id="cust_last_name" name="cust_lasst_name"></form:input>
    	<form:errors path="cust_last_name" cssClass="error"/><br></br>
    	    
    	<form:label for="email" type="email" path="cust_email" cssClass="required">Email<font color="red">*</font>:</form:label>
    	<form:input path="cust_email" cssClass="text_" name="cust_email"></form:input>
    	<form:errors path="cust_email" cssClass="error"/><br></br>
    	
    	<form:label for="dateofbirth" type="date" path="cust_dateofbirth" cssClass="required">Date Of Birth<font color="red">*</font>:</form:label>
    	<form:input path="cust_dateofbirth" cssClass="text_"></form:input>
    	<form:errors path="cust_dateofbirth" cssClass="error"/><br></br>
    	
    	<form:label for="cust_address_line1" path="cust_address_line1" cssClass="required">AddressLine1<font color="red">*</font>:</form:label>
    	<form:input path="cust_address_line1" cssClass="text_"></form:input>
    	<form:errors path="cust_address_line1" cssClass="error"/><br></br>
    	
    	<form:label for="cust_address_line2" path="cust_address_line2" cssClass="required">AddressLine2<font color="red">*</font>:</form:label>
    	<form:input path="cust_address_line2" cssClass="text_"></form:input>
    	<form:errors path="cust_address_line2" cssClass="error"/><br></br>
    	
    	<form:label for="cust_address_town" path="cust_address_town" cssClass="required">AddressTown<font color="red">*</font>:</form:label>
    	<form:input path="cust_address_town" cssClass="text_"></form:input>
    	<form:errors path="cust_address_town" cssClass="error"/><br></br>
    	
    	<form:label for="cust_address_county" path="cust_address_county" cssClass="required">AddressCounty<font color="red">*</font>:</form:label>
    	<form:input path="cust_address_county" cssClass="text_"></form:input>
    	<form:errors path="cust_address_county" cssClass="error"/><br></br>
    	
    	<form:label for="cust_passport_no" path="cust_passport_no" cssClass="required">PassportNo<font color="red">*</font>:</form:label>
    	<form:input path="cust_passport_no" cssClass="text_"></form:input>
    	<form:errors path="cust_passport_no" cssClass="error"/><br></br>
    	
    	<form:label for="cust_post_code" path="cust_post_code" cssClass="required">PostCode<font color="red">*</font>:</form:label>
    	<form:input path="cust_post_code" cssClass="text_"></form:input>
    	<form:errors path="cust_post_code" cssClass="error"/><br></br>
    	
    	<form:label for="cust_phone_no" path="cust_phone_no" cssClass="required">PhoneNo<font color="red">*</font>:</form:label>
    	<form:input path="cust_phone_no" cssClass="text_"></form:input>
    	<form:errors path="cust_phone_no" cssClass="error"/><br></br>
    	
    	<form:label for="cust_bank_branch_name" path="cust_bank_branch_name" cssClass="required">NearBy Bank Branch<font color="red">*</font>:</form:label>
    	<form:select path="cust_bank_branch_name" cssClass="text_">
    		<form:option value="-" label="--Please Select--"></form:option>
    		<form:options items="${branches}"/>
    	</form:select>
    	<form:errors path="cust_bank_branch_name" cssClass="error"/><br></br>
    	
    	<form:label for="cust_enable_netbanking" path="cust_enable_netbanking" cssClass="required">Enable NetBanking?:</form:label>
    	<form:checkbox path="cust_enable_netbanking" id="cust_enable_netbanking" name="cust_enable_netbanking" value="Enable NetBanking" />
    	<form:errors path="cust_enable_netbanking" cssClass="error"/><br></br>
    	
    	<form:label for="cust_netbanking_id" path="cust_netbanking_id" name="cust_netbanking_id" cssClass="required">NetBanking userId:</form:label>
    	<form:input path="cust_netbanking_id" cssClass="text_" id="cust_netbanking_id" name="cust_netbanking_id"></form:input>
    	<form:errors path="cust_netbanking_id" cssClass="error"/><br></br>
    			<div id="postResultDiv">
  					
				</div>
    	<button type="button" onclick="javascript:ajaxPost();">CheckUid</button>
    	<button type="button" value="cancel" class="cancelbtn" onclick="if(confirm('Are you SURE you wish to cancel?')) history.back();">Cancel</button>
    	<input type="Submit" name="submit" class="btn-submit" value="submit"></input>
	</form:form>
	</div>
	<!-- div class="block2">
		<section><a href="#">Need help?</a></section><br/>
		<section><a href="#">Useful Links</a></section><br/>
		<section><a href="#">Frequently asked questions</a></section><br/>	
	</div-->
</div>
<hr></hr>
<div class="footerdiv">
<section><a href="#">About Us</a></section><section><a href="#">Contact Us</a></section><section><a href="#">CopyWright</a></section>

</div>
<script>

function ajaxPost1(){
	// PREPARE FORM DATA
	    var userId = document.customerForm.cust_netbanking_id.value;
	    alert("CALLED");
	    var minLength = 9;
	    var maxLength = 12;

	           var isValid = true;
	           var userIdLength = userId.length;
	           if(userIdLength < minLength){
	            $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'> Length is short, minimum "+minLength+" required.</p>");
	            isValid = false;
	            }else if(userIdLength > maxLength){
	            $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'> Length is not valid, maximum "+maxLength+" allowed.</p>");
	            isValid = false;
	            }

	            if (!isValid) {
	                //Prevent the form from submitting via the browser.
	                event.preventDefault();
	                return false;
	            }

	         // DO POST
	            $.ajax({
	                            type : "POST",
	                            contentType : "application/json",
	                            url : "https://192.168.99.100:9443/mybank/customer/checkuid",  //Specifies the URL to send the request to.
	                            data : JSON.stringify(userId).replace(/"/g, ""),  //Specifies data to be sent to the server
	                            dataType : 'html', //'json',       //The data type expected of the server response
	                            success : function(result) {
	                                    //alert(result);
	                                    if(result == "available"){
	                                            $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
	                                                                                        "Post Successfully! " +
	                                                                                        "Typed Uid: " +
	                                                                                        result + "</p>");
	                                    }else{
	                                        $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:red; padding:20px 20px 20px 20px'> Typed Uid " + result +
	                                                                                        ". Please chose another Uid");
	                                    }
	                                    //console.log(result);
	                            },
	                            error : function(xhr, status, error) {
	                                //alert("Error!");
	                                //alert("xhr "+xhr);
	                                //alert("status "+ status);
	                                //alert("responseText " + xhr.responseText);
	                                //alert("error Message: "+error.message);
	                                console.log("ERROR: ", error);

	                        }
	                });

	        }    
	    
	    
$( document ).ready(function() {
    
$("#cust_netbanking_id").keyup(function( event ) {
		 var minLength = 9;
	     var maxLength = 12;
	
	     var isValid = true;
	     var userIdLength = $("#cust_netbanking_id").val().length;
	     if(userIdLength < minLength){
	      $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'> Length is short, minimum "+minLength+' required.</p>');
	      isValid = false;
	     }else if(userIdLength > maxLength){
	      $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'> Length is not valid, maximum "+maxLength+" allowed.</p>");
	      isValid = false;
	      }
	
	      if (!isValid) {
	          //Prevent the form from submitting via the browser.
	          event.preventDefault();
	          return false;
	      }else {
	          ajaxPost();
	      }
    });

function ajaxPost(){

    // PREPARE FORM DATA
    var userId = $("#cust_netbanking_id").val();
    
    // DO POST

    $.ajax({		    
                    type : "POST",
                    contentType : "application/json",
                    url : "https://192.168.99.100:9443/mybank/customer/checkuid",  //Specifies the URL to send the request to.
                    data : JSON.stringify(userId).replace(/"/g, ""),  //Specifies data to be sent to the server
                    dataType : 'html', //'json',       //The data type expected of the server response
                    success : function(result) {
                            //alert(result);
                    		if(result == "available"){
                            	$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                                                                        "Post Successfully! " +
                                                                        "Typed Uid: " +
                                                                        result + "</p>");
                    		}else{
                          		$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:red; padding:20px 20px 20px 20px'> Typed Uid " + result +
                                                                        ". Please chose another Uid");
                    		}
                            console.log(result);
                    },
                    error : function(xhr, status, error) {
                        //alert("Error!");
                      	//alert("xhr "+xhr);
                        //alert("status "+ status);
                        //alert("responseText " + xhr.responseText);
                        //alert("error Message: "+error.message);
                        console.log("ERROR: ", error);
                        
                }
        });

// Reset FormData after Posting
resetData();

}

function resetData(){

$("#cust_netbanking_id").val();
}
})



//Wait for the DOM to be ready
$(function () {
    //$('input[name="cust_netbanking_id"]').hide();

    //show it when the checkbox is clicked
    $('input[name="cust_enable_netbanking"]').on('click', function () {
			        if ($(this).prop('checked')) {
			            $('input[name="cust_netbanking_id"]').fadeIn();
			            $('label[name="cust_netbanking_id"]').fadeIn();
			            
			            //$('input[name="cust_netbanking_id"]').slideDown();
                        //$('label[name="cust_netbanking_id"]').slideDown();
			        } else {
			            $('input[name="cust_netbanking_id"]').hide();
			            $('label[name="cust_netbanking_id"]').hide();
			            $('div[id="postResultDiv"]').hide();
			            //$('input[name="cust_netbanking_id"]').slideUp("show");
			        	//$('label[name="cust_netbanking_id"]').slideUp("show");
			        }
			});
});
    
$(function () {
    // Initialize form validation on the registration form.
    // It has the name attribute "customerForm"
    $('form[name="customerForm"]').validate({})

});


</script>

</body>
</html>