import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Login extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws IOException, ServletException
	{
		String usr = req.getParameter("usr");
		String pass = req.getParameter("pass");
		PrintWriter out = res.getWriter();
		
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try
		{
			Class.forName("org.postgresql.Driver");
		     con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc","postgres","redhat");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from login where usr='"+usr+"' and pass='"+pass+"'");
			
			if(rs.next())
				out.print("Login SuccessFully");
			else
				out.print("Incorect Password");
		}
		catch(Exception e)
		{
			out.print(e);
		}
		
	}
}

