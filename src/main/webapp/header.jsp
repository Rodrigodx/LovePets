<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/header.css">
</head>

<body>
		<nav class="navbar bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img
					src="/docs/5.2/assets/brand/bootstrap-logo.svg" alt="Logo"
					width="30" height="24" class="d-inline-block align-text-top">
					Bootstrap
				</a>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				<span> <a class="nav-link" href="login.jsp"> Entre ou
						Cadastre-se </a>
				</span>
			</div>
		</nav>

		<nav class="navbar bg-light links">
			<div class="container-fluid">
				<ul class="nav nav-pills">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="#" role="button" aria-expanded="false">Farmacia</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="ServletProduct?category=1">Vermifugos</a></li>
							<li><a class="dropdown-item" href="ServletProduct?category=2">Medicamentos</a></li>
							<li><a class="dropdown-item" href="ServletProduct?category=3">Antipulgas e
									carrapatos</a></li>
						</ul>
					<li class="nav-item"><a class="nav-link" href="#">Gatos</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Cachorros</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
						href="#" role="button" aria-expanded="false">Outros</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Contatos</a></li>
							<li><a class="dropdown-item" href="#">Serviços</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
</body>
</html>