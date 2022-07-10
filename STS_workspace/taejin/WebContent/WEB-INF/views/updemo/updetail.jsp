<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../temp/header.jsp"%>


<article>
	<header>
		<h1>UpBoard Demo</h1>
	</header>
	<ul class="list-unstyled">
		<li class="border-top my-3"></li>
	</ul>
	<div>
		<div class="form-group">
			<label for="sub">제목</label>
			<!-- placeholder 속성 입력한 데이터가 없는 경우 배경으로 나타난다.실제적으로 입력을 100자까지로 지정 -->
			<!-- required 속성을 설정하면 필수입력 사항이된다. -->
			<!-- pattern 속성을 이용한 정규표현식으로 데이터의 유효성 검사를 할 수 있다. -->
			<input type="text" class="form-control" id="sub" value="${uvo.sub }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="cont">내용</label>
			<!--  여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다. -->
			<!--  textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter -->
			<textarea class="form-control" rows="5" id="cont" name="cont"
				readonly="readonly">${uvo.cont }</textarea>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label> <input type="text"
				class="form-control" id="writer" name="writer" value="${uvo.writer }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="udate">작성날짜</label> <input type="text"
				class="form-control" id="bdate" name="udate" value="${uvo.udate }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="imgn">이미지</label>
			<div><img style="width: 200px;" src="${pageContext.request.contextPath}/resources/imgfile/${uvo.imgn}"></div>
		</div>
		<div class="form-group" style="text-align: right; margin-top: 10px;">
			<button type="button" class="btn btn-primary" id="ubtn">목록으로</button>
		</div>
	</div>

</article>

<%@include file="../temp/footer.jsp"%>