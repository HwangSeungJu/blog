<%@ page contentType="text/html; charset=UTF-8" %> 
<%   

	
// 	  	String root = request.getContextPath();
// 	String str = (String)request.getAttribute("str");
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
 
<DIV class="title">아이디 및 이메일 중복확인</DIV>
 
<div class="content">
${str}

</div>
 
 
  
  <DIV class='bottom'>
    <input type='submit' value='다시시도' onclick="history.back()">
    <input type='button' value='홈' onclick="location.href='${pageContext.request.contextPath }/index.jsp'">
  </DIV>

 
 

</body>
<!-- *********************************************** -->
</html> 