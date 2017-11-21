<%-- 
    Document   : history
    Created on : May 2, 2015, 8:29:27 AM
    Author     : cardona_76937
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%
    String name = request.getParameter("name");
    session.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usage History</title>
    </head>
    <body>
        <h1>Usage History for: <%=session.getAttribute("name")%></h1>
        Total Usage:
        <%
            String FileDirectory = "C:\\files\\";
            BufferedReader input = new BufferedReader(new FileReader(FileDirectory + name + "_history2"));
            String line = "";
            while ((line = input.readLine()) != null) {
                out.println(line);
                out.print("<br>");
            }
            out.flush();
            input.close();
        %>
        </br></br>
        </br>
        <%
            BufferedReader input2 = new BufferedReader(new FileReader(FileDirectory + name + "_history1"));
            String line2 = "";
            while ((line2 = input2.readLine()) != null) {
                if (line2.equals("Select a date below to check the code and results:") == false)
                    out.println("<a href=\"results.jsp?name=" + name + "&date=" + line2 + "\">" + line2);
                else
                    out.println(line2);
                out.print("<br>");
            }
            out.flush();
            input.close();
        %>
    </body>
</html>
