<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> %>
<%  
// 	String root = request.getContextPath();
// 	String passwd = (String)request.getAttribute("passwd");
// 	String id = (String)request.getAttribute("id");
	
// 	boolean flag = (boolean)request.getAttribute("flag");

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
 
<DIV class="title">패스워드 변경 확인</DIV>
 
<FORM name='frm' method='POST' action='./.do'>
<div class="title">패스워드</div>
<div class="content">
<c:choose>
<c:when test="${flag }">패스워드  변경했습니다. <br></c:when>
<c:otherwise>
로그인을 해보세요. <br>
패스워드 변경을 실패 헀습니다.
</c:otherwise>
</c:choose>

</div>
  <DIV class='bottom'>
  <c:choose>
  <c:when test="${flag }">
  
    <input type='button' value='로그인 ' onclick="location.href='./login.do'">
  </c:when>
  <c:otherwise>
    <input type='button' value='다시시도' onclick="history.back()">
  
  </c:otherwise>
  </c:choose>

	 <input type='button' value='홈' onclick="location.href='../index.jsp'">
  </DIV>
</FORM>
 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 