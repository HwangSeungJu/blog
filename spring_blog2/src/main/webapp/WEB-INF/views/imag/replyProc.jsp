<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// 	String root = request.getContextPath();
// 	boolean flag = (boolean)request.getAttribute("flag");
// 	String col = (String)request.getAttribute("col");
// 	String word = (String)request.getAttribute("word");
// 	String nowPage = (String)request.getAttribute("nowPage");

%>
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<script type="text/javascript">
function blist(){
	var url = "list.do";
	url += "?col=&{col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";
	location.href=url;
}
</script>
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
<div class="title">처리결과</div>
<DIV class="content">
<c:choose>
<c:when test="${flag }">답변이 등록되었습니다.</c:when>
<c:otherwise>답변 등록에 실패하였습니다.</c:otherwise>
</c:choose>

<div class="bottom">
<input type="button" value="계속등록" onclick="location.href='./create.do'">
<input type="button" value="목록" onclick="blist()">
</div>
</DIV>
 
 
 
<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html>