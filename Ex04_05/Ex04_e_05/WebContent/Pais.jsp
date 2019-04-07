<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "model.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>País</title>
</head>
<body>
	<%Pais pais = (Pais)request.getAttribute("pais"); %>
	Id: <%=pais.getId() %><br>
	Nome: <%=pais.getNome() %><br>
	População: <%=pais.getPopulacao() %><br>
	Area: <%=pais.getArea() %><br>
</body>
</html>