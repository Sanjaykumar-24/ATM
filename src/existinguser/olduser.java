package existinguser;
import java.sql.*;
import java.util.*;
import services.*;
import operation.*;
public class olduser {
    int oacno;
    String onam="xxx";
    int opin;
    int oamo;
    int x=1;
    public olduser(Connection con,Scanner sc)throws Exception
    {
        while(x==1)
        {
      Statement st = con.createStatement();
      System.out.print("   Enter your account number :");
      oacno = sc.nextInt();
      ResultSet rs = st.executeQuery("SELECT * FROM user");
      while(rs.next())
      {
        int num = rs.getInt(1);
        if(num==oacno)
        {
            this.onam = rs.getString(2);
            this.opin = rs.getInt(3);
            this.oamo = rs.getInt(4);
            break;
        }
      }
      if(onam.equals("xxx"))
      {
      System.out.println("   Account number is wrong..try again!!");
      System.out.println("---------------------------------------------");
      System.out.println("");
      function fn = new function();
      fn.operation();
      }
      else
      {
      System.out.println("   Welcome "+onam+"..!!");
      x=0;
      }
    }
    }
    public void service(Scanner sc,Connection con) throws Exception
    {
      while(true)
      {
        System.out.println("   Enter 1 to Check account balance");
        System.out.println("   Enter 2 to Reset your pin");
        System.out.println("   Enter 3 to withdraw amount from your account");
        System.out.println("   Enter 4 to add amount to your account");
        System.out.print("   Enter your choice");
        int op =sc.nextInt();
        System.out.println("-------------------------------------------------");
        if(op==1)
        {
            checkbalance bal = new checkbalance(oacno,con);
            bal.printbal();
            break;
        }
        else if(op==2)
        {
          reset res = new reset(oacno,con);
          res.setpin(con,sc);
          break;
        }
        else if(op==4)
        {
          addbalance adbal = new addbalance(oacno,con);
          adbal.addbal(con,sc);
          break;
        }
        else if(op==3)
        {
          withdraw withd = new withdraw(oacno,con);
          withd.getamount(con,sc);
          break;
        }
        else
        {
        System.out.println("Enter correct choice..!!");
        System.out.println("");
        System.out.println("");
        }
      }
    }
}
