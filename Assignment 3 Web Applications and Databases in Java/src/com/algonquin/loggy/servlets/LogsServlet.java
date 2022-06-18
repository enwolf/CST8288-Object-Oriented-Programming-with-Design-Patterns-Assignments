package com.algonquin.loggy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.loggy.beans.TextLog;
import com.algonquin.loggy.dao.ApplicationDao;



public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    private List<TextLog> getTextLogArray = new ArrayList<TextLog>();
    String hrefLocalPath = "http://localhost:8080/Assignment_3_Web_Applications_and_Databases_in_Java/logs";


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
		handleGet(request,response);

    }
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

    	handlePost(request, response);
		
		
	}
    
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	ServletContext servletContext = request.getServletContext();
    	response.setContentType("text/html;charset=UTF-8");
    	
    	   	
    	handelGetDelete(request,response );
   	
    	//I think we will always want to call this to reDraw the page regardless of which variable is not null.
    	handleGetHTMLLoad(request,response );

    }
    
    
    public void handelGetDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	String logToDeleteURL =  request.getParameter("delete");
    	
    	if (logToDeleteURL != null) {
    		ApplicationDao myDao = new ApplicationDao();
    		String responseMessage = "LogID = "+  logToDeleteURL.substring(0, 8) + " was sucesffuly deleted.";

			try{
				myDao.deleteTextLogFromDatabase(logToDeleteURL);
				System.out.println("Deleted Log ID = " + logToDeleteURL);
			}catch (SQLException e) {
				System.out.println("Error: Unable to Deleted Log ID= " + logToDeleteURL);
				e.printStackTrace();
			}    		
    	}
    }

    
    public void handleGetHTMLLoad(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	ServletContext servletContext = request.getServletContext();
    	response.setContentType("text/html;charset=UTF-8");
    	
    	String logToEditURL =  request.getParameter("edit");
    	
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    	
    	
    	ApplicationDao myDao = new ApplicationDao();
    	
		TextLog logToEdit = new TextLog();
		
		try {
			logToEdit = myDao.getSpeicifcTextLogFromDatabase(logToEditURL);
			System.out.println("Got speicifc log, log ID = " + logToEditURL);
		} catch (SQLException e) {
			System.out.println("Error: Unable to get speicifc log, log ID = " + logToEditURL);
			e.printStackTrace();
		}

		try {
			
			getTextLogArray = myDao.getTextLogListFromDatabase();
			System.out.println("populated log array: Length = " + getTextLogArray.size());

		}catch(SQLException e) {
			
			System.out.println("Error: Pulling Data From Datbase");
			e.printStackTrace();
		}
    	
    	
    	PrintWriter writer = response.getWriter();
    	
    	if (logToEditURL != null) {
    		
    		drawGetEditHTML(writer,getTextLogArray,logToEdit, logToEditURL);
		
    	}else{
    		
    		drawGetLoadHTML(writer,getTextLogArray,"");

		
    }
    	
}//End of method
    public void drawGetEditHTML(PrintWriter writer, List<TextLog> getTextLogArray, TextLog logToEdit, String logToEditURL) {
    	
   		writer.write("<html>");
		writer.write("<head>"); 
		writer.write("<title>Log's Be Here</title>");
		writer.write("</head>");
		writer.write("<body>");
			writer.write("<h1>Log's Be Here</h1>");
			writer.write("<table padding: 15px;>");
				writer.write("<tr style='font-size: 25px;'>");
					writer.write("<th>#</th>");
					writer.write("<th>Title</th>");
					writer.write("<th>Content</th>");
					writer.write("<th>TimeStamp</th>");
					writer.write("<th>Action</th>");
				writer.write("</tr>");
				
	    		writer.write("<html>");
				writer.write("<head>"); 
				writer.write("<title>Log's Be Here</title>");
				writer.write("</head>");
				writer.write("<body>");
				writer.write("<h1>Edit Log's Here</h1>");
				writer.write("<h2>LogId = "+ logToEditURL + "</h2>");
				writer.write("<form method='post'>");
				writer.write("<label for='title'>Title:</label>");
				writer.write("<br>");
				writer.write("<input type='text' name='title' id='title' value='"+ logToEdit.getTitle() +"'>");
				writer.write("<br>");
				writer.write("<br>");
				writer.write("<label for='content'>Content:</label>");
				writer.write("<br>");
				writer.write("<input type='text' name='content' id='content' value='"+ logToEdit.getContent() +"'>");
				writer.write("<br>");
				writer.write("<br>");
				writer.write("<input type='submit' value='Submit'>");
				writer.write("<input type='reset' value='Cancel'>");
				writer.write("</form>");
								
	for (int i = 0; i < getTextLogArray.size(); i++) {
				    					
				writer.write("<tr>");
					writer.write("<td>" + getTextLogArray.get(i).getId().toString().substring(0, 8) + "</td>");
					writer.write("<td>" + getTextLogArray.get(i).getTitle() + "</td>");
					writer.write("<td>" + getTextLogArray.get(i).getContent() + "</td>");
					writer.write("<td>" + getTextLogArray.get(i).getTimestamp() + "</td>");
					//writer.write("<td>" + myDateFormat.format(txtLogArray.get(i).getTimeStamp()) + "</td>");
					writer.write("<td><a href='" + hrefLocalPath + "?edit=" + getTextLogArray.get(i).getId() + "'>Edit</a> | <a href='" + hrefLocalPath + "?delete=" + getTextLogArray.get(i).getId() + "'>Delete</a></td>");
				writer.write("</tr>");
	}    								
	
			writer.write("</table>");
		writer.write("</body>");
	writer.write("</html>");  
    	
    }
        
    public void drawGetLoadHTML(PrintWriter writer, List<TextLog> getTextLogArray, String responseMsg) {
    	
   		writer.write("<html>");
		writer.write("<head>"); 
		writer.write("<title>Log's Be Here</title>");
		writer.write("</head>");
		writer.write("<body>");
			writer.write("<h1>Log's Be Here</h1>");
			writer.write("<h2>  Log count:" + getTextLogArray.size() + " HandleGet</h2>"); 		//this will have to be updated once you add remove functionality. 
				writer.write("<form method='post'>");
					writer.write("<label for='title'>Title:</label>");
					writer.write("<br>");
					writer.write("<input type='text' name='title' id='title' value=''>");
					writer.write("<br>");
					writer.write("<br>");
					writer.write("<label for='content'>Content:</label>");
					writer.write("<br>");
					writer.write("<input type='text' name='content' id='content' value=''>");
					writer.write("<br>");
					writer.write("<br>");
					writer.write("<input type='submit' value='Submit'>");
					writer.write("<input type='reset' value='Cancel'>");
				writer.write("</form>");
				writer.write("<table>");
					writer.write("<tr style='font-size: 25px;'>");
						writer.write("<th>#</th>");
						writer.write("<th>Title</th>");
						writer.write("<th>Content</th>");
						writer.write("<th>TimeStamp</th>");
						writer.write("<th>Action</th>");
					writer.write("</tr>");
									
					for (int i = 0; i < getTextLogArray.size(); i++) {
					    					
						writer.write("<tr>");
							writer.write("<td>" + getTextLogArray.get(i).getId().toString().substring(0, 8) + "</td>");
							writer.write("<td>" + getTextLogArray.get(i).getTitle() + "</td>");
							writer.write("<td>" + getTextLogArray.get(i).getContent() + "</td>");
							writer.write("<td>" + getTextLogArray.get(i).getTimestamp() + "</td>");
							//writer.write("<td>" + myDateFormat.format(txtLogArray.get(i).getTimeStamp()) + "</td>");
							writer.write("<td><a href='" + hrefLocalPath + "?edit=" + getTextLogArray.get(i).getId() + "'>Edit</a> | <a href='" + hrefLocalPath + "?delete=" + getTextLogArray.get(i).getId() + "'>Delete</a></td>");
						writer.write("</tr>");
						
					}    								
		
				writer.write("</table>");
			writer.write("</body>");
		writer.write("</html>");  
    	
    }
        
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	ServletContext servletContext = request.getServletContext();
    	response.setContentType("text/html;charset=UTF-8");
		
    	try {
			handlePostSubmit(request,response);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    }
    
        
    
    public void handlePostSubmit(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
    	
    	ServletContext servletContext = request.getServletContext();
    	response.setContentType("text/html;charset=UTF-8");
    	List<TextLog> txtLogArray = new ArrayList<TextLog>();
    	ApplicationDao myDao = new ApplicationDao(); //object to pass and pull data from database.
		
    	String logToEditURL =  request.getParameter("edit");
    	
    	//values coming from FORM when SUBMIT is clicked.
    	String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date timeStamp = generateTimeStamp();
		

		PrintWriter writer = response.getWriter();
    	
    	if(logToEditURL!=null) {
    	
				myDao.updateTextLogInDatabase(logToEditURL, title, content);
				handleGetHTMLLoad(request, response);
	
    	}else{
    		
    		TextLog txtLogObj = new TextLog(title,content,timeStamp);
   			myDao.addTextLogToDatabase(txtLogObj);
       		txtLogArray = myDao.getTextLogListFromDatabase();
       		
       		


			
    		
    		writer.write("<html>");
    		writer.write("<head>"); 
    		writer.write("<title>Log's Be Here</title>");
    		writer.write("</head>");
    		writer.write("<body>");
    		writer.write("<h1>Log's Be Here</h1>");
    		writer.write("<h2>Log #" + txtLogArray.size() +" created: HandlePost</h2>"); 		//this will have to be updated once you add remove functionality. 
    		writer.write("<form method='post'>");
    		writer.write("<label for='title'>Title:</label>");
    		writer.write("<br>");
    		writer.write("<input type='text' name='title' id='title' value=''>");
    		writer.write("<br>");
    		writer.write("<br>");
    		writer.write("<label for='content'>Content:</label>");
    		writer.write("<br>");
    		writer.write("<input type='text' name='content' id='content' value=''>");
    		writer.write("<br>");
    		writer.write("<br>");
    		writer.write("<input type='submit' value='Submit'>");
    		writer.write("<input type='reset' value='Cancel'>");
    		writer.write("</form>");
    		writer.write("<table>");
    		writer.write("<tr style='font-size: 25px;'>");
    		writer.write("<th>#</th>");
    		writer.write("<th>Title</th>");
    		writer.write("<th>Content</th>");
    		writer.write("<th>TimeStamp</th>");
    		writer.write("<th>Action</th>");
    		writer.write("</tr>");

    		
    		//maybe fix this later?
    		//DateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    		
    		for (int i = 0; i < txtLogArray.size(); i++) {
    			
        		writer.write("<tr>");
    			writer.write("<td>" + txtLogArray.get(i).getId().toString().substring(0, 8) + "</td>");
    			writer.write("<td>" + txtLogArray.get(i).getTitle() + "</td>");
    			writer.write("<td>" + txtLogArray.get(i).getContent() + "</td>");
    			writer.write("<td>" + txtLogArray.get(i).getTimestamp() + "</td>");
    			//writer.write("<td>" + myDateFormat.format(txtLogArray.get(i).getTimeStamp()) + "</td>");
    			writer.write("<td><a href='" + hrefLocalPath + "?edit=" + txtLogArray.get(i).getId() + "'>Edit</a> | <a href='" + hrefLocalPath + "?delete=" + txtLogArray.get(i).getId() + "'>Delete</a></td>");
    			writer.write("</tr>");
    		}
        	
        	writer.write("</table>");
        	writer.write("</body>");
        	writer.write("</html>");

    		
    	}
		
		
    	
    	
    	
    }
    


    //TODO maybe move this into TextLog or Log constructor?
	
	public Date generateTimeStamp() {		
		
		Date timestamp = new Date(System.currentTimeMillis());
		return timestamp;
		
	}
    
    
    
}


