package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {
public int k;	
public int register(UserBean ub) {
	try {
		Connection con=DBConn.getCon();
		PreparedStatement ps=con.prepareStatement
				("insert into userreg values(?,?,?,?,?,?,?)");
		ps.setString(1,ub.getUsername());
		ps.setString(2, ub.getPass());
		ps.setString(3, ub.getFname());
		ps.setString(4, ub.getLname());
		ps.setString(5, ub.getAddress());
		ps.setString(6, ub.getMid());
		ps.setLong(7, ub.getPhno());
		k=ps.executeUpdate();
	}catch(Exception e) {e.printStackTrace();}
	return k;
}
}
