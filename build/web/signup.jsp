<%-- 
    Document   : signup
    Created on : Jan 25, 2018, 11:50:44 AM
    Author     : syntel
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
        <title>Sign up</title>
    </head>
    <body>        
        <form:form method="POST" commandName="user"> 
        <table>
            <tr> 
                <td>First Name :</td> 
                <td><form:input path="first" /></td> 
                <td><form:errors path="first" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Last Name :</td> 
                <td><form:input path="last" /></td> 
                <td><form:errors path="last" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Street :</td> 
                <td><form:input path="street" /></td> 
                <td><form:errors path="street" cssClass="error" /></td>
            </tr>
            <tr> 
                <td>City :</td> 
                <td><form:input path="city" /></td> 
                <td><form:errors path="city" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>State :</td> 
                <td><form:input path="state" /></td> 
                <td><form:errors path="state" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Zip :</td> 
                <td><form:input path="zip" /></td> 
                <td><form:errors path="zip" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Phone :</td> 
                <td><form:input path="phone" /></td> 
                <td><form:errors path="phone" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Username :</td> 
                <td><form:input path="username" /></td> 
                <td><form:errors path="username" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td>Password :</td> 
                <td><form:password path="password" /></td> 
                <td><form:errors path="password" cssClass="error" /></td>
            </tr> 
            <tr> 
                <td colspan="2">
                <input type="submit" value="Create Account"></td> 
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