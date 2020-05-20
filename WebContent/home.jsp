<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%
	//Set standard HTTP/1.1 no-cache headers.
	response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
	
	//Set standard HTTP/1.0 no-cache header.
	response.setHeader("Pragma", "no-cache");
	
    response.setDateHeader("Expires", -1);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  Adicionar uma verificação! -->
	<c:if test="${ empty usuario.nome }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<p>Área restrita!</p>
	<p>Olá, ${ usuario.nome }!</p>
	<form action="Controller.do">
		<input type="hidden" name="command" value="LogoffUsuario">
		<input type="submit" value="Logoff">
	</form>
</body>
</html>