<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/login.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>

	<header>
		<%@ include file="simple_header.jsp" %>
	</header>

	<div class="card shadow p-4 form">

		<form action="<%=request.getContextPath()%>/login" method="post">

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">E-mail </label> <input
					type="email"
					class="form-control <c:if test='${messages.email != null}'>is-invalid</c:if> inputs"
					id="exampleInputEmail1" name="email" aria-describedby="emailHelp"
					placeholder="Digite seu e-mail">
				<c:if test="${messages.email != null}">
					<div class="invalid-feedback">${messages.email}</div>
				</c:if>
			</div>

			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password"
					class="form-control <c:if test='${messages.password != null}'>is-invalid</c:if> inputs"
					id="exampleInputPassword1" name="password" placeholder="Digite sua senha">
				<c:if test="${messages.password != null}">
					<div class="invalid-feedback">${messages.password}</div>
				</c:if>
			</div>

			<input type="hidden" name="from" value="${fn:escapeXml(param.from)}" />

			<c:if test="${messages.login != null}">
				<div class="alert alert-danger" role="alert">
					${messages.login}</div>
			</c:if>

			<button type="submit" class="btn btn-primary">Login</button>

		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous">
		
	</script>
</body>
</html>
