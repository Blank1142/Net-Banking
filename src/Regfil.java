

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Regfil
 */
public class Regfil implements Filter {

    /**
     * Default constructor. 
     */
    public Regfil() {
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
		String Accno=request.getParameter("Accno");
		String Name=request.getParameter("Name");
		String Password=request.getParameter("Password");
		String Cpassword=request.getParameter("Cpassword");
		String Email=request.getParameter("Email");
		String Mobile=request.getParameter("Mobile");
		String Address=request.getParameter("Address");
		String Types=request.getParameter("Acctype");
		
		if(Name.length()!=0 && Password.length()!=0 && Cpassword.length()!=0 && Email.length()!=0 && Mobile.length()!=0 &&Address.length()!=0 && Types.length()!=0)
		{
			if(Password.contentEquals(Cpassword))
			{
				chain.doFilter(request, response);
			}
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/Bank/Wrong.html");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
