/**
 * 
 */
$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#cust_netbanking_id").keyup(function( event ) {
    		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var inputdata = $("#cust_netbanking_id").val();
   	
    	// DO POST
    	
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "customer/checkuid",  //Specifies the URL to send the request to.
			data : JSON.stringify(userId).replace(/"/g, ""),  //Specifies data to be sent to the server
			dataType : 'json',					//The data type expected of the server response
			success : function(result) {
				alert(result);
				//if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> Customer's Info: FirstName = " + 
												result + "</p>");
				//}else{
				//	$("#postResultDiv").html("<strong>Error</strong>");
				//}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();
 
    }
    
    function resetData(){
    	
    	$("#cust_netbanking_id").val()
    }
})



$(function () {
    $('input[name="cust_netbanking_id"]').hide();

    //show it when the checkbox is clicked
    $('input[name="checkbox"]').on('click', function () {
        if ($(this).prop('checked')) {
            $('input[name="cust_netbanking_id"]').fadeIn();
        } else {
            $('input[name="cust_netbanking_id"]').hide();
        }
    });
});