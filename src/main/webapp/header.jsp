<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<nav class="navbar bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="Inicial.jsp"> <img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdAIRPTXaAzFvwOGMBfFnduCsBuAqzbBKpug&https://i.pinimg.com/736x/ca/4a/f2/ca4af20b57850bdc75c69d7da3a1fc25.jpgs" alt="Logo"
				width="60" height="60" class="d-inline-block align-text-top">
			</a>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			<c:if test="${cart_list == null || empty cart_list}">
				<a href="cart.jsp"> 
					<i class="fa fa-shopping-cart" style="font-size: 26px">
						<span class="badge rounded-pill text-bg-danger" style="font-size: 10px; 
						margin-bottom: 10px;"></span>
					</i>
				</a>
			</c:if>
			
			<c:if test="${cart_list.size() != null && not empty cart_list}">
				<a href="ViewCartServlet?id=${cart_list.size()}"> 
					<i class="fa fa-shopping-cart" style="font-size: 26px"> 
						<c:if test="${cart_list.size() >= 1}">
							<span class="badge rounded-pill text-bg-danger" style="font-size: 10px; margin-bottom: 10px;">
									${cart_list.size()} 
							</span>
						</c:if>
					</i>
				</a> 
			</c:if>
			
			<span>
				<c:if test="${user != null}">
					<a class="nav-link" href="LogoutServlet" style="margin-right: 97px">Logout</a>
				</c:if>
				<c:if test="${user == null}">
					<a class="nav-link" href="login.jsp"> Entre ou Cadastre-se</a>
				</c:if> 
			</span>
		</div>
	</nav>

	<nav class="navbar bg-light links">
		<div class="container-fluid">
			<ul class="nav nav-pills">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
					role="button" aria-expanded="false">Farmacia</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="ServletProduct?category=1">Vermifugos</a></li>
						<li><a class="dropdown-item" href="ServletProduct?category=2">Medicamentos</a></li>
						<li><a class="dropdown-item" href="ServletProduct?category=3">Antipulgas
								e carrapatos</a></li>
					</ul>
				<li class="nav-item"><a class="nav-link" href="ServletProduct?category=4">Gatos</a></li>
				<li class="nav-item"><a class="nav-link" href="ServletProduct?category=5">Cachorros</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
					role="button" aria-expanded="false">Outros</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Contatos</a></li>
						<li><a class="dropdown-item" href="#">Serviços</a></li>
						<li><a class="dropdown-item" href="ViewOrdersServlet">Minhas compras</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
</body>
</html>