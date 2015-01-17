<%-- 
    Document   : addgdrive
    Created on : Feb 26, 2014, 2:11:01 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add Gdrive</title>
    <script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
    <link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form name="form1" method="post" action="addgdrive">
          <p>enter your google drive account : 
            <label for="textfield"></label>
            <span id="sprytextfield1">
            <input name="gaccount" type="text" id="textfield" size="50">
            <span class="textfieldRequiredMsg">A value is required.</span><span class="textfieldInvalidFormatMsg">Invalid format.</span></span></p>
          <p>In order to add your account you must allow this application to access your drive files.</p>
          <p>
            <input type="checkbox" name="allow" id="checkbox">
            <label for="checkbox"></label>
            Allow access
          </p>
          <p>Enter the folder drive folder name you wanted to keep sync: 
            <label for="textfield2"></label>
            <input type="text" name="gfolder" id="textfield2">
          </p>
          <p>
            <input type="submit" name="Submit" id="button" value="Add account">
          </p>
          <p>&nbsp;</p>
        </form>
        <h1>&nbsp;</h1>
    <script type="text/javascript">
var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1", "email");
        </script>
    </body>
</html>
