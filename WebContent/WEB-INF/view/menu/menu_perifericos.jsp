<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Perif�ricos</title>

<style type="text/css">
	<%@include file="/css/sub_menu.css"%>
</style>

</head>
<body>

<c:import url="/WEB-INF/view/menu/menu_principal.jsp"/>

<div class="divPrincipal">
<div align="center">
<h1>Cadastro de Perif�ricos</h1>

	<nav id="principal">
		
			<a class="botao" href="telaCadastroRam">Mem�ria Ram</a>
			<a class="botao" href="telaCadastroSo">Sistema Operacional</a>
			<a class="botao" href="telaCadastroProcessador">Processador</a>
		
	</nav>
</div>
</div>

<footer >
	Invent�rio de Microcomputadores 1.1<br>
	Por: Alexsandro Luiz deFaria<br>
	alexsandro.lfaria@gmail.com
</footer>
</body>
</html>