<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Memória Ram</title>

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
		<td><img src="imagens/ram.png"></td>
		<td><h1>Cadastro Memória Ram</h1></td>
	</tr>
</table>

<fieldset>
<legend>Cadastro de Memória Ram</legend>
<form action="cadastroMemoriaRam" name="cadastroMemoriaRam">
	<p><label for="iQuantidade">Quantidade: </label>
	<input type="text" name="quantidade" id="iQuantidade" size="47" placeholder="Quantidade de Memória instalada"></p>
	
	<p><label for="iTamanho">Tamanho:</label>
	<input type="text" name="tamanho" id="iTamanho" size="47" placeholder="Tamanho da Memória"></p>
	
	<input type="submit" onclick="verifica()" value="Cadastrar Memória Ram"><br>
</form>
</fieldset>
<br>
<a class="botao" href="listaMemoriaRam">Lista de Memórias</a>
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