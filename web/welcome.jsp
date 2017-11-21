<%-- 
    Document   : welcome
    Created on : May 1, 2015, 2:55:46 PM
    Author     : cardona_76937
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
String name=request.getParameter("name"); 
session.setAttribute("name", name); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaScript Function locator</title>
    </head>
    <body>
        <h1>Hello <% out.print(name); %></h1>
        <% out.print("<a href=\"history.jsp?name=" + name +"\">Check your usage</a><br><br><br>"); %>
        Please enter your JavaScript code below to analyze:
        <% out.print("<form method=\"POST\" action=\"analyze.jsp?name="+name+"\" id=\"codeanalyzer\">"); %>
            <textarea name="codefield" form="codeanalyzer" rows="25" cols="100"></textarea><br>
            <input type="submit" value="Analyze" />
        </form>
       
    </body>
</html>
