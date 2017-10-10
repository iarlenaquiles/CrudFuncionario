<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>
<h1>Contatos</h1>
<c:forEach items="${contatos}" var="contato" >
	<p>Nome: ${contato.nome} - Email: ${contato.email}</p>
</c:forEach>
</body>
</html>