<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${items}" var="item">
    <h2><a href="<c:url value="/news/${item.title}.do"/>">${item.title}
    </a></h2>
    <div>
            ${item.entry}
    </div>
</c:forEach>

