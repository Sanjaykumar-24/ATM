package services;
import java.sql.*;
import java.util.*;
import details.*;
import date.*;
public class addbalance extends details{
    public addbalance(int accno,Connection con)throws Exception
    {
        super(accno,con);
    }
    public void addbal(Connection con,Scanner sc)throws Exception
    {
     Statement st = con.createStatement();
     System.out.println("Enter amount to be credidted");
     int am = sc.nextInt();
     st.executeUpdate("UPDATE user SET amount = "+am+" WHERE accno = "+accno);
     System.out.println("Amount credited Sucessfully..!!");
     date D =new date();
     String date = D.getdate();
     String time = D.gettime();
     System.out.println(         date.substring(0,10)+" "+time.substring(0,5)+" "+date.substring(20,28));
    }
}
