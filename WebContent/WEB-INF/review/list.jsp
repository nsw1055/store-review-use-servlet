<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header1.jsp"%>
<title>${store.name}</title>
<%@include file="../includes/header2.jsp"%>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">${store.name}</h1>
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
<form class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-sm-2" for="name">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name"
				value='${store.name}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="lat">Address</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="lat"
				value='${store.address}' readonly="readonly">
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="lat">LAT</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="lat" value='${store.lat}'
				readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="lng">LNG</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="lng" value='${store.lng}'
				readonly="readonly">
		</div>
	</div>
</form>
<div class="d-grid gap-2">
	<button class="btn btn-primary" type="button"
		onclick="location.href = '/review/register?sno=${store.sno}'">register</button>
</div>

 <ul>
 <select
	onChange="self.location='/review/list?sno=${store.sno}&page=1&perSheet='+this.value">
	<option value="3" ${pageMaker.pageInfo.perSheet ==3? "selected":"" }>3개씩 보기</option>
	<option value="5" ${pageMaker.pageInfo.perSheet ==5? "selected":"" }>5개씩 보기</option>
</select>
</ul>
<c:forEach items="${review}" var="review">
	<div class="card mb-3" style="max-width: 100%;">
		<div class="row g-0">
			<div class="col-md-4">
				<img src="http://192.168.0.138:8080/fileView?name=${review.img}"
					style="width: 100%; height: 200px; object-fit: cover;" alt="...">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">${review.context}</h5>
					<p class="card-text">
						<small class="text-muted">${review.regdate}</small>
					</p>
					<form action="/review/like" method="post">
					<input type="hidden" name="rno" value="${review.rno}"> <input
						type="hidden" name="mid" value="${mid }">
						<button type="submit" class="btn btn-primary">좋아요</button>
				</form>
				</div>
				<div>
				<c:if test= "${mid == review.mid}">	
				<a href="/review/modify?rno=${review.rno }"><button type="button" class="btn btn-primary">수정</button></a>
					<form action="/review/delete" method="post">
					<input type="hidden" name="sno" value="${review.sno}"> 
					<input type="hidden" name="rno" value="${review.rno}"> 
					<input type="hidden" name="mid" value="${mid }">
					<button type="submit" class="btn btn-danger" >삭제</button>
					</form>
				</c:if>
				</div>
			</div>

		</div>

	</div>
</c:forEach>
<ul class="pagination">
	<c:if test="${pageMaker.prev}">
		<li class="page-item"><a class="page-link"
			href="/review/list?sno=${store.sno}&page=${pageMaker.pageInfo.page-1}&perSheet=${pageMaker.pageInfo.perSheet}">Pre</a></li>
	</c:if>

	<c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
		<li
			class="page-item ${num == pageMaker.pageInfo.page? 'active' : '' }"><a
			class="page-link" href="/review/list?sno=${store.sno}&page=${num}&perSheet=${pageMaker.pageInfo.perSheet}">${num}</a></li>
	</c:forEach>

	<c:if test="${pageMaker.next}">
		<li class="page-item"><a class="page-link"
			href="/review/list?sno=${store.sno}&page=${pageMaker.pageInfo.page+1}&perSheet=${pageMaker.pageInfo.perSheet}">Next</a></li>
	</c:if>
</ul>



<%@include file="../includes/footer.jsp"%>