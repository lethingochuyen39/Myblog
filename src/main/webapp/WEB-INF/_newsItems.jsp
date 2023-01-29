<%@ page import="java.util.List" %>
<%@ page import="com.aptech.models.NewsItem" %>
<%@ page import="java.util.ArrayList" %>
<%
    List<NewsItem> items = (List<NewsItem>) request.getAttribute("items");
%>
<% for (NewsItem item : items) {
    pageContext.setAttribute("item", item);
%>
<div>
    <h2><a href="${pageContext.request.contextPath}/news/${item.getTitle()}">${item.getTitle()}
    </a></h2>
    <div>
        ${item.getEntry()}
    </div>
</div>
<%}%>