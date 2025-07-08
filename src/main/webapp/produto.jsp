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
		<div class="ms-3 div-info">
			<p>${produto.name}</p>
			<p>R$ ${produto.price}</p>
			<div class="add-to-cart">
				<div class="wrapper">
					<a class="btn btn-sm btn-decre" href=""><i class="fas fa-minus-square"></i></a>
					<input type="text" name="quantity" class="quantity" value="1" min="1" readonly>
					<a class="btn btn-sm btn-incre" href=""><i class="fas fa-plus-square"></i></a>
				</div>
				<a class="btn-add-to-cart" href="CartServlet?id=${produto.getId()}">Adicionar ao carrinho</a>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>