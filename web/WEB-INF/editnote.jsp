<%-- 
    Document   : editnote
    Created on : Sep 30, 2020, 8:55:10 AM
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
        <h2>Edit Note</h2>
        <form method="post" action="note">
            Title: <input type="text" name="title" value="${t}"><br>
            Contents: <textarea type="textarea" name="contents" value="${c}"
                                rows="10" cols="30">${c}</textarea>
            <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
