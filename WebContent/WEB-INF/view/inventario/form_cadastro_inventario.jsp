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
<title>Cadastro Inventario</title>

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
		<td><img src="imagens/computador.png"> </td>
		<td><h1>Inventário de Microcomputador</h1></td>
	</tr>
</table>

<fieldset>
<legend>Inventário</legend>
<form action="cadastroInventario">
	
	<P><label for="iModelo" >Modelo:</label>
	<input type="text" name="modelo" placeholder="Modelo do Microcomputador" size="47" id="iModelo"></P>
	
	<p><label for="sMRam">Memória Ram:</label>
	<select name="ram" id="sMRam" style="width: 300px">
		<option>Selecione a Memória Ram</option>
		<%
			MemoriaRamDAO dao = new MemoriaRamDAO();
			List<MemoriaRam>memoriasRam = dao.getLista();
			for (MemoriaRam memoriaRam : memoriasRam){
		%>		
		<option><%=memoriaRam.getTamanho()%></option>
		<%
			}
		%>
	</select></p>
	
	<p><label for="sSOperacional">Sistema Operacional:</label>
	<select name="so" id="sSOperacional" style="width: 300px">
		<option>Selecione o Sistema Operacional</option>
		<%
			SistemaOperacionalDAO sod = new SistemaOperacionalDAO();
			List<SistemaOperacional>sistemasOperacionais = sod.getLista();
			for (SistemaOperacional so : sistemasOperacionais){
		%>		
		<option><%=so.getSistemaOperacional()%></option>
		<%
			}
		%>
	</select></p>
	
	<p><label for="sProcessador">Processador:</label>
	<select name="processador" id="sProcessador" style="width: 300px">
		<option>Selecione o Processador</option>
		<%
			ProcessadorDAO procd = new ProcessadorDAO();
			List<Processador>processadores = procd.getLista();
			for (Processador processador : processadores){
		%>		
		<option><%=processador.getProcessador()%></option>
		<%
			}
		%>
	</select></p>
	
	<p><label for="sGestor">Gestor:</label>
	<select name="gestor" id="sGestor" style="width: 300px">
		<option>Selecione o Gestor</option>
		<%
			GestorDAO gestord = new GestorDAO();
			List<Gestor>gestores = gestord.getLista();
			for (Gestor gestor : gestores){
		%>		
		<option><%=gestor.getNome()%></option>
		<%
			}
		%>
	</select></p>
	
	<p><label for="sColaborador">Colaborador:</label>
	<select name="colaborador" id="sColaborador" style="width: 300px">
		<option>Selecione o Colaborador</option>
		<%
			ColaboradorDAO colaboradord = new ColaboradorDAO();
			List<Colaborador>colaboradores = colaboradord.getLista();
			for (Colaborador colaborador : colaboradores){
		%>		
		<option><%=colaborador.getNome()%></option>
		<%
			}
		%>
	</select><br></p>
	
	<input type="submit" onclick="verifica()" value="Cadastrar Inventário">
	
</form>
</fieldset>
<br>
<a class="botao" href="listaInventario">Listagem de Inventário</a>

</div>
</div>
<footer>
	Inventário de Microcomputadores 1.1<br>
	Por: Alexsandro Luiz deFaria<br>
	alexsandro.lfaria@gmail.com
</footer>
</body>
</html>