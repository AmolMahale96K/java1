import java.sql.*;
public class Donor 
{
    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet  rs;
        ResultSetMetaData rsmd;

        DatabaseMetaData dmd ;

        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/jdbc","postgres","7374");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from donor");
            rsmd = rs.getMetaData();

            int n = rsmd.getColumnCount();
            System.out.println("Total Columns : "+n);

            System.out.println("ColumnName\tLable\tNULL\tType");
            for(int i=1;i<=n;i++)
            {
                System.out.println(rsmd.getColumnName(i)+"\t\t"+rsmd.getColumnLabel(i)+"\t"+rsmd.isNullable(i)+"\t"+rsmd.getColumnTypeName(i));
            }


        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
