import java.sql.*;
public class MyTableData 
{
    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet  rs;

        DatabaseMetaData dmd ;

        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc","postgres","7374");
            dmd = con.getMetaData();

            System.out.println("User Name : "+dmd.getUserName());
            System.out.println("URL : "+dmd.getURL());
            System.out.println("Databse Product Name : "+dmd.getDatabaseProductName());
            System.out.println("Driver Name : "+dmd.getDriverName());
            System.out.println("Database Version Name : "+dmd.getDatabaseProductVersion());
            rs = dmd.getTables(null,null,"%",new String[]{"TABLE"});

            System.out.println("Schema\tName\tType");
            while (rs.next()) 
            {
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t\t");
                System.out.print(rs.getString(4)+"\t");         
                System.out.println();
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
