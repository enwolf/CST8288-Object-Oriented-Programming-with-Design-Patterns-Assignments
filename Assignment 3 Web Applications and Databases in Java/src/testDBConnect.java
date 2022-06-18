import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.algonquin.loggy.beans.TextLog;
import com.algonquin.loggy.dao.ApplicationDao;
import com.algonquin.loggy.dao.DBConnection;

public class testDBConnect {

	private static final String username = "root";
	private static final String password = "password";
	private static final String connPath = "jdbc:mysql://localhost:3306/loggy";
	
	
	
	public static void main(String[] args) throws SQLException {
	
		DBConnection myDbCon = new DBConnection();
		myDbCon.getConnectionToDatabase();
		
		
		ApplicationDao myDao = new ApplicationDao();
		System.out.println("about to update");
		myDao.updateTextLogInDatabase("df7c9cda-3825-40e3-9d6d-5466e943d05b", "newTitleDaoTest", "newContentDaoTest");
		System.out.println("update compleate");
		
		/*
    	try {
			
    		Date testdate = new Date(System.currentTimeMillis());
			List<TextLog> getTextLogArray = new ArrayList();
			getTextLogArray = myDao.getTextLogListFromDatabase();
			System.out.println("populated log array: Length = " + getTextLogArray.size());
			System.out.println("Test Stored Data Object log array: Length = " + getTextLogArray.size());
			
			java.util.Date utilDate = new java.util.Date(getTextLogArray.get(0).getTimestamp().getTime());
			
			System.out.println("Test Stored Date object = " + getTextLogArray.get(0).getTimestamp());
			System.out.println("Test Stored Date object = ****** " + getTextLogArray.get(1).getTimestamp());
			

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println("Test Stored Date object = ************ " + dateFormat.format(getTextLogArray.get(1).getTimestamp()) );
			
			
			//System.out.println("Test utilDate Date object = " + dateFormat.format(utilDate));
			//System.out.println("Test testdate Date object = " + dateFormat.format(testdate));
			
			//System.out.println(txtLogArray.get(0).getTitle() + "\n " + txtLogArray.get(0).getContent() );
		} catch (SQLException e1) {
			System.out.println("Error: Pulling Data From Datbase");
			e1.printStackTrace();
		}
		
		
	
		Connection connObj = null;

		try{
			
			connObj = DriverManager.getConnection(connPath, username, password);
		
			System.out.println("Connected!");
			
		}catch(SQLException e){
			 
			e.printStackTrace();
			
		}finally{
			 
			if(connObj != null){
				
				connObj.close();
			}			
		}
	}
	
	*/
	}
	

}

