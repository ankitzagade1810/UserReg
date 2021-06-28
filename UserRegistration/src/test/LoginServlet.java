package test;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends GenericServlet{
public void service(ServletRequest rq,ServletResponse rs)
		throws ServletException,IOException
{
	PrintWriter pw=rs.getWriter();
	rs.setContentType("text/html");
	String fname=new LoginDAO().login(rq);
	
	if(fname==null) {
		pw.println("Invalid Username Or Password");
		RequestDispatcher rd=rq.getRequestDispatcher("login.html");
		rd.include(rq, rs);
	}
	else
	{
		pw.println("Login Successful<br>");
		pw.println("Welcome"+fname);
	}
	
}
}
