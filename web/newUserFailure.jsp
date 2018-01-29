<%-- 
    Document   : newUserFailure
    Created on : Jan 25, 2018, 3:29:01 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup Failure</title>
    </head>
    <body>
        <h1>An account with the username ${user.username} already exists</h1><br>
        <button onclick="back()">Back</button>
        <button onclick="backToHome()">Back to Home</button>
        <script>
            function back() {
                window.open("signup.htm", "_self");
            }
            function backToHome() {
                window.open("index.htm", "_self");
            }
        </script>
    </body>
</html>
