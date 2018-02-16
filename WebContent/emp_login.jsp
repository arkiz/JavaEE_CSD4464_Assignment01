<%@page import="Employee.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome </title>
</head>
<body>


<%
	String user_name = request.getParameter("user_name");
	String first_name = request.getParameter("first_name");
    String last_name = request.getParameter("last_name");
    
    String emp_id = request.getParameter("emp_id");
    String dept_id = request.getParameter("dept_id");
    String salary = request.getParameter("salary");
    
    int emp_id_int = Integer.parseInt(emp_id);
    int dept_id_int = Integer.parseInt(dept_id);
    float salary_float = Float.parseFloat(salary);
    
    Register reg = new Register(user_name, emp_id_int, first_name, last_name, dept_id_int, salary_float);
    
    if(reg.InsertEmp()) 
    {
%>

<div>Welcome <%=reg.getFirst_name()%> ! Registration Complete </div>

<%
    } else {
%>

<div>Sorry, <%=reg.getMsg() %> </div>

<input type="button" onclick="javascript:history.back()" value="BACK"/>

<%  }
%>

</body>
</html>