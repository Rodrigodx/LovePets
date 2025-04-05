<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<%@ include file="header.jsp"%>
	</header>
	
	<div class="row">
		<c:forEach var = "p" items="${products}">
			<div class="col-md-4 mb-4">
				<div class="card" style="width: 18rem;">
					<img src="${p.pathImage}" class="card-image-top" alt="${p.name}">
					<div class="card-body">
						<h5 class="card-title">${p.name}</h5>
						<p class="fw-bold">R$ ${p.price}</p>
						<a href="ServletProduct?id=${p.id}" class="btn btn-primary">Comprar</a>
					</div>
				</div>
			</div>
	</div>

	<div class="card" style="width: 18rem;">
		<img src="..." class="card-img-top" alt="...">
		<div class="card-body">
			<h5 class="card-title">Name Product</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
			<p>R$ price</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>