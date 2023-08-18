package details;
import java.sql.*;
public class details {
    protected int accno;
    protected String name;
    protected int pin;
    protected int amount;
    public details(int accno,Connection con)throws Exception
    {
     this.accno = accno;
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery("SELECT * FROM user");
     while(rs.next())
     {
        int num = rs.getInt(1);
        if(num==accno)
        {
            this.name = rs.getString(2);
            this.pin = rs.getInt(3);
            this.amount = rs.getInt(4);
            break;
        }
     }
    }
}
