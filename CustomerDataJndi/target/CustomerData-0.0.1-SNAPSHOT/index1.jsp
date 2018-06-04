<?xml version="1.0" encoding="ISO-8859-1" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="ISO-8859-1">
<title>CustomerData</title>
<link rel="stylesheet" type="text/css" href="navstyle.css">

<style>
	
	.button1 {
    background-color: white;    
    border: 2px solid #4CAF50; /* Green */
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    opacity: 0.6;
    #cursor: not-allowed;
    margin: 1em;
	}
	
	.button2 {
    background-color: white;
    border: 2px solid #008CBA; /* Blue */
    color: black;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 2px;
    transition-duration: 0.4s;
	}
	.button1:hover {
   	 background-color: #008CBA; /* Green */
     color: white;
	}
	
	.button2:hover {
   	 background-color: #4CAF50; /* Green */
     color: white;
	}
	

</style>
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
<div class="headerdiv">Welcome to <a href="/CustomerData">MyBank</a></div>

<a href="./login.html" class="button1">Existing User</a>
<a href="./userInfo.html" class="button2">NewUser</a>


<hr/>
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