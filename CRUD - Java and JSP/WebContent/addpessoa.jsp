<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="br.com.fiap.dao.PessoaDAO" %>
<jsp:useBean id="pessoa" class="br.com.fiap.model.Pessoa"></jsp:useBean>
<jsp:setProperty property="*" name="pessoa"/>

<%
	int i = PessoaDAO.salvar(pessoa);
	
	if(i>0){
		response.sendRedirect("addPessoa-success.jsp");
	}else{
		response.sendRedirect("addPessoa-error.jsp");
		
	}
%>
</body>
</html>