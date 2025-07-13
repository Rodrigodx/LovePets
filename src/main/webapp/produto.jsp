<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="./css/produto.css">
</head>
<body>
	<header>
		<%@ include file="header.jsp"%>
	</header>
	<div class="div-section">
		<div class="flex-shrink-0 div-image">
			<img src="${produto.pathImage}" alt="..." class="image">
		</div>
		<div class="card">
			<h1 class="name">${produto.name}</h1>
			<p class="fw-bold price">R$ ${produto.price}</p>
			<div class="add-to-cart">
				<a class="mx-3 btn btn-primary btn-add-to-cart" href="CartServlet?id=${produto.getId()}">Adicionar ao carrinho</a>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>