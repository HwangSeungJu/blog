<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
// 	String root = request.getContextPath();
	
// 	boolean  flag = (boolean)request.getAttribute("flag");
// 	String oldfile = (String)request.getAttribute("oldfile");
// 	String col = (String)request.getAttribute("col");
// 	String word = (String)request.getAttribute("word");
// 	String nowPage= (String)request.getAttribute("nowPage");
// 	String no= (String)request.getAttribute("no");

// 	String filename = (String)request.getAttribute("filename");
	


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

<script type="text/javascript">

	function read(){
		var url = "./read.do";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		url += "&no=${no}";
		
		location.href=url;
		
	}


</script>


<link href="%{pageContext.request.contextPath}/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->
 
<DIV class="title">수정 결과</DIV>

<div class="content">
<c:choose>
<c:when test="${oldfile != filename }">

<c:choose>
<c:when test="${flag }">수정이 성공적으로 되었습니다.</c:when>
<c:otherwise>수정이 실패 했습니다.</c:otherwise>
</c:choose>

</c:when>
<c:otherwise>같은 이름의 파일입니다.</c:otherwise>
</c:choose>

</div>
  
  <DIV class='bottom'>
  
  <c:choose>
  <c:when test="${oldfile != filename }">
  	<c:choose>
  	<c:when test="${flag }">
  	<input type='button' value='확인' onclick="javascript:read()">
  	</c:when>
  	<c:otherwise>
  		<input type='button' value='다시 시도' onclick="history.back()">
  		<input type='button' value='취소' onclick="javascript:read()">
  	</c:otherwise>
  	</c:choose>
  </c:when>
  <c:otherwise>
  		<input type='button' value='다시 시도' onclick="history.back()">
  </c:otherwise>
  </c:choose>
  
  	
	
  </DIV>


 
 
<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
</html> 
