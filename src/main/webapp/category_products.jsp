<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="./css/category_products.css">
</head>
<body>

	<header>
		<%@ include file="header.jsp"%>
	</header>

	<c:set value="${param.category}" var="category" />

	<h2 class="tipo-produtos">
		<c:choose>
			<c:when test="${category eq 1}">
				<c:out value="VERMÍFUGOS" />
			</c:when>
			<c:when test="${category eq 2}">
				<c:out value="MEDICAMENTOS" />
			</c:when>
			<c:when test="${category eq 3}">
				<c:out value="ANTIPULGAS" />
			</c:when>
		</c:choose>
	</h2>


	<div class="row lista-produtos">
		<c:forEach var="p" items="${produtos}">
			<div class="card">
				<img src="${p.pathImage}" class="card-image-top" alt="${p.name}">
				<div class="card-body">
					<h5 class="card-title">${p.name}</h5>
					<p class="fw-bold">R$ ${p.price}</p>
					<a href="ServletProduct?id=${p.id}" class="btn btn-primary">Comprar</a>
				</div>
			</div>
		</c:forEach>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>