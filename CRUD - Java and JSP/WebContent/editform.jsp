<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/estilo2.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<!------ Include the above in your HEAD tag ---------->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>User</title>
</head>


<body>

	<%@ page import="br.com.fiap.dao.PessoaDAO" %>
	<%@ page import="br.com.fiap.model.Pessoa" %>
	<%@ page import="java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<div class="collapse" id="navbarToggleExternalContent">
  <div class="bg-dark p-4">
    <h5 class="text-white h4">Collapsed content</h5>
    <span class="text-muted">Toggleable via the navbar brand.</span>
  </div>
</div>
<nav class="navbar navbar-light" style="background-color: #3680bd;">
  <div class="container-fluid" >
    <a class="navbar-brand" href="pagina-inicial.jsp" style="font-weight:600;">Health Track</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="cadastro-novo-peso.jsp" style="color:black;">Cadastro Peso</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="lista-exercicios.jsp" style="color:black;">Lista de exercícios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="dieta.jsp" style="color:black;">Dieta</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="1.jsp" style="color:black;">Editar usuário</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp" style="color:black;">Sair</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<br>
<h2 style="font-weight:600;font-family:Tahoma;text-align:center;">Editar usuário</h2>


	<br>
	<br>
	<br>
	
<br>
<br>

	<%
		String nome=request.getParameter("nome");
		Pessoa pessoa = PessoaDAO.getRegistrobyNome(nome);
	%>
	
	<form action="editPessoa.jsp" method="post">
		
		
			<table class="table" style="border:3px solid #3680bd;position:relative;width:800px;margin-left:250px">
				
				<tr>
					<td>Data de nascimento</td>
					<td><input type="date" name="data" value="<%=pessoa.getData()%>"/></td>
				</tr>
				<tr>
					<td>Sexo</td>
					<td><input type="text" name="sexo" value="<%=pessoa.getSexo()%>"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="<%=pessoa.getEmail()%>"/></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" value="<%=pessoa.getSenha()%>"/></td>
				</tr>
				<tr>
					<td>Usuário</td>
					<td><input type="text" name="nome" value="<%=pessoa.getNome()%>"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Editar"></input></td>
				</tr>
			</table>
	
	</form>
	<br>

</body>

<Footer><nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #3680bd;height:50px">
  <div class="container-fluid" >
    <span class="navbar-text" >
      <alt="" width="300" height="240">
    </span>
     
  </div>
</nav>
</Footer>
</html>