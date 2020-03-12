

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Accno1=request.getParameter("Accno1");
		String B1=request.getParameter("Balance");
		int Balance=Integer.parseInt(B1);
		HttpSession session=request.getSession();
		String Accno=(String) session.getAttribute("Accno");
		Log m=new Log();
		m.setBalance(Balance);
		m.setAccno(Accno);
		m.setAccno1(Accno1);
		int x1=m.tr1();
		int x=m.tr();
		if(x1==1 && x==1)
		{
			response.sendRedirect("/Bank/Dop.html");
		}
		else {
			response.sendRedirect("/Bank/Invalid.html");
		}
	}
}
