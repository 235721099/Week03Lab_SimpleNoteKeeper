<%-- 
    Document   : viewnote
    Created on : Sep 30, 2020, 8:54:19 AM
    Author     : 730676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <Strong>Title: </Strong>${note.title}
        <p><Strong>Contents: </Strong></p><p>${note.contents}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
