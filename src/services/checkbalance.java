package services;
import java.sql.*;
import details.*;
import date.*;
public class checkbalance extends details{
  public checkbalance(int accno, Connection con) throws Exception {
        super(accno, con);
    }
public void printbal()throws Exception
  {
    System.out.print("The balance in your account is :");
    System.out.println(amount);
    date D  =new date();
    String date = D.getdate();
    String time = D.gettime();
    System.out.println(         date.substring(0,10)+" "+time.substring(0,5)+" "+date.substring(20,28));
  }
}
