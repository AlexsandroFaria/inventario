<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Sistema Operacional</title>

<script language="javascript">
function verifica(){
        	alert("Sistema Operacional cadastrado com sucesso!");
  		}	
</script>

<style type="text/css">
	<%@include file="/css/form_cadastro.css"%>
</style>

</head>
<body>

<c:import url="/WEB-INF/view/menu/menu_principal.jsp"/>

<div class="divPrincipal">
<div id="cadastro">
<table align="center">
	<tr>
		<td><img src="imagens/so.png"></td>
		<td><h1>Cadastro de Sistema Operacional</h1></td>
	</tr>
</table>

<fieldset>
<legend>Cadastro de Sistema Operacional</legend>
<form action="cadastroSistemaOperacional" name="cadastroSistemaOperacional">
	<p><label for="iSistemaOperacional">Sistema Operacional: </label>
	<input type="text" name="sistemaOperacional" id="iSistemaOperacional" size="47" placeholder="Sistema Operacional"></p>
	
	<input type="submit" onclick="verifica()" value="Cadastrar Sistema Operacional">
</form>
</fieldset>
<br>
<a class="botao" href="listaSistemaOperacional">Lista de Sistemas Operacionais</a>
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