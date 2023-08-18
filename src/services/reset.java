package services;
import java.sql.*;
import date.*;
import java.util.Scanner;
import details.*;
public class reset extends details{
    public reset(int accno,Connection con)throws Exception
    {
     super(accno,con);
    }
    public void setpin(Connection con,Scanner sc)throws Exception
    {
     Statement st = con.createStatement();
     System.out.println("Enter your new pin :");
     int newpin = sc.nextInt();
     st.executeUpdate("UPDATE user SET pin = "+newpin+" WHERE accno = "+accno);
     System.out.println("pin updated..!!");
     date D =new date();
     String date = D.getdate();
     String time = D.gettime();
     System.out.println(         date.substring(0,10)+" "+time.substring(0,5)+" "+date.substring(20,28));
    }
}
