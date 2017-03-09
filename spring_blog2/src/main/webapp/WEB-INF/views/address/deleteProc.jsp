<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  
// String col = request.getParameter("col");
// String word = request.getParameter("word");
// String nowPage = request.getParameter("nowPage");

// boolean flag = (boolean)request.getAttribute("flag");

%>

<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: gulim; 
  font-size: 24px; 
} 
div{
	text-align: center;
	margin-top:100px;
}
</style> 
</head> 
<body> 
<FORM name='frm' method='POST' action='./list' onsubmit="return incheck(this)">
<input name="no" value="${dto.no}" type="hidden">
<input name="col" value="${param.col}" type="hidden">
<input name="word" value="${param.word}" type="hidden">
<input name="nowPage" value="${param.nowPage}" type="hidden">

<div>
<c:choose>
<c:when test="${flag }">팀정보를 삭제했습니다.</c:when>
<c:otherwise>팀정보 삭제를 실패 했습니다.</c:otherwise>
</c:choose>

<input type="submit" value="목록" onclick="location.href='./list'">

</div>
</FORM>
</body> 
</html> 
