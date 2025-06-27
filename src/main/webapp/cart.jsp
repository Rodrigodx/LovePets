<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/cart.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />
</head>
<body>

	<header>
		<%@ include file="simple_header.jsp"%>
	</header>


	<section>
		<div class="cart">
			<ul class="list-group">
				<li class="list-group-item products">
					<div class="card">
						<img src="" class="card-image-top" alt="teste">
						<div class="card-body">
							<h5 class="card-title">name</h5>
							<p class="fw-bold">R$ price</p>
						</div>
						<div class="actions">
							<a class="btn btn-sm btn-decre" href=""><i
								class="fas fa-minus-square"></i></a> <input type="text"
								name="quantity" class="quantity" value="1" min="1" readonly>
							<a class="btn btn-sm btn-incre" href=""><i
								class="fas fa-plus-square"></i></a>
						</div>
						<div class="delete">
							<input type="button" name="btn-del" class="btn-del" value="Deletar">
						</div>
					</div>
				</li>
			</ul>
			<div class="total-value">
				<p>Total R$ 000000</p>
				<input type="button" name="btn-push" class="btn-push" value="Comprar">
				<a class="btn" href="Inicial.jsp">Buscar mais produtos</a>
			</div>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>