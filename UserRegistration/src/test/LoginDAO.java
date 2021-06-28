package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;

public class LoginDAO {
public String fname,uname=null;
public String login(ServletRequest rq) {
	try {
		Connection con=DBConn.getCon();
		PreparedStatement ps=con.prepareStatement
				("select * from userreg where uname=? and pass=?");
		ps.setString(1,rq.getParameter("uname"));
		ps.setString(2, rq.getParameter("pass"));
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			fname=rs.getString(3);
		}
	}catch(Exception e) {e.printStackTrace();}
	return fname;
}
	public String check(ServletRequest rq) {
		try {
			Connection con=DBConn.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from userreg where uname=?");
			ps.setString(1,rq.getParameter("uname"));
					
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				uname=rs.getString(1);
				
			}
		}catch(Exception e) {e.printStackTrace();}
		return uname;
}
}
