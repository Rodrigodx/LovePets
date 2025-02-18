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
</head>
<body>

	<form action="<%= request.getContextPath() %>\product_register" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Nome</label> <input type="text"
				class="form-control" id="exampleInputName1" name="name"
				aria-describedby="nameHelp" placeholder="Digite o nome">
		</div>
		<div class="col-auto">
			<label class="sr-only" for="inlineFormInputGroup">Price</label>
			<div class="input-group mb-2">
				<div class="input-group-prepend">
					<div class="input-group-text">R$</div>
				</div>
				<input type="text" class="form-control" id="inlineFormInputGroup"
					placeholder="Price" name="price">
			</div>
		</div>
		<div class="form-group">
			<label for="exampleFormControlFile1">Selecione uma imagem</label> <input
				type="file" class="form-control-file" id="exampleFormControlFile1">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>