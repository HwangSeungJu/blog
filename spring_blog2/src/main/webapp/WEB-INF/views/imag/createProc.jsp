<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	
// 	String root = request.getContextPath();
// 	boolean  flag = (boolean)request.getAttribute("flag");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function ilist() {
	var url = "list.do"
	
	location.href = url;
	
}

</script>
<style type="text/css">
* {
	font-family: gulim;
	font-size: 20px;
}
</style>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
</head>
<!-- *********************************************** -->
<body>
	<!-- *********************************************** -->

	<DIV class="title">작성 확인</DIV>

	<FORM name='frm' method='POST' action='./.do'>
	
	<div class=content>
	<c:choose>
	<c:when test="${flag }">작성 성공!</c:when>
	<c:otherwise>작성 실패!</c:otherwise>
	</c:choose>
	
</div>

		<DIV class='bottom'>
			<input type="button" value='계속등록' onclick="location.href='create.do'" > 
			<input type='button' value='목록' onclick="ilist()">
		</DIV>
	</FORM>


	<!-- *********************************************** -->
</body>
<!-- *********************************************** -->
</html>
