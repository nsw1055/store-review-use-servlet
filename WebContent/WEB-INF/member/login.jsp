<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header1.jsp"%>
<title>login</title>
<%@include file="../includes/header2.jsp"%>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">login</h1>

<form class="form-horizontal" action="/member/login" method="post">
	<div class="form-group">
		<label class="control-label col-sm-2" for="name">ID</label>
		<div class="col-sm-10">
			<input type="text" name="mid" class="form-control" id="mid">

		</div>
		
			<label class="control-label col-sm-2" for="name">PWD</label>
		<div class="col-sm-10">
			<input name="mpw" type="password" class="form-control" placeholder="비밀번호를 입력하세요" />
		</div>
		<div class="col-sm-10">
			<input type="hidden" name="refefer" class="form-control"
				value="${referer}">
		</div>
		
		</div>
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary" type="button">로그인</button>
		</div>
</form>



<%@include file="../includes/footer.jsp"%>