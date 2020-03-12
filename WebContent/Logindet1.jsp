<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.println("Welcome to DMS "+(session.getAttribute("Name")));%></br>
<% out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");%></br>
<%out.println("Accno :"+(session.getAttribute("Accno"))); %></br>
<%out.println("Name :"+(session.getAttribute("Name"))); %></br>
<%out.println("Email :"+(session.getAttribute("Email"))); %></br>
<% out.println("Mobile :"+(session.getAttribute("Mobile")));%></br>
<% out.println("Acctype :"+(session.getAttribute("Acctype")));%></br>
<% out.println("Balance :"+(session.getAttribute("Balance")));%><a href="/Bank/Balance">Check Balance</a></br>
<% out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");%></br>
<a href="/Bank/Deposit.html">Deposit</a></br>
</body>
</html>