

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Transferfilter
 */
public class Transferfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Transferfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String Accno1=request.getParameter("Accno1");
		String B1=request.getParameter("Balance");
		
		if(Accno1.length()==10)
		{
			if(B1.length()!=0)
			{
				chain.doFilter(request, response);
			}
			else
			{
				((HttpServletResponse) response).sendRedirect("/Bank/Balanceerror.html");
			}
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/Bank/Accerror.html");
		}
	
		
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
