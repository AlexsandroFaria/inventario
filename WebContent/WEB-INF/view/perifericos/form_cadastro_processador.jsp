<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Processadores</title>

<style type="text/css">
	<%@include file="/css/form_cadastro.css"%>
</style>

<script language="javascript">
function verifica(){
        	alert("Memória cadastrada com sucesso!");
  }
</script>
</head>

<body>
<c:import url="/WEB-INF/view/menu/menu_principal.jsp"/>

<div class="divPrincipal">
<div id="cadastro">

<table align="center">
	<tr>
		<td><img src="imagens/processador.png"></td>
		<td><h1>Cadastro de Processadores</h1></td>
	</tr>
</table>

<fieldset>
<legend>Cadastro de Processador</legend>
<form action="cadastroProcessador" name="cadastroProcessador">
	<p><label for="iProcessador">Processador:</label>
	<input type="text" name="processador" id="iProcessador" placeholder="Processador" size="47"></p>
	
	<input type="submit" onclick="verifica()" value="Cadastrar Processador">
</form>
</fieldset>
<br>
<a class="botao" href="listaProcessador">Lista de Processadores</a>
<a class="botao" href="telaPerifericos">Voltar Menu Periféricos</a>
</div>
</div>
<footer>
	Inventário de Microcomputadores 1.1<br>
	Por: Alexsandro Luiz deFaria<br>
	alexsandro.lfaria@gmail.com
</footer>
</body>
</html>