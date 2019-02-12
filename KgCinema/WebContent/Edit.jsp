<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" type="text/css" href="./css/InputCSS1.css">

</head>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./js/EditJS.js"></script>

<body>
	<div class="all" align="center">
		<div class="title"><br><div><h2>개인정보 수정<span class="ml10">회원님의 정보를 정확히 입력해주세요.</span></h2></div></div>
		<div class="cf"><br><span class="text-sub mb10">* 표시 항목은 필수입력 항목입니다.</span></div>
		<form name="iform" method="post" action="edit.do"> <!-- enctype="multipart/form-data" -->
		<div class="clearfix myInfoArea">
		<img name="photo" id="profilePhotoImg" style="width: 100px; height: 100px;" src="" alt="프로필" class="img-circle pull-left" data-original="null" data-image="null">
		    <div class="pull-left textArea">
		    	<strong>${bean.id }</strong>
		    	<span class="profile_btn_wrap">
		    		<button id="imgUploadBtn" class="img_btn user fake_section">찾아보기
		    		</button>
		    		<button id="imgDeleteBtn" class="img_btn user profile_del" onclick="profileDel()">삭제</button>
		    		<input type="file" id="file" name="file" onchange="handleFileSelect()">
		    	</span>
		    </div>
		</div>
			<table class="table1">
				<tr>
					<th>* 이름</th>
					<td>
					    <input type="text" size="19" name="name" disabled="disabled" onchange="checkName()" onkeyup="checklen(this,15)" value="${bean.name }">
					    <label id="namelabel"></label><input type="text" hidden="" name="id" value="${bean.id }">
					</td>
				</tr>
				<tr>
					<th>* 비밀번호</th>
					<td ><input type="password" name="pwd" onkeyup="checklen(this,10);">
					<label id="pwdlabel">&nbsp;&nbsp;</label>
					<input type='text' hidden="" name="pass" value="${bean.pwd }">
					</td>
				</tr>
				<tr>
					<th>* 주소</th>
					<td colspan= "2">
						<input type="text" size="10" id="code" name="code" readonly value="06267"> <input type="button" class="post" onclick="DaumPostcode()" value="우편번호 검색"><p>
						<input type="text" size="40" id="juso1" name="juso1" readonly value="${bean.juso1 }"><p>
						<input type="text" size="40" id="juso2" name="juso2" onkeyup="checklen(this,30)" value="${bean.juso2 }">&nbsp;&nbsp;상세주소를 입력하세요 <br>
					</td>
				</tr>
				
				<tr>
					<th>* 생년월일</th>
					<td colspan= "2">
						<input type="text" class="w67" size="4" name="year" onfocus="birth()" onchange="birth()" maxlength="4" value="${bean.getBirth().substring(0,4) }">&nbsp;년&nbsp;
						<input type="text" class="w44" size="2" name="month" onchange="birth()" maxlength="2" value="${bean.birth.substring(5,7) }">&nbsp;월&nbsp;
						<input type="text" class="w44" size="2" name="day" onchange="birth()" maxlength="2" value="${bean.birth.substring(8) }">&nbsp;일&nbsp;
						<label id="birthlabel">&nbsp;&nbsp;생년월일을 입력하세요</label>
					</td>
				</tr>
				
				<tr>
					<th>* 휴대폰</th>
					<td colspan= "2">
						<input type="text" class="w67" size="3" name="num1" onfocus="num()" onchange="num()" maxlength="3" value="${bean.phone.substring(0,3) }">-
						<input type="text" class="w67" size="4" name="num2" onchange="num()" maxlength="4" value=${bean.phone.substring(4,8) }>-
						<input type="text" class="w67" size="4" name="num3" onchange="num()" maxlength="4" value="${bean.phone.substring(9) }">&nbsp;
						<label id="numlabel">&nbsp;&nbsp;숫자3~4자리 입력하세요></label>
					</td>
				</tr>
				<tr>
					<th>* email</th>
					<td colspan= "2">
						<input type="text" size="40" name="email" onblur="emailcheck()" onkeyup="checklen(this,30)" placeholder="aaa@aaa.aa형식으로 입력" value="${bean.email }">
						<span id="email_ch"></span>
					</td>
				</tr>

			</table>
			<p>
			<input type="button" class="button button2" value="취소" onclick="location.href='bbsList.jsp'">&nbsp;&nbsp;&nbsp;
			<input type="button" class="button button3" value="등록" onclick="check()">
		</form>
	</div>
</body>
</html>