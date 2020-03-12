

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String Accno=(String) session.getAttribute("Accno");
		Log m=new Log();
		m.setAccno(Accno);
		int b=m.Balance();
		
		if(b==1)
		{
			int Balance=m.getBalance();
			Integer i=new Integer(Balance);
			session.setAttribute("Balance",i);
			response.sendRedirect("/Bank/Logindet.jsp");
			
		}
	}
}
