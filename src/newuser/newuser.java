package newuser;
import java.util.*;
import java.sql.*;
import date.*;
public class newuser {
    private int acno;
    private String nam;
    private int pi;
    private int amount=0;
    public void createslot (Scanner sc,Connection con)throws Exception
    {
      Statement st = con.createStatement();
      int flag = 1,x=0;
      while(flag==1)
      {
      ResultSet rs = st.executeQuery("SELECT * FROM user");
      System.out.print("   Enter your account number:");
      acno = sc.nextInt();
      while(rs.next())
      {
        int num = rs.getInt(1);
        if(acno == num)
        {
        flag=0;
        break;
        }
      }
      if(flag==0)
      {
        if(x<3)
        {
      System.out.println("   Sorry...Account number already exists..!!");
      System.out.println("   Please try again..!!");
      System.out.println("---------------------------------------------------");
        }
        else
        {
          System.out.println("Sorry try again...!!");
          break;
        }
      }
      else
      {
        PreparedStatement pst = con.prepareStatement("INSERT INTO user(accno,name,pin,amount) VALUES(?,?,?,?);");
        adduserdetails(pst,sc);
        date D =new date();
        String date = D.getdate();
        String time = D.gettime();
        System.out.println(         date.substring(0,10)+" "+time.substring(0,5)+" "+date.substring(20,28));
        break;
      }
    }
    }
    public  void adduserdetails(PreparedStatement pst,Scanner sc)throws Exception
    {
      System.out.print("   Enter your name:");
      nam = sc.next();
      System.out.print("   Create your pin number :");
      pi = sc.nextInt();
      pst.setInt(1,acno);
      pst.setString(2,nam);
      pst.setInt(3,pi);
      pst.setInt(4,amount);
      pst.executeUpdate();
      System.out.println("------------------------------------------------");
      System.out.println("   Thanks for using S-Bank ATM..!!");
    }
}
