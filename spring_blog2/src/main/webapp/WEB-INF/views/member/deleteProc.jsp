<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
// 	String root = request.getContextPath();
// 	boolean flag = (boolean)request.getAttribute("flag");
// 	String oldfile = (String)request.getAttribute("oldfile");
// 	String id = (String)request.getAttribute("id");


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
 
<DIV class="title"></DIV>
 <div class="content">
 <c:choose>
 <c:when test="${flag }"> 탈퇴 되었습니다. 자동 로그아웃 되었습니다. </c:when>
 <c:otherwise> 회원 탈퇴를 실패 했습니다 </c:otherwise>
 </c:choose>

</div>
  <DIV class='bottom'>
    <input type='button' value='홈'onclick="location.href='../index.jsp'">
    <input type='button' value='다시시도' onclick="history.back()">
  </DIV>

 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 