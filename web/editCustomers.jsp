<%-- 
    Document   : editCustomers
    Created on : Jan 26, 2018, 3:05:26 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="Controller.EditCustomersClass"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customers</title>
        <style>
            table {
                border-collapse: collapse;
            }
            #customers { 
                border: solid;
                border-width: 1px 0;
            }
        </style>
    </head>
    <body>        
        <h1>Mummy's Customers</h1>
        <table>
            <tr id="customers">
                <th>Id</th>
                <th>Customer</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${listOfCustomers}" var="customer">
                <tr id="customers">
                    <td>${customer.id}</td>
                    <td>${customer.first} ${customer.last}</td>
                    <td>${customer.enabled}</td>
                </tr>
            </c:forEach>
        </table>
        <form method="POST" action="editCustomers.jsp"> 
            <table> 
                <tr>
                    <td><h3>To not make a change, enter 0 for the field</h3></td>
                </tr>
                <tr> 
                    <td>Id of customer to ban/enable :</td> 
                    <td><input type="text" name="toChange" autocomplete="off" required="required"/></td> 
                </tr>
                <tr>
                    <td>Id of customer to delete :</td> 
                    <td><input type="text" name="toDelete" autocomplete="off" required="required"/></td> 
                </tr> 
                <tr> 
                    <td colspan="2">
                        <input type="submit" value="Make changes"></td> 
                </tr> 
            </table> 
        </form>
        <br>
        <button onclick="back()">Back</button>
        <script>
            function back() {
                window.open("index.htm", "_self");
            }
        </script>
        <% String chngId = request.getParameter("toChange"); %>
        <% String dltId = request.getParameter("toDelete"); %>
        <% EditCustomersClass db = new EditCustomersClass();
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
