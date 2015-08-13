<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Setores</title>

<style type="text/css">
	<%@include file="/css/form_cadastro.css"%>
</style>

<script language="javascript">
function verifica(){
        	alert("Gestor cadastrado com sucesso!");
  }
</script>
</head>

<body>

<c:import url="/WEB-INF/view/menu/menu_principal.jsp"/>

<div class="divPrincipal">
<div id="cadastro">
<table align="center">
	<tr>
		<td><img src="imagens/setor.png"> </td>
		<td><h1>Cadastro de Setores</h1></td>
	</tr>
</table>

<fieldset>
<legend>Cadastro de Setores</legend>
<form action="cadastroSetor" name="cadastroSetor">
	<p><label for="sSetor">Setor:</label>
	<input type="text" name="setor" id="sSetor" size="47" placeholder="Setor da Empresa"></p>
	
	<input type="submit" onclick="verifica()" value="Cadastrar Setor">
</form>
</fieldset>
<br>

<a class="botao" href="listaSetor">Listagem de Setor</a>
<a class="botao" href="telaGestao">Voltar Menu Gestão</a>
</div>
</div>
<footer >
	Inventário de Microcomputadores 1.1<br>
	Por: Alexsandro Luiz deFaria<br>
	alexsandro.lfaria@gmail.com
</footer>
</body>
</html>