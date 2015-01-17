<%-- 
    Document   : welcome
    Created on : May 10, 2014, 11:37:29 PM
    Author     : DELL
--%>

<%@page import="com.google.api.services.drive.model.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gAccess.googleAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h3> My Files</h3>
        <%  ArrayList<File> list=googleAccess.retrieveAllFiles((String)session.getAttribute("accessCode"));
        
            for(int i=0;i<list.size();i++){
                out.println("<br>Title="+list.get(i).getTitle());
            }
        %>
    </body>
</html>
