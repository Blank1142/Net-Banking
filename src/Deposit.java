

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1=request.getParameter("Balance");
		
		int Balance=Integer.parseInt(n1);
		
		HttpSession session=request.getSession();
		String Accno=(String) session.getAttribute("Accno");
		System.out.println(Accno);
			Log m=new Log();
			m.setBalance(Balance);
		m.setAccno(Accno);
	int x=	m.dop();
	if(x==1)
	{
		response.sendRedirect("/Bank/Dop.html");
	}
	}
}
