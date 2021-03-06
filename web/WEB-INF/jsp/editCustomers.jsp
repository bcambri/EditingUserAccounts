<%-- 
    Document   : editCustomers
    Created on : Jan 26, 2018, 3:05:26 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Controller.EditCustomersController"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customer Accounts</title>
        <style>
            div {
                float:left;
            }
            table {
                border-collapse: collapse;                
            }
            #customers { 
                border: solid;
                border-width: 1px 0;                
            }
            #form {                
                margin-left:25px;
                padding:15px;
                border:solid;
                border-color:gray;
            }
        </style>
    </head>
    <body>   
        <div>
            <h1>Mummy's Customers</h1>

            <table cellpadding="5">
                <tr id="customers">
                    <th>Customer</th>
                    <th>Email</th>
                    <th>Id</th>
                    <th>Account Status</th>
                </tr>
                <c:forEach items="${listOfCustomers}" var="customer">
                    <tr id="customers">
                        <td>${customer.last}, ${customer.first}</td>
                        <td>${customer.username}</td>
                        <td>${customer.id}</td>
                        <td>${customer.enabled}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="form">
            <h2>Make changes to customer status</h2>
            <h4>Enter 0 for any field(s) you do not wish to update</h4>
            <form method="POST" action="editCustomers.htm"> 
                <table> 
                    <tr> 
                        <td>Id of customer to ban/enable:</td> 
                        <td><input type="text" name="toChange" pattern="[0-9]*"
                                   autocomplete="off" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Id of customer to delete:</td> 
                        <td><input type="text" name="toDelete" pattern="[0-9]*"
                                   autocomplete="off" required="required"/></td>
                    </tr> 
                    <tr> 
                        <td colspan="2">
                            <input type="submit" value="Make changes"></td> 
                    </tr> 
                </table> 
            </form>
            <br>
            <button onclick="back()">Back</button>
        </div>
        <script>
            function back() {
                window.open("index.htm", "_self");
            }
        </script>
        <% String chngId = request.getParameter("toChange"); %>
        <% String dltId = request.getParameter("toDelete"); %>
        <% EditCustomersController db = new EditCustomersController();
            if (chngId == null) {
                chngId = "0";
            }
            if (dltId == null) {
                dltId = "0";
            }
            db.handleChanges(Integer.parseInt(chngId), Integer.parseInt(dltId));
        %>
        <%if (chngId != "0" || dltId != "0") {
                response.sendRedirect("editCustomers.htm");
            }%>        
    </body>
</html>
