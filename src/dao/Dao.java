package dao;

import static dao.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.jsp.tagext.TryCatchFinally;

import model.Audience;
import model.Login;
import model.TechTonics;

public class Dao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4,pst5,pst6,pst7,pst8,pst9,pst10,pst11,pst12;

	public Dao() throws Exception {
		cn = getConnection();
		
		pst1 = cn.prepareStatement( "select count(*)  from login where email=? and password=?");
		pst2 = cn.prepareStatement("select * from techtonic");
		pst3 = cn.prepareStatement("insert into login values(?,?,?)");
		pst4 = cn.prepareStatement("select * from login");
		pst5 = cn.prepareStatement("select count(*)  from adminLogin where email=? and password=?");
		pst6 = cn.prepareStatement("insert into techtonic(presentationDate,title ,description,prsenterName) values(?,?,?,?)");
		pst7 = cn.prepareStatement("select * from techtonic where id=?");
		pst8 = cn.prepareStatement("update techtonic set presentationDate=? , title=? ,description=?,prsenterName=? where id=? ");
		pst9 = cn.prepareStatement("delete from techtonic where id=? ");
		pst10 = cn.prepareStatement("select * from login where email=?");
		pst11= cn.prepareStatement("insert into audience values(?,?,?)");
		pst12=cn.prepareStatement("select * from audience where presentationId=?");

	}

	public boolean validateUser(String email, String password) throws Exception {

		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery();) {

			if (rst.next()) {
				if (rst.getInt(1) == 1)
					return true;
				else
					return false;
			} else
				return false;
		}
	}
	public boolean validateAdmin(String email, String password) throws Exception {

		pst5.setString(1, email);
		pst5.setString(2, password);
		try (ResultSet rst = pst5.executeQuery();) {

			if (rst.next()) {
				if (rst.getInt(1) == 1)
					return true;
				else
					return false;
			} else
				return false;
		}
	}


	public ArrayList<TechTonics> fetchTechTonicsDetails() throws Exception {
		ArrayList<TechTonics> data = new ArrayList<TechTonics>();
		try (ResultSet rst = pst2.executeQuery();) {

			while (rst.next()) {
				data.add(new TechTonics(rst.getInt(1),rst.getDate(2), rst.getString(3), rst
						.getString(4), rst.getString(5)));

			}

		}
		return data;
	}
	
	public ArrayList<Login> fetchLoginDetails() throws Exception {
		ArrayList<Login> data = new ArrayList<Login>();
		try (ResultSet rst = pst4.executeQuery();) {

			while (rst.next()) {
				data.add(new Login(rst.getString(1), rst.getString(2), rst.getString(3)));

			}

		}
		return data;
	}
	public TechTonics retriveTechTonicsDetail(int id) throws Exception {
		TechTonics temp=null;
		pst7.setInt(1, id);
		
		try (ResultSet rst = pst7.executeQuery();) {

			while (rst.next()) {
				temp=new TechTonics(rst.getInt(1),rst.getDate(2), rst.getString(3), rst
						.getString(4), rst.getString(5));

			}
			return temp;

		}
		
	}
	
	public boolean insertUser(String email, String password,String username) throws Exception {

		String flag=null;
		
		pst3.setString(1, email);
		pst3.setString(2, username);
		pst3.setString(3, password);
		
	for (Login users : fetchLoginDetails()) {
		if(email.equalsIgnoreCase(users.getEmail())){
		flag="duplicate Value";	
		}
		
	}
		if(flag==null)
		{pst3.executeUpdate();
		 return true; 
		}
		else 
			return false;
		
     }
	
	public boolean insertTechTalk(String presentationDate, String title, String description,String presenterName) throws Exception {

		
		
	
		pst6.setString(1,presentationDate);
		pst6.setString(2, title);
		pst6.setString(3, description);
		pst6.setString(4, presenterName);
		if(pst6.executeUpdate()==0)
			return true;
		else
			return false;
		}
	public boolean updateTechTalk(int id,String presentationDate, String title, String description,String presenterName) throws Exception {

		
		
		
		pst8.setString(1,presentationDate);
		pst8.setString(2, title);
		pst8.setString(3, description);
		pst8.setString(4, presenterName);
		pst8.setInt(5,id);
		if(pst8.executeUpdate()==0)
			return true;
		else
			return false;
		}
public boolean deleteTechTalk(int id) throws Exception {

		pst9.setInt(1,id);
		if(pst9.executeUpdate()==1)
			return true;
		else
			return false;
		}


public Login retriveLoginDetail(String email) throws Exception {
	Login temp=null;
	pst10.setString(1, email);
	
	try (ResultSet rst = pst10.executeQuery();) {

		while (rst.next()) {
			temp=new Login(rst.getString(1),rst.getString(2) , rst.getString(3));

		}
		return temp;

	}
	

}

public boolean insertAudience(String email, String username, String  presentationId) {

	
	
	
	
	
	try {
		pst11.setString(1,email);
		pst11.setString(2, username);
		pst11.setString(3, presentationId);
		pst11.executeUpdate();
	    return true;
		
	} catch (SQLException e) {
		
			return false;
	}
	}


public ArrayList<Audience> retriveAudienceDetail(int id) throws Exception {
	 ArrayList<Audience> audience =new ArrayList<Audience>();
	pst12.setInt(1, id);
	
	try (ResultSet rst = pst12.executeQuery();) {

		while (rst.next()) {
			audience.add(new Audience(rst.getString(1), rst.getString(2), rst.getInt(3)));

		}
		return audience;

	}
	
}
}
