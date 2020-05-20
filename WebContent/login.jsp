<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/ProjetoLogin/css/estilo.css">
</head>
<body>

	<h1>Login</h1>
	
	<c:out value="${ requestScope.mensagem }"></c:out>
	<a href="/ProjetoLogin/cadastro.jsp">Cadastro</a>
	
	<form action="Controller.do" method="post">
		E-mail: <input type="email" name="email_usuario"> 
		Senha: <input type="password" name="senha_usuario">
		<input type="hidden" name="command" value="LoginUsuario">
		<input type="submit">
	</form>
</body>
</html>