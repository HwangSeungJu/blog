<%@ page contentType="text/html; charset=UTF-8" %> 


<%
	
// 	String root = request.getContextPath();

// 	String oldfile =(String)request.getAttribute("oldfile");
// 	String id =(String)request.getAttribute("id");
%> 
 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 20px; 
} 
</style> 
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
<DIV class="title">회원 탈퇴</DIV>
 
<FORM name='frm' method='POST' action='./delete'>
<input type="hidden" name="id" value="${id}">
<input type="hidden" name="oldfile" value="${oldfile}">
<div class="content">
탈퇴를 하시면 더이상 컨텐트를 제공 받을수 없습니다.<br>
그래도 찰퇴를 원하시면 아래 탈퇴버튼을 클릭하세요.



</div>
  
  <DIV class='bottom'>
    <input type='submit' value='탈퇴'>
    <input type='button' value='취소' onclick="history.back()">
  </DIV>
</FORM>
 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 