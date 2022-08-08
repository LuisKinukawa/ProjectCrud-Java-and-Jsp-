<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="css/estilo2.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<title>Cadastro Peso</title>
</head>
<body style="background-color:#ffffff";>

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
<h2 style="font-weight:600;font-family:Tahoma;text-align:center;">Cadastro de peso</h2>
<br>
<br>
<div class="imagem">
	<img src="Health_track4.jpg" style="height:350px;width:500px;display:table-cell;float:left; position:relative;margin-left:50px">
</div>

<div class="container">

  <div class="row">
    <div class="col-sm"> </div>
    <div class="col-sm">
  
		
<div class="container" >
		<h4 style="font-weight:500;font-family:Tahoma;text-align:center;">Novo registro</h4>
		<br>
		<form action="addpeso.jsp" method="post">
		  <div class="mb-3">
		    <label for="pPeso" class="form-label" style= "width:300px;">Peso: </label>
		    <input name="peso" type="text" class="form-control" id="pPeso" aria-describedby="emailHelp" style= "width:350px;" required>
		    
		  </div>
		  		  		  		  
			<div class="mb-3">
		    <label for="pDia" class="form-label" style= "width:300px;">Dia do cadastro: </label>
		    <input name="data" type="date" class="form-control" id="pDia" style= "width:350px;" required>
		  </div>
		  
		  <br>
	  
		  <button style="position:relative;left:20%;width:200px;"type="submit;" class="btn btn-outline-primary" value="Cadastrar" >Cadastrar</button>
		 
		  		  
		</form>
		
	</div>

	</div>
    <div class="col-sm"> </div>
  </div>
</div>
<br>
<br>
<br>
<br>
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