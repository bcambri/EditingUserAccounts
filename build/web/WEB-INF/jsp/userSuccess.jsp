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
        <div id="divToChange">
            ${user.username}
        </div>
        <button onclick="backToHome()">Back to Home</button>
        <script>
            var toChange = document.getElementById("divToChange");
            var email = toChange.innerHTML;
            var username = email.substring(0, email.indexOf("@"));
            toChange.innerHTML = "<h1>Hello, " + username + ". Welcome to Mummy's!</h1>";
            function backToHome() {
                window.open("index.htm", "_self");
            }
        </script>
    </body>
</html>
