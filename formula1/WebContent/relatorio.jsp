<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.empresa.model.Pontuacao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<title>Listagens</title>
</head>
<body>
	<div align="center">
		<form method="get" action="relProduto">
			<fieldset>
				<legend>Listagens</legend>
				<label>Ação</label> <select name="acao" required>
					<option selected value="list1">Listagem Ranking Geral</option>
					<option value="list2">Listagem 1</option>
					<option value="list3">Listagem 2</option>
					<option value="list4">Listagem 3</option>
					<option value="list5">Listagem 4</option>
				</select><br /> <input type="submit" value="Enviar"> <input
					type="reset" value="Limpar"> <br />
			</fieldset>
		</form>
	</div>
</body>
</html>