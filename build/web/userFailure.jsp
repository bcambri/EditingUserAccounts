<%-- 
    Document   : userFailure
    Created on : Jan 25, 2018, 2:37:29 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Invalid username or password</h1><br>
        <button onclick="back()">Back</button>
        <button onclick="backToHome()">Back to Home</button>
        <script>
            function back() {
                window.open("login.htm", "_self");
            }
            function backToHome() {
                window.open("index.htm", "_self");
            }
        </script>
    </body>
</html>
