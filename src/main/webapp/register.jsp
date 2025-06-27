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
<link rel="stylesheet" type="text/css" href="./css/register.css">
</head>
<body>

	<header>
		<jsp:include page="simple_header.jsp"></jsp:include>
	</header>

	<div class="card shadow p-4 form">
		<form action="<%= request.getContextPath() %>/register" method="post">
			<div class="mb-3 inputs">
				<label for="exampleInputName1" class="form-label">Nome</label>
				<input type="text" class="form-control"
					id="exampleInputName" name="name" placeholder="Digite seu nome">
			</div>
	
			<div class="mb-3 inputs">
				<label for="exampleInputEmail1" class="form-label">E-mail </label> <input
					type="email" class="form-control" id="exampleInputEmail1" name="email"
					aria-describedby="emailHelp" placeholder="Digite seu e-mail">
			</div>
			<div class="mb-3 inputs">
				<label for="exampleInputPassword1" class="form-label">Senha</label>
				<input type="password" class="form-control"
					id="exampleInputPassword1" name="password" placeholder="Digite sua senha">
			</div>
			<div class="mb-3 inputs">
				<label for="exampleInputPassword2" class="form-label">Confirme a senha</label>
				<input type="password" class="form-control"
					id="exampleInputPassword2" name="password2" placeholder="Digite sua senha">
			</div>
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form>
	</div>		
		
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
	</script>
</body>
</html>