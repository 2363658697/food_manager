<%@ page language="java" 
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/detail/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			window.location.href = "/wirelessplatform/client.html?method=list";
		},1000 * 50);
	</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach var="map" items="${requestScope.list.data}">
			 		<tr height="60">
				 		<td>${pageScope.map.ORDERID }</td>
				 		<td>${pageScope.map.DNAME }</td>
				 		<td>${pageScope.map.ORDERTIME }</td>
				 		<td><tags:getTypeById orderId="${pageScope.map.ORDERID }"></tags:getTypeById></td>
				 		
				 			
				 				<td>
				 					<c:if test="${pageScope.map.ORDERSTATE ==0 }">
				 					未结账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 					</c:if>
				 					<c:if test="${pageScope.map.ORDERSTATE ==1 }">
				 					已结账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 					</c:if>
				 				</td>
				 			
				 			
				 		
				 		<td>
							<a href="${pageContext.request.contextPath }/orderDetail?orderId=${pageScope.map.ORDERID }" class="FunctionButton">详细</a> 
				 			
				 				<a href="${pageContext.request.contextPath }/listOrder?orderId=${pageScope.map.ORDERID }" class="FunctionButton">结账</a>
				 			
				 		</td>
			 		</tr>
			 	</c:forEach>
			 	<tr>
					<td colspan="3">
						<a href="${pageContext.request.contextPath }/listOrder?curPage=1">首页</a>
						<a href="${pageContext.request.contextPath }/listOrder?curPage=${requestScope.list.prePage }">上一页</a>
						<c:forEach var="i" begin="1" end="${requestScope.list.totalPage}" step="1">
							<a href="${pageContext.request.contextPath }/llistOrder?curPage=${pageScope.i }">${pageScope.i }</a>
						</c:forEach>
						<a href="${pageContext.request.contextPath }/listOrder?curPage=${requestScope.list.nextPage }">下一页</a>
						<a href="${pageContext.request.contextPath }/listOrder?curPage=${requestScope.list.totalPage }">尾页</a>
					</td>
			</tr>
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>
