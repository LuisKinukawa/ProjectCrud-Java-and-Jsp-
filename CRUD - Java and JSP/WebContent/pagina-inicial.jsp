
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="css/estilo2.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<!------ Include the above in your HEAD tag ---------->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pagina Inicial</title>
</head>

<body>
<%@ page import="br.com.fiap.dao.PesoDAO" %>
<%@ page import="br.com.fiap.model.Peso" %>
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
<h2 style="font-weight:600;font-family:Tahoma;text-align:center;">Página inicial</h2>


	<br>
	<br>
<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel" style="height:500px;width:800px;position:relative;margin-left:230px">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="Health_track3.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="Health_track9.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="Health_track10.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>


<br>
<br>
<br>
<h4 class="col-6" style="font-weight:600;font-family:Tahoma;">Histórico Pesos</h4>
	
	<%
	List<Peso> list = PesoDAO.getAllPesos();
	request.setAttribute("list", list);
	%>
<br>
<br>	
<table  class="table" style="border:3px solid #3680bd;position:relative;width:600px;margin-left:350px">
  <thead  style="background-color: #3680bd;">
    <tr>
      <th scope="col" style="color:white;">Data</th>
      <th scope="col" style="color:white;">Peso</th>
       <th scope="col" style="color:white;">Editar</th>
      <th scope="col" style="color:white;">Deletar</th>

    </tr>
  </thead>
		<c:forEach items="${list}" var="peso">
			<tr style="font-weight:bold;">
			<td>${peso.getData()}</td>
			<td>${peso.getPeso()}</td>

			<td><a type="button" class="btn btn-outline-primary" style="color:black;"
				href="editformpeso.jsp?data=${peso.getData() }">Editar</a></td>
			<td><a type="button" class="btn btn-outline-primary" style="color:black;"
				href="deletepeso.jsp?data=${peso.getData()}"><i class="fa fa-trash"></i></a></td>
			</tr>
		</c:forEach>
		
	</table>

<a type="button" href="cadastro-novo-peso.jsp" class="btn btn-outline-primary" style="position:absolute;margin-left:410px;">Novo cadastro</a>
<br>
<br>
<br>
<br>
<br>
<br>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
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