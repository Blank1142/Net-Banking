

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String Accno=request.getParameter("Accno");
	String Password=request.getParameter("Password");
	Log m=new Log();
	m.setAccno(Accno);
	m.setPassword(Password);
	int x=m.login();
	if(x==1)
	{
		 Accno=m.getAccno();
		String Name=m.getName();
		String Mobile=m.getMobile();
		String Email=m.getEmail();
		int Balance=m.getBalance();
		Integer i=new Integer(Balance);
		String Acctype=m.getAcctype();
		if(Acctype.equals("SA"))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("Name", Name);
			session.setAttribute("Email", Email);
			session.setAttribute("Accno", Accno);
			session.setAttribute("Mobile", Mobile);
			session.setAttribute("Balance",i);
			session.setAttribute("Acctype", Acctype);
			response.sendRedirect("/Bank/Logindet.jsp");
		}
		else
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("Name", Name);
			session.setAttribute("Email", Email);
			session.setAttribute("Accno", Accno);
			session.setAttribute("Mobile", Mobile);
			session.setAttribute("Balance",i);
			session.setAttribute("Acctype", Acctype);
			response.sendRedirect("/Bank/Logindet1.jsp");
		}
		
	}
	else
	{
		response.sendRedirect("/Bank/Log.html");
	}
	}

}
