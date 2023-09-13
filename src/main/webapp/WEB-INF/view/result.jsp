<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Pokemon" %>
<% Pokemon pokemon = (Pokemon)request.getAttribute("pokemon"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PokeApiを試そう！！</title>
</head>
<body>
	<% if(pokemon != null){ %>
		<h1><%=pokemon.getName() %></h1>
		<div><img src="<%=pokemon.getSprite() %>"></div>
		<h2>図鑑番号:<%=pokemon.getId() %></h2>
		<div>
			高さ:<%=pokemon.getHeight() %>m<br>
			体重:<%=pokemon.getWeight() %>kg
		</div>
		<p>
			【説明】<br>
			<%=pokemon.getText() %>
		</p>
	<% } %>
	<a href="Main">戻る</a>
</body>
</html>