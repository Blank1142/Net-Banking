import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.Executors;

import oracle.jdbc.driver.OracleDriver;

public class Log {
private String Accno;
Connection con;
private String Name;
private String Email;
private String Mobile;
private String Password;
private String Address;
private String Acctype;
private int Balance;
private String Accno1;
public String getAccno1() {
	return Accno1;
}
public void setAccno1(String accno1) {
	Accno1 = accno1;
}
public int getBalance() {
	return Balance;
}
public void setBalance(int balance) {
	Balance = balance;
}
public String getAccno() {
	return Accno;
}
public void setAccno(String accno) {
	Accno = accno;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getMobile() {
	return Mobile;
}
public void setMobile(String mobile) {
	Mobile = mobile;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getAcctype() {
	return Acctype;
}
public void setAcctype(String acctype) {
	Acctype = acctype;
}
Log()
{
	try {
		DriverManager.registerDriver(new OracleDriver());
	con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/XE","SYSTEM","system");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
int reg()
{
	try
	{
		String s="INSERT INTO BANK1 VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(s);
		ps.setString(1, Accno);
		ps.setString(2, Name);
		ps.setString(3, Email);
		ps.setString(4, Mobile);
		ps.setString(5, Password);
		ps.setString(6, Address);
		ps.setString(7, Acctype);
		ps.setLong(8, Balance);
		int x=ps.executeUpdate();
		return x;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
int login()
{
	try {
		String s="SELECT * FROM BANK1 WHERE ACCNO=? AND PASSWORD=?";
				PreparedStatement ps = con.prepareStatement(s);
				ps.setString(1, Accno);
				ps.setString(2, Password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()==true)
				{
					Name=rs.getString("Name");
					Mobile=rs.getString("Mobile");
					Accno=rs.getString("Accno");
					Email=rs.getString("Email");
					Acctype=rs.getString("Acctype");
					Balance= (int) rs.getLong("Balance");
					return 1;
				}
				}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
int Balance()
{
try {
		
		String s="SELECT * FROM BANK1 WHERE ACCNO=?";
		PreparedStatement pr = con.prepareStatement(s);
		pr.setString(1, Accno);
		
		ResultSet rs = pr.executeQuery();
		if(rs.next()==true)
		{
			Balance= (int) rs.getLong("Balance");
			return 1;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
int dop()
{
	try {
		
		String s="UPDATE BANK1 SET BALANCE=BALANCE+? WHERE aCCNO=?";
		PreparedStatement pr = con.prepareStatement(s);
		pr.setLong(1, Balance);
		pr.setString(2, Accno);
		ResultSet rs = pr.executeQuery();
		if(rs.next()==true)
		{
			return 1;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
int tr()
{
	try {
		String s="UPDATE BANK1 SET BALANCE=BALANCE+? WHERE aCCNO=?";
		String s1="UPDATE BANK1 SET BALANCE=BALANCE-? WHERE aCCNO=?";
		PreparedStatement pr = con.prepareStatement(s);
		pr.setLong(1, Balance);
		pr.setString(2, Accno1);
		ResultSet rs = pr.executeQuery();
		if(rs.next()==true)
		{
			return 1;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
int tr1()
{
	try {
		
		String s="UPDATE BANK1 SET BALANCE=BALANCE-? WHERE aCCNO=?";
		PreparedStatement pr = con.prepareStatement(s);
		pr.setLong(1, Balance);
		pr.setString(2, Accno);
		ResultSet rs = pr.executeQuery();
		if(rs.next()==true)
		{
			return 1;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
}
}
