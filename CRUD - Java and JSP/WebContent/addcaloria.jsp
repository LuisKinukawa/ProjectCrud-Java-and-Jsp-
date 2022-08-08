<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="br.com.fiap.dao.DietaDAO" %>
<jsp:useBean id="dieta" class="br.com.fiap.model.Dieta"></jsp:useBean>
<jsp:setProperty property="*" name="dieta"/>

<% 
	int i = DietaDAO.salvar(dieta);
	
	if(i>0){
		response.sendRedirect("addDieta-success.jsp");
	}else{
		response.sendRedirect("addDieta-error.jsp");		
	}
%>

</body>
</html>