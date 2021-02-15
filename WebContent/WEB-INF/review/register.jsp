<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header1.jsp"%>
<title>${store.name} review</title>
<%@include file="../includes/header2.jsp"%>
<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Register Page</h1>

<form class="form-horizontal" action = "/review/register" method = "post" accept-charset="utf-8" enctype="multipart/form-data">
	<div class="form-group">
		<div class="col-sm-10" >
			<input name = "sno" type="hidden" class="form-control" id="sno" value="${store.sno }" readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10" >
			<input name = "mid" type="hidden" class="form-control" id="mid" value = "${mid}" readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="lat">CONTEXT:</label>
		<div class="col-sm-10" >
			<textarea rows = 10 name = "context"  type="text" class="form-control" id="context"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="lng">SCORE:</label>
			<select class="form-control" id="exampleFormControlSelect1" name="score">
				<option>5</option>
				<option>4</option>
				<option>3</option>
				<option>2</option>
				<option>1</option>
			</select>
	</div>
	
	<div class="col-sm-10" >
		<label class="control-label col-sm-2" for="menu">IMG:</label>
		
			<input name = "img"  type="file" class="form-control" id="file"  multiple="multiple">
	</div>
	<div class="form-group">
		<div class="col-sm-10" >
			<input name = "referer"  type="hidden" class="form-control" id="referer" value= ${referer}>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</div>
</form>




<%@include file="../includes/footer.jsp"%>