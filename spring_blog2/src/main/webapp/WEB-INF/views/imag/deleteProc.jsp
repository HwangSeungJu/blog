<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

// 	boolean flag =(boolean)request.getAttribute("flag");
// 	boolean pflag =(boolean)request.getAttribute("pflag");
// 	int no = (Integer)request.getAttribute("no");
// 	String passwd =(String)request.getAttribute("passwd");
// 	String col =(String)request.getAttribute("col");
// 	String word=(String)request.getAttribute("word");
// 	String nowPage =(String)request.getAttribute("nowPage");
// 	String root = request.getContextPath();
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
 function b() {
		var url="list.do";
		
		url+="?col=${col}";
		url+="&word=${word}";
		url+="&nowPage=${nowPage}";
		location.href=url;
		
				}

 </script>
<link href="${pageContext.request.contextPath }/css/style.css" rel="Stylesheet" type="text/css">
 
</head> 
 
<!-- *********************************************** -->
<body>
<!-- *********************************************** -->
 
 
 
<DIV class="title">삭제확인</DIV>
 
 
<div class="content">
<c:choose>
<c:when test="${pflag==false }">비밀번호가 같지 않습니다.
 <DIV class='bottom'>
   <input type="button" value='다시시도' onclick="history.back()">
 
    <input type='button' value='목록' onclick="b()">
  </DIV> 
</c:when>
<c:when test="${flag }">삭제 성공하였습니다
  <DIV class='bottom'>
      <input type='button' value='목록' onclick="b()">
  </DIV>

</c:when>
<c:otherwise>

 


  삭제 실패하였습니다
    <DIV class='bottom'>
     
 
     <input type="button" value='다시시도' onclick="history.back()">
 
    <input type='button' value='목록' onclick="b()">
  </DIV>

</c:otherwise>
</c:choose>

</div>

<!-- *********************************************** -->

</body>

<!-- *********************************************** -->
 
</html> 
 