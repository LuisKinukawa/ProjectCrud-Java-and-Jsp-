<%@page import="br.com.fiap.dao.PessoaDAO"%>  
<jsp:useBean id="pessoa" class="br.com.fiap.model.Pessoa"/>  
  
<jsp:setProperty property="*" name="pessoa"/>  
 
<%  
boolean status=PessoaDAO.validarUsuario(pessoa);
if(status){  
	response.sendRedirect("login-success.jsp");
}  
else  
{  
	response.sendRedirect("login-error.jsp");		  
}  
%>  