<%-- 
    Document   : activate.jsp
    Created on : May 1, 2015, 6:05:27 PM
    Author     : cardona_76937
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("user");
    session.setAttribute("user", name);
%>
<jsp:useBean id="Check" class="functionCheck.checkUserLogin" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Activation</title>
    </head>
    <body>
        <%
            String message = "", message2 = "";
            int isValid = Check.activate(name);
            if (isValid == 1) {
                message = "Account Activated!";
                message2 = "You may now log in by <a href=\"index.jsp\">clicking here</a>";
            } else {
                message = "Account could not be activated :\'(";
                message2 = "An error has occured.";
            }
        %>
        <h1><% out.print(message); %></h1>
        <% out.print(message2); %>
    </body>
</html>
