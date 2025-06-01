<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<button class="plusminus" onclick="changeQuantity('minus')">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"
							width="14.5">
												<path fill="#007dc5"
								d="M400 288h-352c-17.69 0-32-14.32-32-32.01s14.31-31.99 32-31.99h352c17.69 0 32 14.3 32 31.99S417.7 288 400 288z"></path>
											</svg>
					</button>
					<input value="1" id="qty" data-handle="quantityProduct" class="qty"
						type="number" pattern="[0-9]*" min="1"
						onchange="changeQuantity();">
					<button class="plusminus" onclick="changeQuantity('plus')">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"
							width="14.5">
												<path fill="#007dc5"
								d="M432 256c0 17.69-14.33 32.01-32 32.01H256v144c0 17.69-14.33 31.99-32 31.99s-32-14.3-32-31.99v-144H48c-17.67 0-32-14.32-32-32.01s14.33-31.99 32-31.99H192v-144c0-17.69 14.33-32.01 32-32.01s32 14.32 32 32.01v144h144C417.7 224 432 238.3 432 256z"></path>
											</svg>
					</button>
				</div>
				<button class="btn-add-to-cart">Adicionar ao carrinho</button>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>