<%-- 
    Document   : skydrive_invite
    Created on : Feb 27, 2014, 2:22:21 PM
    Author     : Pratiksha 18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Validate code</title>
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
				 #reg1{
                    background-image: url(image/hbox1.jpg);
                    height:500px;
					width:1040px;
			margin-top:30px;
			border:double;
			border-color:#990;
			border-radius:15px 15px 15px 15px;
			border-width:thick;
			margin-left:10%;
                }
		    #font1{
			    font-family:Georgia, "Times New Roman", Times, serif;
				font-weight:bold;
				font-size:18px;
				color:#030;
			
			}
			 #box1{
                    margin-left:30%;
                    margin-top:7%;
                    height:36%;
                    width:400px;
                   background-color:#230;
                   border-width:thick;
			border-style:double;
			 border-color:#990;
			 border-radius:15px 15px 15px 15px;
			 
                }
	  </style>
   <!--<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
    <script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script> -->
    </head>
    <body>
     <br/>
        <div id="font">CloudSync</div>
        <div id="reg1">
        <div id="font1">
           <br><center> Enter the access code from the Email to register your account.</center>
        </div>
    <div id="box1">
        <form name="form1" method="post" action="checkcode">
          <div id="font">
            <font size="5">Enter code</font>
            <table width="200" border="0">
              <tr>
                <td>
                  <!--<span id="sprytextfield1"> -->
                  <!--<label for="skydrive_acc"></label> -->
                  <input name="accesscode" type="text" id="accesscode" size="50" maxlength="50" placeholder="                      Enter acceess code here" style="border-radius:15px 15px 15px 15px">
                 <!-- <span class="textfieldRequiredMsg">A value is required.</span><span class="textfieldInvalidFormatMsg">Invalid format.</span></span> -->
             </td>
              </tr>
              <tr>
                <td>
                <center>  <input type="submit" name="Invite" id="invite" value="Invite" style="background-color:#030;color:#eeffcc;font-size:14px"></center>
                </td>
              </tr>
            </table>
          
            <p>&nbsp;</p>
          </div>
        </form>
        </div>
  <!--  <script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "email");
        </script> -->
    </body>
</html>
