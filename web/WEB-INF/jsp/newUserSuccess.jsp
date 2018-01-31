<%-- 
    Document   : newUserSuccess
    Created on : Jan 25, 2018, 12:01:57 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Success</title>
    </head>
    <body>
        <h1>Congratulations! Your account has been created with the email ${user.username}</h1>
        <button onclick="backToHome()">Back to Home</button>
        <script>
            function backToHome() {
                window.open("index.htm", "_self");
            }
        </script>
    </body>
</html>
