<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header1.jsp"%>
<title>${store.name} review</title>
<%@include file="../includes/header2.jsp"%>
            
       <!-- Page Heading -->
       <h1 class="h3 mb-4 text-gray-800">Review Modify Page</h1>

<form class="form-horizontal" action="/review/modify?rno=${review.rno }" method="post" >
  <div class="form-group">
    <label class="control-label col-sm-2" for="rno">RNO</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="rno" value="${review.rno }" readonly="readonly"/>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="mid">MID</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mid" value="${review.mid }" readonly="readonly" >
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="context">CONTEXT</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="context" value="${review.context }" >
    </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="score">SCORE</label>
    <div class="col-sm-10">
     <label class="control-label col-sm-2" for="lng">SCORE:</label>
			<select class="form-control" id="exampleFormControlSelect1" name="score">
				<option>5</option>
				<option>4</option>
				<option>3</option>
				<option>2</option>
				<option>1</option>
			</select>
    </div>
    <div class="col-sm-10">
			<input type="hidden" name="refefer" class="form-control"
				value="${review.sno}">
		</div>
    
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2" for="img">IMG</label>
    <div class="col-sm-10">
      <input name = "img"  type="file" class="form-control" id="file"  multiple="multiple">
    </div>
    </div>
   
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">Modify</button>
    </div>
    </div>
</form>





<%@include file="../includes/footer.jsp"%>