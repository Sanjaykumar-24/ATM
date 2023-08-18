package services;
import details.*;
import java.sql.*; 
import date.*;
import java.util.Scanner;
public class withdraw extends details{
    public withdraw(int accno,Connection con)throws Exception
    {
        super(accno,con);
    }
    public void getamount(Connection con,Scanner sc)throws Exception
    {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM user");
     int minamo=0;
     System.out.println("Enter amount to be withdrawn");
     minamo = sc.nextInt();
     int curramo=0;
     int pin =0;
     while(rs.next())
     {
        if(rs.getInt(1)==accno)
        {
       curramo = rs.getInt(4);
       pin = rs.getInt(3);
       break;
        }
     }
     int m=1;
     while(m<=3)
     {
     System.out.print("Enter your pin number :");
     int p;
     p= sc.nextInt();
     if(pin==p)
     {
     if(minamo>curramo)
        System.out.println("Sorry you dont have balance..!!");
        else
        {
        st.executeUpdate("UPDATE user SET amount = "+(curramo-minamo)+" WHERE accno = "+accno);
        System.out.println("Amount succesfully Debited..!!");
        date D =new date();
        String date = D.getdate();
        String time = D.gettime();
        System.out.println(         date.substring(0,10)+" "+time.substring(0,5)+" "+date.substring(20,28));
        }
        break;
    }
    else
    {
        if(m<=3)
        System.out.println("Pin number is wrong try again...!!");
        else
        System.out.println("too many attempts...!!please try again..!!");
        m++;
    }
}
    }
}
