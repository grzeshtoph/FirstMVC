<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>${greeting}</h1>
  <ol class="spittle-list">
      <c:forEach items="${phones}" var="phone">
          <li>
              ${phone.id}, ${phone.name}
          </li>
      </c:forEach>
  </ol>