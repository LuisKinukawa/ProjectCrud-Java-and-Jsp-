<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="br.com.fiap.dao.PesoDAO" %>
<jsp:useBean id="peso" class="br.com.fiap.model.Peso"></jsp:useBean>
<jsp:setProperty property="*" name="peso"/>
<%
int i = PesoDAO.updatePeso(peso);
response.sendRedirect("pagina-inicial.jsp");
%>


</body>
</html>