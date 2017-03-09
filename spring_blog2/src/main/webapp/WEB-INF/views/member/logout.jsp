<%@ page contentType="text/html; charset=UTF-8" %> 
<%  
// 	 request.setCharacterEncoding("utf-8");
//       String root = request.getContextPath();
// 	  session.invalidate(); //모든 세션변수 제거 (id,grade)
	
	 
%> 
<script type="text/javascript">
	var url = "${pageContext.request.contextPath }/index.jsp"; 
	location.href=url;
</script>