<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="br.com.fiap.dao.AtividadeDAO" %>
<jsp:useBean id="atividade" class="br.com.fiap.model.Atividade"></jsp:useBean>
<jsp:setProperty property="*" name="atividade"/>

<% 
	int i = AtividadeDAO.salvar(atividade);
	
	if(i>0){
		response.sendRedirect("addAtv-success.jsp");
	}else{
		response.sendRedirect("addAtv-error.jsp");		
	}
%>

</body>
</html>