<%@ page contentType="text/html; charset=UTF-8" %> 
<% request.setCharacterEncoding("utf-8");
// 	 int no = Integer.parseInt(request.getParameter("no"));
	
// 	 String nowPage = request.getParameter("nowPage");	
// 		String col = request.getParameter("col");
// 		String word = request.getParameter("word");

// 		 AddressDTO  dto = (AddressDTO)request.getAttribute("dto");
		
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
	width: 60%;
	margin:auto;
}
table,th,td{
	border: 1px solid black;
	border-collapse: collapse;
}
th,td{
	padding:10px;
}
img{
	width:400px;
	heigth:400px;
}
#ftd{
	text-align: center;

}
</style> 
<script type="text/javascript">
function acreate(){
		var url = "create";
		location.href=url;
}
function alist(no){
	var url = "list";
	url +="?col=${param.col}";
	url +="&word=${param.word}";
	url +="&nowPage=${param.nowPage}";
	location.href=url;
}
function acreateForm(no){
	var url = "create";
	url +="?col=${param.col}";
	url +="&word=${param.word}";
	url +="&nowPage=${param.nowPage}";
	location.href=url;
}
</script>
</head> 
<body> 

<div>조회</div>
<table>
	
	<tr>
		<th>이름</th>
		<td>${dto.name}</td>
	</tr>

	<tr>
		<th>전화번호</th>
		<td>${dto.phone}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${dto.address1}<br>
			${dto.address2}
			(${dto.zipcode})
			
		</td>
	</tr>
</table>
<div>
	<input type="button" value="생성" onclick="acreateForm()">
	<input type="button" value="목록" onclick="alist()">
	
</div>

</body> 
</html> 
