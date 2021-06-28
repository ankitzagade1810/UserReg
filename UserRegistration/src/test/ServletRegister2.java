package test;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@SuppressWarnings("serial")
@WebServlet("/regi2")
public class ServletRegister2 extends GenericServlet{

	public void service(ServletRequest rq,ServletResponse rs)
	  throws ServletException,IOException
	{
		PrintWriter pw=rs.getWriter();
		rs.setContentType("text/html");
	  ServletContext sct=this.getServletContext();
	  UserBean ub=(UserBean) sct.getAttribute("ub");
	  ub.setAddress(rq.getParameter("address"));
	  ub.setMid(rq.getParameter("mid"));
	  ub.setPhno(Long.parseLong(rq.getParameter("phno")));
	  int k=new RegisterDAO().register(ub);
	  if(k>0)
	  {
		  pw.println("Thank You For Registration...");
		  RequestDispatcher rd=rq.getRequestDispatcher("login.html");
		  rd.include(rq, rs);
	  }
	  else
	  {
		  pw.println("User Already Exist");
		  RequestDispatcher rd=rq.getRequestDispatcher("login.html");
		  rd.include(rq, rs);
	  }
	}
}
