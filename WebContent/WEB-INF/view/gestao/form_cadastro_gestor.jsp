<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.inventario.model.*"%>
<%@page import="br.com.inventario.dao.*"%>
<%@page import="java.util.*"%>          
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Gestor</title>

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
		<td><img src="imagens/gestor.png"> </td>
		<td><h1>Cadastro de Gestores</h1></td>
	</tr>
</table>

<fieldset>
<legend>Cadastro de Gestores</legend>
<form action="cadastroGestor" name="cadastroGestor">
	<p><label for="iNome">Nome:</label>
	<input type="text" name="nome" id="iNome" size="47" placeholder="Nome do Gestor"></p>
	
	<p><label for="sSetor">Setor:</label>
	<select name="setor" id="sSetor" style="width: 300px">
		<option>Selecione o Setor do Gestor</option>
		<%
		SetorDAO setorDao = new SetorDAO();
		List<Setor>setores = setorDao.getLista();
		for (Setor setor : setores){
		%>
		<option><%=setor.getSetor() %> </option>
		<%
		}
		%>
	</select></p>
	
	<input type="submit" onclick="verifica()" value="Cadastrar Gestor"> 
</form>
</fieldset>
<br>

<a class="botao" href="listaGestor">Listagem de Gestores</a>
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