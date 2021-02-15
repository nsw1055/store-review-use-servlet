<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header1.jsp" %>
<title>store list</title>
<%@include file="../includes/header2.jsp" %>

 <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Store List Page</h1>
<c:choose>
	<c:when test="${mid==null }">
		<form action="/member/login" method="get">
			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-primary" type="button">로그인</button>
			</div>
		</form>
	</c:when>
	<c:when test="${mid!=null }">
		<form action="/member/logout" method="get">
			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-primary" type="button">로그아웃</button>
			</div>
		</form>
	</c:when>
</c:choose>



<c:forEach items="${stores}" var="store"> 
<div class="card mb-3" style="max-width: 100%;">
  <div class="row g-0">
    <div class="col-md-4">
    <a href='/review/list?sno=${store.sno}'>
      <img src="/upload/store/${store.sno}.jpg" style = "width: 100%; height: 200px; object-fit: cover;"  alt="...">
    </a>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${store.name}</h5>
        <p class="card-text">${store.address}</p>
        <p class="card-text"><small class="text-muted">${store.updateDate}</small></p>
         <p class="card-text"><small class="text-muted">리뷰수 : ${store.rcount}</small></p>
      </div>
    </div>
  </div>
</div>
 </c:forEach>
 
 <ul class="pagination">
 	<c:if test="${pageMaker.prev}">
    <li class="page-item"><a class="page-link" href="/store/list?page=${pageMaker.pageInfo.page-1}">Pre</a></li>
 	</c:if>
   
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">    
    <li class="page-item ${num == pageMaker.pageInfo.page? 'active' : '' }"><a class="page-link" href="/store/list?page=${num}">${num}</a></li> 
    </c:forEach>
    
    <c:if test="${pageMaker.next}">
    <li class="page-item"><a class="page-link" href="/store/list?page=${pageMaker.pageInfo.page+1}">Next</a></li>
    </c:if>
  </ul>



<%@include file="../includes/footer.jsp" %>