<%-- 
    Document   : index
    Created on : 09-Mar-2016, 16:52:19
    Author     : vilde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="css/style.css">
        <%  response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0");
            response.addHeader("Pragma", "no-cache");
            response.addDateHeader("Expires", 0);
        %>

        <script>
            function initialiseflag()
            {
                var flag = 0;
            }
        </script>
    </head>
    <body onload="initialiseflag();">

        <div class="wrapper">
            <h1>XYZ Drivers Association</h1>

            <div class="list-page">


                <h2>Handle charges</h2>
                </br>

                <form id="make-status-change-form" method="POST" action="PageRouter.do">
                    <table class="responsetable">
                        <tr class="chargerowheader">
                            <th class="chargetd">&lt;select&gt;</th>                               
                            <th class="chargetd">  Member  </th>
                            <th class="chargetd">  Amount  </th>
                            <th class="chargetd">  Payment id  </th>
                            <th class="chargetd">  Payment type </th>
                            <th class="chargetd">  Payment date </th>
                            <th class="chargetd">  Note  </th>              
                        </tr>


                        <c:forEach var="charge" items="${list}">
                            <tr class="chargerow">
                                <td class="chargetd"><div display="inline"><input onclick="check()" display="inline" type="checkbox" name="chargeId[]" value="${charge.id}" required="true"></div></td>
                                <td class="chargetd">${charge.name}</td>
                                <td class="chargetd">${charge.amount}</td>
                                <td class="chargetd">${charge.paymentId}</td>         
                                <td class="chargetd">${charge.paymentType}</td>
                                <td class="chargetd">${charge.paymentDate}</td>
                                <td class="chargetd">${charge.note}</td>             
                            </tr>
                        </c:forEach>

                    </table>

                    </br>
                    </br>

                    <input type="hidden" name="action" value="submitchargechange" />
                    <input type="hidden" name="status" value="APPROVED" />
        


                </form>
                <form id="cancel-form" method="POST" action="PageRouter.do">
                    <input type="hidden" name="action" value="admindashboard" />
                </form>
                <p class="greentext">
                    <% if (request.getAttribute("rowschanged") != null) {
                    %>
                    <%=("Rows changed: " + (String)request.getAttribute("rowschanged"))%> </br></br>
                    <%
                        
                        }%>
                </p>
                <ul class="choice">
                    <li onclick="document.getElementById('cancel-form').submit();" class="user-button cancel">Dashboard</li>
                    <li id="submitbutton" onclick="submitform();" class="user-button submit">Set status APPROVED</li>
                    <div style="clear:both"></div>
                </ul>


            </div>
        </div>

        <script> function check() {
                flag = 1;
            }</script>
        <script> function submitform() {
                if (flag === 1) {
                    document.getElementById('make-status-change-form').submit();
                }
            }</script>
    </body>
</html>
