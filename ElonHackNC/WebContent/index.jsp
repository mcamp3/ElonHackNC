<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:import url="header.jsp">
	<c:param name="title" value="Elon HackNC Homepage" />
</c:import>

 <h2> Welcome To HackAnIdea</h2>
 <br />
 
 <a href ="${pageContext.request.contextPath}/Controller?action=login">Click here to login</a>
  <br />
 <a href ="${pageContext.request.contextPath}/Controller?action=createaccount">Click here to create an account</a>
<c:import url="footer.jsp" />