<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<c:set var="mycontext" value="${pageContext.request.contextPath}"/>   
<c:set var="imgUrl" value="${pageContext.request.contextPath}/resources/image"/>   
<div id="demo" class="carousel slide" data-bs-ride="carousel">
  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${imgUrl}/bg1.jpg" alt="Kosmo113" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3>UI �䱸���� Ȯ���ϱ�,UI �����ϱ� </h3>
        <p><c:if test="${sessionScope.sessionName != null}">${sessionScope.sessionName}��</c:if>jQuery �� �̿��Ͽ� �������� �������Ͽ��� �Ʒ� �䱸���״�� �����մϴ�.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="${imgUrl}/bg2.jpg" alt="Carousel" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3><c:if test="${sessionScope.sessionName != null}">${sessionScope.sessionName}��</c:if> �ݰ�����~</h3>
        <p><c:if test="${sessionScope.sessionName != null}">${sessionScope.sessionName}��</c:if>  Thank you, CSS3!</p>
      </div> 
    </div>
    <div class="carousel-item">
      <img src="${imgUrl}/bg3.jpg" alt="JSP" class="d-block" style="width:100%">
      <div class="carousel-caption">
        <h3><c:if test="${sessionScope.sessionName != null}">${sessionScope.sessionName}��</c:if> UI �䱸���� Ȯ���ϱ�,UI �����ϱ� </h3>
        <p>jQuery �� �̿��Ͽ� �������� �������Ͽ��� �Ʒ� �䱸���״�� �����մϴ�.</p>
      </div>  
    </div>
  </div>
  
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>  