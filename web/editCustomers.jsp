<%-- 
    Document   : editCustomers
    Created on : Jan 26, 2018, 3:05:26 PM
    Author     : syntel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Customers</title>
    </head>
    <body>
        <h1>Mummy's Customers</h1>
        <button onclick="${showCustomers}.forEach(showCustomer)">Show Customers</button>
        <div id="divToChange">
            --------------------------------------------------------------
        </div>
        
        <script>
            var toChange = document.getElementById("divToChange");

            function showCustomer(customer) {
                console.log("Entered");
                //for(){
                    /*toChange.innerHTML += customer.firstname + " " + customer.lastname;
                    if (customer.enabled == 0)
                        toChange.innerHTML += "<button onclick='ban(" + customer + ")'>Ban</button>";
                    else
                        toChange.innerHTML += "<button onclick='enable(" + customer + ")'>Enable</button>";
                    toChange.innerHTML += "<button onclick='dlt(" + customer + ")'>Delete</button>";
                    toChange.innerHTML += "<br>--------------------------------------------------------------";*/
                //}
            }

            function ban(user) {
                user.enabled = 1;
                showCustomers();
            }

            function enable(user) {
                user.enabled = 0;
                showCustomers();
            }

            function dlt(user) {

            }
        </script>
    </body>
</html>
