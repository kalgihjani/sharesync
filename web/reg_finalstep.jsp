<%-- 
    Document   : skydrive_invite
    Created on : Feb 27, 2014, 2:22:21 PM
    Author     : Pratiksha 18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration final step</title>
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
      </head>
    <body>
     <br/>
        <div id="font">CloudSync</div>
        <div id="reg1">
        <div id="font1">
           <br><center> Now you have registered your account and sucessfully send an invitation to your friend. Now create your account.</center>
        </div>
        <div id="box">
         <form name="form1" method="post" action="reg_action" margin-top="20%">
         
           <table width="473" border="0" cellpadding="4" cellspacing="5">
             <tr>
               <td>Username</td>
             </tr>
             <tr>
             <td>
             <input name="uname" type="text" id="uname" size="50" maxlength="35" style="border-radius:10px 10px 10px 10px">
             </td>
             </tr>
             <tr>
               <td>Password</td>
             </tr>
             <tr>
               <td>
              <input name="passwd" type="password" id="passwd" size="50" maxlength="35" style="border-radius:10px 10px 10px 10px">
               
              </td>
             </tr>
             <tr>
               <td>
               
                 <input type="submit" name="signup" id="login2" value="Sign up" style="background-color:#030;color:#eeffcc;font-weight:bold">
                 
               </td>
             </tr>
             </table>
          
         </form>
           </div>
       </div>