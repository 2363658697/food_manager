<%@tag import="model.MyOrder"%>
<%@tag import="model.MyFoodType"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="orderId" required="true" type="java.lang.String" %>
<% 
	String allPrice=new MyOrder().getAllPrice(orderId);
%>
<%=allPrice %>
