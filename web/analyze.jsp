<%-- 
    Document   : analyze
    Created on : May 2, 2015, 6:03:01 AM
    Author     : cardona_76937
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String code=request.getParameter("codefield");
    String name=request.getParameter("name"); 
    session.setAttribute("codefield", code); 
    session.setAttribute("name", name); 
 %>
<jsp:useBean id="Analyze" class="functionCheck.codeAnalyzer" scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analyzing Code</title>
    </head>
    <body>
        <h1>Analyzing Code</h1>
        <% 
            String url = "";
            String date = "";
            ;
            date = Analyze.codeAnalyze(name, code); 
            url="results.jsp?name="+ name + "&date=" + date; //relative url for display jsp page
             response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", url); 
        %>
    </body>
</html>
