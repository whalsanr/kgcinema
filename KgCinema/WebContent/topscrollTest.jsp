<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<style>
    div {margin-bottom:1000px;}
</style>
<script>
    function fnMove(seq){
        var offset = $("#div" + seq).offset();
        $('html, body').animate({scrollTop : offset.top}, 400);
    }
</script>
</head>
<body>
   <button onclick="fnMove('1')">div1�� �̵�</button>
    <button onclick="fnMove('2')">div2�� �̵�</button>
    <button onclick="fnMove('3')">div3�� �̵�</button>
    <div id="div1">div1</div>
    <div id="div2">div2</div>
    <div id="div3">div3</div>
</body>
</html>