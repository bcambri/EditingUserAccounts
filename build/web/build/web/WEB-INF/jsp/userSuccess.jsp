<%-- 
    Document   : userSuccess
    Created on : Jul 26, 2012, 12:20:51 PM
    Author     : LS5002117
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Success</title>
    </head>
    <body>
        <h1>Hello ${user.username} Welcome to Mummy's<br/> !</h1>
        <button onclick="backToHome()">Back to Home</button>
        <script>
            function backToHome() {
                window.open("index.htm", "_self");
            }
        </script>
    </body>
</html>
