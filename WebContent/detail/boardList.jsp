<%@ page language="java" 
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
<title>无线点餐平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/jquery.js"></script>
<script type="text/javascript"  src="style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="text/javascript" src="${pageContext.request.contextPath }/detail/style/css/index_1.css" />
<script type="text/javascript">
	function confirmDelete(did) {
		if(confirm("是否删除该餐桌")){
			window.location="deleteDesk?did="+did;
		}
	}
	function updateDeskState(did,dstate) {
			window.location="updateDesk?did="+did+"&dstate="+dstate;
	}
</script>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="${pageContext.request.contextPath }/listDesk" method="get">
		<input type="hidden" name="method" value="search">
		<input type="text" name="dname" title="请输入餐桌名称">
		<input type="submit" value="搜索">
	</form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>状态</td>
				<td>预定时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
			<c:forEach var="list" items="${requestScope.list.data}">
				<tr class="TableDetail1">
					<td align="center">${pageScope.list.DESKID}</td>
					<td align="center"> ${pageScope.list.DNAME }</td>
					<td align="center">
						${pageScope.list.DSTATE==0?'空闲':'预订' }
					</td>
					<td align="center">${pageScope.list.DTIME}</td>
					<td>
						<a href="javascript:updateDeskState(${pageScope.list.DESKID},${pageScope.list.DSTATE})" class="FunctionButton">
						<c:if test="${pageScope.list.DSTATE==0}">
								预定
						</c:if>
						<c:if test="${pageScope.list.DSTATE==1}">
								退桌
						</c:if>
						</a>				
						<a href="javascript:confirmDelete(${pageScope.list.DESKID})" class="FunctionButton">删除</a>				
					</td>
				</tr>
        	</c:forEach>
        	<tr>
				<td colspan="3">
					<a href="${pageContext.request.contextPath }/listDesk?curPage=1">首页</a>
					<a href="${pageContext.request.contextPath }/listDesk?curPage=${requestScope.list.prePage }">上一页</a>
					<c:forEach var="i" begin="1" end="${requestScope.list.totalPage}" step="1">
						<a href="${pageContext.request.contextPath }/listDesk?curPage=${pageScope.i }">${pageScope.i }</a>
					</c:forEach>
					<a href="${pageContext.request.contextPath }/listDesk?curPage=${requestScope.list.nextPage }">下一页</a>
					<a href="${pageContext.request.contextPath }/listDesk?curPage=${requestScope.list.totalPage }">尾页</a>
				</td>
			</tr>
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath }/detail/saveBoard.html">添加</a></div>
    </div> 
</div>
</body>
</html>
