<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>Board Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<%-- boardForm 들어갈 자리 --%>
		<form action="login">
			<div class="form-group">
				<label for="id">id</label> <input type="text" class="form-control" id="id" name="id" placeholder="Email">
			</div>
			<div class="form-group">
				<label for="pwd">Password</label> <input type="password"
					class="form-control" id="pwd" name="pwd" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary">Sign in</button>
		</form>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>