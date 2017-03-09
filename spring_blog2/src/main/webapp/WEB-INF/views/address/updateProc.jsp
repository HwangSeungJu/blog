<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>



<% 
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
  font-size: 24px; 
} 
div{
	text-align: center;
	margin-top:100px;
}
</style>
<script type="text/javascript">
function aaa(){
	var url ="list.do";
	url +="?col=${param.col}";
	url +="&word=${param.word}";
	url +="&nowPage=${param.nowPage}";
	location.href=url;
}


</script> 
</head> 

<body> 
<div>
<c:choose>
<c:when test="${flag}">팀정보를 수정했습니다.</c:when>
<c:otherwise>팀정보 수정을 실패 했습니다.</c:otherwise>
</c:choose>

<br>
<input type="button" value="목록" onclick="aaa()">
</div>



</body> 
</html> 
