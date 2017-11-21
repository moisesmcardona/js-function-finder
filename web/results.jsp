<%-- 
    Document   : results
    Created on : May 2, 2015, 7:54:21 AM
    Author     : cardona_76937
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%
    String name = request.getParameter("name");
    String date = request.getParameter("date");
    session.setAttribute("name", name);
    session.setAttribute("date", date);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results!</h1>
        <%
            String FileDirectory = "C:\\files\\";
            BufferedReader input = new BufferedReader(new FileReader(FileDirectory + name + "_results_" + date));
            String line = "";
            while ((line = input.readLine()) != null) {
                out.println(line);
                out.print("<br>");
            }
            out.flush();
            input.close();
            out.print("<h2>Original Code</h2>");
            BufferedReader input2 = new BufferedReader(new FileReader(FileDirectory + name + "_code_" + date));
            String line2 = "";
            int linenumber = 1;
            while ((line2 = input2.readLine()) != null) {
                out.print(String.valueOf(linenumber) + ": ");
                out.println(StringEscapeUtils.escapeHtml4(line2));
                out.print("<br>");
                linenumber++;
            }
            out.flush();
            input2.close();
        %>

        </br></br> Thank you for using the JavaScript function finder.
    </body>
</html>
