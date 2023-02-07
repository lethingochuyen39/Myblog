<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<String> colors = new ArrayList<>();
    colors.add("Default");
    colors.add("Red");
    colors.add("blue");
    pageContext.setAttribute("colors", colors);
%>

<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation"></button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <c:if test="${empty user}">
                        <a class="nav-link" href="showlogin.do">Login <span class="sr-only">(current)</span></a>
                    </c:if>
                    <c:if test="${!empty user}">
                        <a class="nav-link" href="logout.do">Logout ${user.name} <span class="sr-only">(current)</span></a>
                    </c:if>

                </li>
                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Color</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <c:choose>
                            <c:when test="${!empty user}">
                                <c:forEach items="${colors}" var ="color">
                                    <a class="dropdown-item" href="#">${color}</a>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <a class="dropdown-item" href="#">No user Login</a>
                            </c:otherwise>
                        </c:choose>


                    </div>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Link</a>
                </li>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

</header>