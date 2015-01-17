<%-- 
    Document   : next1
    Created on : Apr 22, 2014, 7:11:11 PM
    Author     : Pratiksha 18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
         body{
		background-image:url(image/bg.jpg);
		}
                #img1{
                    height: 100px;
                    margin-left: 10%;
				
                }
                #mainheader1{
		    background-image: url(image/hbox1.jpg);
			height:600px;
			margin-top:30px;
			border:double;
			border-color:#990;
			border-radius:15px 15px 15px 15px;
			border-width:thick;
		
		}
                #font{
			font-family:Georgia, "Times New Roman", Times, serif;
			font-size:20px;
			font-style:italic;
			font-weight:bolder;
            text-shadow:#9F6;
			color:#030;
			padding-left:20px;
		}
         </style>
    </head>
    <body>
        <div id="mainheader1">
            <div id="font"><br>
                Stpe:3 If you select google drive account,then you will be redirected to Google's official login page where you have to enter your google drive account.<a href="next2.jsp">next page</a><br><br> </div>
            <div id="img1">  <img src="image/shot4.png" style="border:thick;border-color:#000"/> </div>
            
        </div> 
       
    </body>
</html>
