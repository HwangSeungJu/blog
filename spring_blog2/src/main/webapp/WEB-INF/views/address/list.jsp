<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
// 	List<AddressDTO> list = (List<AddressDTO>)request.getAttribute("list");
// 	String col = (String)request.getAttribute("col");	
// 	String word = (String)request.getAttribute("word");	
// 	int nowPage = (Integer)request.getAttribute("nowPage");	
// 	String paging =(String)request.getAttribute("paging");


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
	margin-top: 20px;
	margin-bottom: 20px;
}
table{
	width:60%;
	margin :0 auto;
}
table,th,td{
	border:1px solid black;
	border-collapse:collapse;
}
th,td{
	padding:10px;
}
a:link {
    color:#000000;
    background-color:transparent;
    text-decoration:none;
}
a:visited {
    color:#000000;
    background-color:transparent;
    text-decoration:none;
}

a:hover {
    color:#ff0000;
    background-color:transparent;
    text-decoration:underline;
}
a:active {
    color:#000000;
    background-color:transparent;
    text-decoration:underline;
}
img{
	width: 200px;
	height: 200px;
}
</style> 
<script type="text/javascript">
function read(no){
	var url="read"
	url += "?no="+no;
	url += "&col=${col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";
	location.href=url;
}
function update(no){
	 var url ="update";
	 url +="?no="+no;
		url += "&col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
	 location.href = url;
}
function del(no){
	if(confirm("정말삭제하시겠습니까?")){
		var url = "delete"
		url += "?no="+no;
		url += "&col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		location.href=url;
	}
}

</script>
</head> 
<body> 
<div> 주소목록</div>
<div>
<form method="post" action="./list">
<select name="col"><!-- 검색할 컬럼 -->


<option value="name"
<c:if test="${col==name}">selected='selected</c:if>
>이름</option>
<option value="phone"
<c:if test="${col==phone}">selected='selected</c:if>
>전화번호</option>

<option value="total">전체출력</option>
</select>

<input type="text" name="word" value="${word}"> <!-- 검색어 -->
<input type="submit" value="검색">
<input type='button' value='등록' onclick="location.href='./create'">

</form>
</div>
<table>
	 <tr>
	 	<th>번호</th>
	 	<th>이름</th>
	 	<th>전화번호</th>
	 
	 	<th>수정삭제</th> 	
	 </tr>
	 <c:choose>
	 <c:when test="${fn:length(list)==0}">
	 <tr>
	 	<td colspan="5">등록된 팀정보가 없습니다.</td>
	 </tr> 
	 </c:when>
	 <c:otherwise>
	 <c:forEach items="${list}" var="dto">
		
	 <tr>
	 	<td>${dto.no}</td>
	 	<td><a href="javascript:read('${dto.no}')">${dto.name}</a></td>
	 	<td>${dto.phone}</td>

	 	<td><a href="javascript:update('${dto.no}')">수정</a>
	 	    <a href="javascript:del('${dto.no}')">삭제</a>
	 </td>
 </tr>
	 </c:forEach>
	 </c:otherwise>
	 </c:choose>

</table>
<div>
	${paging}

</div>

</body> 
</html> 
