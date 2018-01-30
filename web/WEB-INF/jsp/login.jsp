<%-- 
    Document   : login
    Created on : Jul 26, 2012, 11:57:53 AM
    Author     : LS5002117
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>        
        <form:form method="POST" commandName="user"> 
            <table> 
                <tr> 
                    <td>Username:</td> 
                    <td><form:input path="username" /></td> 
                    <td><form:errors path="username" cssClass="error" /></td>
                </tr> 
                <tr> 
                    <td>Password:</td> 
                    <td><form:password path="password" /></td> 
                    <td><form:errors path="password" cssClass="error" /></td>
                </tr> 
                <tr> 
                    <td colspan="2">
                        <input type="submit" value="Login"></td> 
                </tr> 
            </table> 
        </form:form>
        <button onclick="back()">Back</button>
        <script>
            function back() {
                window.open("index.htm", "_self");
            }
        </script>
    </body>
</html>
