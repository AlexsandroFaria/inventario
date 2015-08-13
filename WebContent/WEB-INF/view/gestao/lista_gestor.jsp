<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem de Gestores</title>

<style type="text/css">
	<%@include file="/css/listas.css"%>
</style>

<script language="JavaScript">  
  function confirmaExclusao() {  
    if (confirm("Deseja realmente excluir?"))  
      return true;  
    else  
      return false;  
  }  
</script> 

</head>
<body>

<c:import url="/WEB-INF/view/menu/menu_principal.jsp"/>

<div class="divPrincipal">
<div id="lista">
<table align="center">
	<tr>
		<td><img src="imagens/gestor.png"> </td>
		<td><h1>Listagem de Gestores</h1></td>
	</tr>
</table>

<table id="tabelalista">
	<tr>
		<th>Identificador</th>
		<th>Nome</th>
		<th>Setor</th>
		<th>Excluir</th>
	</tr>
	
	<c:forEach items="${gestores}" var="gestor">
		<tr>
			<td>${gestor.idGestor}</td>
			<td>${gestor.nome}</td>
			<td>${gestor.setor}</td>
			<td><a href="excluirGestor?idGestor=${gestor.idGestor}" onclick="return confirmaExclusao()">Excluir</a> </td>
		</tr>
	</c:forEach>
	
</table><br>

<a class="botao" href="telaCadastroGestor">Voltar</a>
</div>
</div>
<footer >
	Inventário de Microcomputadores 1.1<br>
	Por: Alexsandro Luiz deFaria<br>
	alexsandro.lfaria@gmail.com
</footer>
</body>
</html>