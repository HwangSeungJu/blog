<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${empty sessionScope.id }">
	<c:set var="str">Spring MVC blog 페이지 입니다.</c:set>
</c:when>
<c:otherwise>
	<c:set var="str">안녕하세요 ${sessionScope.id }님</c:set>
</c:otherwise>
</c:choose> 
<c:set var="title">나의 여행 블로그  Spring MVC</c:set>
<c:if test="${not empty sessionScope.id && sessionScope.grade=='A' }">
</c:if>


<html>
<head>
	<title>Home</title>
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>
<div class="title">${title} 페이지 입니다.</div>
 
<div class="content">
<h1>${str}</h1>
<img src="${pageContext.request.contextPath}/member/storage/4.jpg"  width="50%"><br>

<c:choose>
<c:when test="${empty sessionScope.id }">

<input type="button" value="로그인" 
onclick="location.href='${pageContext.request.contextPath }/member/login'">

</c:when>
<c:otherwise>

<input type="button" value="로그아웃" 
onclick="location.href='${pageContext.request.contextPath }/member/logout'">
 
</c:otherwise>
</c:choose> 

<P>  The time on the server is ${serverTime}. </P>
</div>
<!-- 상단 메뉴 -->
	<div style="background-color: #EEEEEE;">
		<table class="table">
			<tr>
				<td class="td"><img class="img" src="${pageContext.request.contextPath }/template/images/프라하.jpg" width='100%'
					height='100%'></td>
			</tr>
			<tr>
				<td class="td">
					<ul id="menu">
						<li><a href="${pageContext.request.contextPath }/index.jsp">홈</a></li>
						<li><a href="${pageContext.request.contextPath }/memo/list">목록</a></li>
						<li><a href="${pageContext.request.contextPath }/memo/create">글생성</a></li>
						<li><a href="${pageContext.request.contextPath }/address/list">주소록</a></li>
						<li><a href="${pageContext.request.contextPath }/address/create">주소생성</a></li>
						<li><a href="${pageContext.request.contextPath }/bbs/list">게시판 목록</a></li>
						<li><a href="${pageContext.request.contextPath }/bbs/create">게시판글 생성</a></li>	   
						<li><a href="${pageContext.request.contextPath }/team/list">팀 목록</a></li>	   
						<li><a href="${pageContext.request.contextPath }/team/create">팀 글 생성</a></li>	
						<li><a href="${pageContext.request.contextPath }/imag/list">팀 과제 목록</a></li>	
						<li><a href="${pageContext.request.contextPath }/imag/create">팀 과제 생성</a></li>	
						
						<c:choose>
						<c:when test="${empty sessionScope.id }">
						
						<li><a href="${pageContext.request.contextPath }/member/agree">회원가입</a></li>	   
						<li><a href="${pageContext.request.contextPath }/member/login">로그인</a></li>	
						
						</c:when>
						<c:when test="${not empty sessionScope.id && sessionScope.grade=='H' }">
					    
					    <li><a href="${pageContext.request.contextPath }/member/read">나의 정보</a></li>
						<li><a href="${pageContext.request.contextPath }/member/update">회원 수정</a></li>
						<li><a href="${pageContext.request.contextPath }/member/delete">회원탈퇴</a></li>
						<li><a href="${pageContext.request.contextPath }/member/logout">로그아웃</a></li>
						   
					    </c:when>
						</c:choose>
						
						<c:if test="${not empty sessionScope.id && sessionScope.grade=='A' }">
						
   					  	<li id="admin"><a href="${pageContext.request.contextPath }/member/logout">로그아웃</a></li>
   					  	<li id="admin"><a href="${pageContext.request.contextPath }/admin/list">회원목록</a></li>
   						
   						</c:if>
							
					</ul>
				</td>
			</tr>

		</table>
		<p>아아아아아아아아아아아아아아아아아아아앙아앙안녕???</p>
	</div>
	<!-- 상단 메뉴 끝 -->
</body>
</html>
