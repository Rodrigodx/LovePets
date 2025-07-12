<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/orders.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />
</head>
<body>

	<header>
		<%@ include file="header.jsp"%>
	</header>

	<section>
	
		<h2>
			Minhas compras
		</h2>
	
		<div class="orders">
			<ul class="list-group group_products">
				<li class="list-group-item products">
						<c:forEach var="o" items="${order_list}">
							<div class="card">						
								<div class="order-card-header">
									<p class="">
										<b>N° do pedido:</b>
										<strong class="order-number">${o.orderId}</strong>
									</p>
									<div class="divisão"> | </div>
									<p class="">
										<b>Data do pedido:</b>
										<strong class="order-date">${o.date}</strong>
									</p>
								</div>
								<div class="order-card">
									<img src="${o.pathImage}" class="card-image-top" alt="${o.name}">
									<div class="card-body">
										<h5 class="card-title"> ${o.name}</h5>
										<p class="fw-bold">R$ ${o.price}</p>
									</div>
										<input type="hidden" name="id" value="${o.id}" class="form-input">
								</div>
							</div>
						</c:forEach>
				</li>
			</ul>
		</div>
	</section>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>