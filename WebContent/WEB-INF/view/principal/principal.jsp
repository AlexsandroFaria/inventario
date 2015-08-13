<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
	<%@include file="/css/tela_principal.css"%>
</style>

<c:import url="/WEB-INF/view/menu/menu_principal.jsp"/>

</head>
<body>

<div class="divPrincipal">
<div class="padrao">
	<article>
		<h1 class="hprincipal">Controle de Hardware</h1>
		<img src="imagens/hardware.png">
		<p>Controle total de hardware, podendo com isso montar qualquer tipo de microcomputador
		em cliques b�sicos.</p>
		
		<p>Com a tela de relat�rio  de invent�rio, � poss�vel visualizar todos os micros e ter controle sobre usu�ios associados ao mesmo.</p>
		<a class="botao" href="listaInventario">Ver Invent�rio</a>
		<div class="clear"></div>
	</article>
</div>

<div class="padrao">
	<article>
		<h1 class="hprincipal">Controle de Gestores e Usu�rios</h1>
		<img src="imagens/gestores.png">
		<p>Al�m de controlar o tipo de hardware e efetuar Invent�rio de microcomputadores, � poss�vel Gerir os Gestores
		e Colaboradores por setor.</p>
		<p>Listas de conrole de Gestores e colaboradores. O invent�rio fica integrado ao Gestor do setor e ao Colaborador que opera
		o mocrocomputador inventariado.</p>
		<a class="botao" href="listaGestor">Listagem de Gestores</a>
		<a class="botao" href="listaColaborador">Listagem de Colaboradores</a>
		<div class="clear"></div>
	</article>
</div>
</div>
<footer>
	Invent�rio de Microcomputadores 1.1<br>
	Por: Alexsandro Luiz deFaria<br>
	alexsandro.lfaria@gmail.com
</footer>

</body>
</html>