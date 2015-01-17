<%-- 
    Document   : registration
    Created on : Feb 24, 2014, 8:36:26 PM
    Author     : Pratiksha 18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <style>
		body{
		background-image:url(image/bg.jpg);
		}
                #font{
			font-family:Georgia, "Times New Roman", Times, serif;
			font-size:50px;
			font-style:italic;
			font-weight:bolder;
                        text-shadow:#9F6;
			color:#eeffcc;
			padding-left:20px;
                }
                #reg{
                    background-image: url(image/hbox1.jpg);
                    height:600px;
					width:1040px;
			margin-top:30px;
			border:double;
			border-color:#990;
			border-radius:15px 15px 15px 15px;
			border-width:thick;
			margin-left:10%;
                }
		   #menu1{
		       background-color:#030;
			   border-bottom-left-radius:15px;
			   border-bottom-right-radius:15px;
			   border-bottom-color:#990;
			   border-right-color:#990;
			   border-left-color:#990;
			   height:7%;
			   width:400px;
			   border-top:none;
			   border-width:thick;
			border-style:double;
			 margin-left:30%;  
			 font-family:Georgia, "Times New Roman", Times, serif;
			 font-size:22px;
			 color:#eeffcc;
			 font-weight:bold;
		   }
		   #form2{
			    float:left;
			    margin-left:2%;
			   }
			   #form3{
			      float:right;
			   }
			   #main{
			      width:900px;
			   }
         </style>
         <link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
    <script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
    </head>
    <body>
        <br/>
        <div id="font">CloudSync</div>
        <div id="reg">
           <div id="menu1"><center>Sign Up for Free</center></div>
         
            <br><br>
            <div id="main">
           <div id="form2">
               <a href=" https://accounts.google.com/o/oauth2/auth?access_type=offline&approval_prompt=auto&client_id=1057212581093-1v1och7f60nteqq5irs9s4bcu1ticeph.apps.googleusercontent.com&redirect_uri=http://hellopratixadrive.appspot.com/hellodevanshi&response_type=code&scope=https://www.googleapis.com/auth/drive">
            <img src="image/google_drive_logo.png" style="margin-left:55%"/></a>
           
           
          
            
            </div>
            <div id="form3">
            <a href="addskydrive.jsp">
                <input type="image" src="image/skydrive_logo.png" style="margin-left:30%"></a><br><br><br>
            
        
            <label for="skydrive_acc"></label>
           
           <br><br>
             
    </div></div>
    <script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2", "none", {minChars:8});
var sprytextfield3 = new Spry.Widget.ValidationTextField("sprytextfield3", "email");
var sprytextfield4 = new Spry.Widget.ValidationTextField("sprytextfield4", "email");
    </script>
    </body>
</html>
