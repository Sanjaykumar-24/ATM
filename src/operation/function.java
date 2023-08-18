package operation;
import java.util.*;
import newuser.*;
import java.sql.*;
import existinguser.*;
public class function {
    public void operation() throws Exception
    {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Sanjay004@");
    int ctr=1;
    Scanner sc = new Scanner(System.in);
    while(ctr==1)
    {
    System.out.println("----------Welcome to S-Bank ATM----------");
    System.out.println("   Enter 1 if you are a new user");
    System.out.println("   Enter 2 if you are a existing user");
    System.out.println("   Enter 0 to Exit");
    System.out.println("------------------------------------------");
    System.out.print("   Enter your choice :");
    int choice = sc.nextInt();
    System.out.println("-----------------------------------------");
    if(choice==1)
    {
        newuser customer = new newuser();
        customer.createslot(sc,con);
    }
    else if(choice==2)
    {
        olduser customer = new olduser(con,sc);
        customer.service(sc,con);
    }
    else if(choice ==0)
    {
        System.out.println("   Thank you for using..!!");
        break;
    }
}
sc.close();
    }
}
