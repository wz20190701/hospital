package servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
public class BackServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response){
		try{
			int start =0;
			int count =5;
			try{
				start = Integer.parseInt(request.getParameter("page.start"));
			}
			catch(Exception e){
			}
			try{
				count = Integer.parseInt(request.getParameter("page.count"));
			}
			catch(Exception e){
			}
			
			Page page = new Page(start,count);
			String method = (String) request.getAttribute("method");
			Method m =this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class,Page.class);
			String redirect = m.invoke(this, request,response,page).toString();
			if(redirect.startsWith("@"))
				response.sendRedirect(redirect.substring(1));
			else if(redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
				request.getRequestDispatcher(redirect).forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
