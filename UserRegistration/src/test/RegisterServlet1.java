package test;



import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/regi1")
public class RegisterServlet1 extends GenericServlet{
 
	public void service(ServletRequest rq,ServletResponse rs)
			throws javax.servlet.ServletException,java.io.IOException
	{
		UserBean ub=new UserBean();
		ServletContext sct=this.getServletContext();
		ub.setUsername(rq.getParameter("uname"));
		ub.setPass(rq.getParameter("pass"));
		ub.setFname(rq.getParameter("fname"));
		ub.setLname(rq.getParameter("lname"));
		
		sct.setAttribute("ub",ub);
		
		 
		
		RequestDispatcher rd=rq.getRequestDispatcher("reg2.html");
		rd.forward(rq, rs);
	}
}
