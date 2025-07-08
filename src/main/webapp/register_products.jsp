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
<link rel="stylesheet" type="text/css" href="./css/register_products.css">
</head>
<body>

	<header>
		<jsp:include page="simple_header.jsp"></jsp:include>	
	</header>

	<div class="card shadow p-4 form">
		<form action="<%=request.getContextPath()%>/ServletProduct"
			method="post" enctype="multipart/form-data">
			<div class="form-group inputs">
				<label for="exampleInputName1">Nome</label> <input type="text"
					class="form-control" id="exampleInputName1" name="name"
					aria-describedby="nameHelp" placeholder="Digite o nome">
			</div>
			<div class="col-auto inputs">
				<label class="sr-only" for="inlineFormInputGroup">Preço</label>
				<div class="input-group mb-2">
					<div class="input-group-prepend">
						<div class="input-group-text">R$</div>
					</div>
					<input type="text" class="form-control" id="inlineFormInputGroup"
						placeholder="Preço" name="price">
				</div>
			</div>
			<div class="form-group inputs">
				<label for="exampleInputEmail1">Categoria</label> <input type="text"
					class="form-control" id="exampleInputName1" name="category"
					aria-describedby="nameHelp" placeholder="Digite a categoria do produto">
			</div>
			<div class="form-group inputs">
				<label for="exampleFormControlFile1">Selecione uma imagem</label> <input
					type="file" accept="image/*" class="form-control-file"
					id="fileImage" name="image">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar produto</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>