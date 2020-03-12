

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
public class Reg extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String Accno=request.getParameter("Accno");
	String Name=request.getParameter("Name");
	String Password=request.getParameter("Password");
	String Email=request.getParameter("Email");
	String Mobile=request.getParameter("Mobile");
	String n1=request.getParameter("Balance");
	String Address=request.getParameter("Address");
	String Acctype=request.getParameter("Acctype");
	int Balance=Integer.parseInt(n1);
	Log m=new Log();
	m.setAccno(Accno);
	m.setName(Name);
	m.setEmail(Email);
	m.setMobile(Mobile);
	m.setPassword(Password);
	m.setAddress(Address);
	m.setAcctype(Acctype);
	m.setBalance(Balance);
	int x=m.reg();
	if(x==1)
	{
		((HttpServletResponse) response).sendRedirect("/Bank/Success.html");
	}
	else
	{
		((HttpServletResponse) response).sendRedirect("/Bank/Wrong.html");
	}
	}

}
