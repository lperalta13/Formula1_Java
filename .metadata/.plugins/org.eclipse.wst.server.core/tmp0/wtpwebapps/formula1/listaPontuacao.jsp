<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.empresa.model.Pais" %>
<%@ page import="java.util.List,br.com.empresa.model.Equipe" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>F�mula 1</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/pro.css">

    <style type="text/css">
        img{
            height: calc(100vh - 463px);
            object-fit: cover;
        }
        .container:nth-of-type(2){
            min-height: calc(100vh - 463px);
            margin-bottom: 50px;
        }
    </style>

</head>
<body class="position-relative">
  <div class="jumbotron jumbotron-fluid mb-0 bg-danger text-white">
    <div class="container text-center">
      <h1 class="display-2 font-italic font-weight-bold"><strong> F�mula 1 </strong><i class="fas fa-tire fa-spin"></i></h1>
      <p class="lead">Sistema de Gerenciamento de Grandes Pr�mios de F�rmula 1</p>
    </div>
  </div>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-link" href="dashboard.html">Painel<span class="sr-only">(P�gina atual)</span></a>
            </li>
        </ul>
      </div>
    </div>
    </nav>
<div class="container" align="center">
	<div class="row mt-5">
		<div class="col-md-12">
			<h1>Listagem de Pontua��o</h1>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Piloto</td>
			<td>Equipe</td>
			<td>GP</td>			
			<td>Pontos</td>	
		</tr>
		<c:forEach items="${pontuacao}" var="pontuacao">
		<tr> 
		<td>${pontuacao.codigo}</td>
		<td>${pontuacao.piloto.nome}</td>
		<td>${pontuacao.equipe.descricao}</td>
		<td>${pontuacao.gp.descricao}</td>
		<td>${pontuacao.pontos}</td>
		<td>	
		<a href="/formula1/atualizaPontuacao?codigo=${pontuacao.codigo}">
		Editar
		</a>
		</td>		
		
		<td>
		<a href="/formula1/removePontuacao?codigo=${pontuacao.codigo}">
		Remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>
</div>
	</div>
	</div>
	<footer class="text-muted text-center bg-dark p-3">
		<div class="container">
			<p>Desenvolvido por: Leandro Peralta
            <br>Professor: Jeferson Velasques Rodrigues
            <br>Instituto Federal de Mato Grosso do Sul - 2019</p>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>