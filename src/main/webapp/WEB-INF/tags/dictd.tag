<%@tag pageEncoding="UTF-8"%>
<%@ taglib prefix="dict" uri="http://www.lgb.com/tags/dic" %>
<%@ attribute name="groupValue" type="java.lang.String" required="true"%>
<%@ attribute name="itemKey" type="java.lang.String" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<td>${dict:show(groupValue, itemKey)}</td>