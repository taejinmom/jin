<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>

<article>
	<header>
		<h1>FileUpLoad Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div class="container">
		<%-- boardForm 들어갈 자리 --%>
		<fieldset>
			<legend>이미지 업로드 폼</legend>
			<%-- action은 UploadDemoController @PostMapping(value = "/이곳의 이름과 동일해야 한다.") --%>
			<form method="post" action="uploadpro" enctype="multipart/form-data"
				id="upform">
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">제 목</label>
					<div class="col-sm-10">
						<input type="text" name="sub" id="sub" placeholder="제목을 입력하세요." />
					</div>
					<span id="target"></span>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">작성자</label> <input
						type="text" name="writer" id="writer" />
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">비밀번호</label> <input
						type="password" name="pwd" id="pwd" />
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">이미지 내용</label>
					<textarea name="cont" id="cont" rows="10" cols="13"></textarea>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">* 이미지 업로드</label>
					<div class="col-sm-10"><input type="file" name="mfile" id="mfile"/></div>
					<div class="col-sm-10"><img src="${pageContext.request.contextPath}/resources/image/noimage.jpg" id="imgx"></div>
				</div>
				<div class="row mb-3">
					<div class="col-sm-10"><input type="submit" value="등록" id="btn1" class="btn btn-info"/>
					<input type="button" value="등록" id="btn2" class="btn btn-danger"/>
					</div>
				</div>
			</form>
		</fieldset>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>