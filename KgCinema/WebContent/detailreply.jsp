<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [detailreply.jsp]</title>
  <style type="text/css">
    
              
  </style>
  
  <script type="text/javascript">
    //---------댓글 수정 창 열기--------------------------------
	function r_edit(num,writer,content,sabun){
	 //open('guestreply_edit.jsp?num='+num+'&writer='+writer+'&content='+content+'&sabun='+sabun,'댓글수정','width=500,height=400, top=300,left=400');
	}
  </script>
 </head>
<body>

<form action="detailreply.do">
 <table  width=900 border=1 cellspacing=0 >
  
   <input type="text" name="sabun" value="${rsabun}"> 
   <input type="hidden" name="flag" value="true"> 
 
   <tr>
	 <td> <img src="images/x1.gif">저자:<img src="images/x1.gif"> </td>
	 <td> <input type="text" name="writer" size=25></td>
			
	  <td rowspan=2 align="center">
	   <input type="submit" value="MVC2댓글저장" id="rsave" >
	   </td>
	</tr>
		
	<tr>
		<td><img src="images/x1.gif">내용:<img src="images/x1.gif"> </td>
		<td>
		  <textarea cols=27 rows=3 name="content"></textarea>       
		</td>
	</tr>
 </table>
</form>

 <table  width=900 border=0 cellspacing=0 >
   <tr bgcolor="pink" align="center">
     <td colspan="4">댓글 데이터 출력 </td>
   </tr>  
  <c:forEach var="rbean" items="${rnaver}"> 
   <tr onmouseover="style.backgroundColor='#00FFFF'" onmouseout="style.backgroundColor=''">
    <td> ${rbean.sabun } </td>
    <td> ${rbean.writer} </td>
    <td> ${rbean.content } </td>
    <td align="right">
      <a href="replyDelete.do?idx="${rbean.sabun} >[댓글삭제]</a>
      <a href="replyEdit.do" >[댓글수정]</a>
      
    </td>
   </tr>
  </c:forEach> 

 </table>	
</body>
</html>












