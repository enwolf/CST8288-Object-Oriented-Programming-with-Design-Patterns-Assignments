package com.algonquin.loggy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.loggy.beans.TextLog;



public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<TextLog> txtLogArray = new ArrayList<TextLog>();
    

    
    public LogsServlet() {
        super();
    }


    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	
    		handleGet(request,response);

    }
    
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    	String htmlResponse = "<html>"
    						+ "<head>"
    						+ "<title>Log's Be Here</title>"
    						+ "</head>"    						
	    						+ "<body>"
	    							+"<h1>Log's Be Here</h1>"
		    						+ "<form method='post'>"
			    						+ "<label for='title'>Title:</label><br>"
			    						+ "<input type='text' name='title' id='title' value=''><br><br>"
			    						+ "<label for='content'>Content:</label><br>"
			    						+ "<input type='text' name='content' id='content' value=''><br><br>"
			    						+ "<input type='submit' value='Submit'>"
			    						+ "<input type='submit' value='Cancel'>"			    						
			    					+ "</form>"
			    					+ "<table>"
				    					+"<tr style='font-size: 25px;'>"
					    					+ "<th> #</th>"
					    					+ "<th> Title</th>"
					    					+ "<th> Content</th>"
					    					+ "<th> Action</th>"
					    				+"</tr>"
			    					+ "</table>"
	    						+ "</body>"    						
	    					+ "</html>";
        
    	PrintWriter writer = response.getWriter();
        
    	writer.write(htmlResponse);
    }
    
    
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
		
    	ServletContext servletContext = request.getServletContext();
    	response.setContentType("text/html;charset=UTF-8");
    	
    	
    	
    	String title = request.getParameter("title");
		String content = request.getParameter("content");
		LocalDateTime timeStamp = generateTimeStamp();
		
		TextLog txtLogObj = new TextLog(title,content,timeStamp);
		
		txtLogArray.add(txtLogObj);
    	
		PrintWriter writer = response.getWriter();


			
		
		writer.write("<html>");
		writer.write("<head>"); 
		writer.write("<title>Log's Be Here</title>");
		writer.write("</head>");
		writer.write("<body>");
		writer.write("<h1>Log's Be Here</h1>");
		//this will have to be updated once you add remove functionality. 
		writer.write("<h2>Log #" + txtLogArray.size() +" created!</h2>");
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
		writer.write("<input type='submit' value='Cancel'>");
		writer.write("</form>");
		writer.write("<table>");
		writer.write("<tr style='font-size: 25px;'>");
		writer.write("<th>#</th>");
		writer.write("<th>Title</th>");
		writer.write("<th>Content</th>");
		writer.write("<th>TimeStamp</th>");
		writer.write("<th>Action</th>");
		writer.write("</tr>");
		
    	for (int i = 0; i < txtLogArray.size(); i++) {
			writer.write("<tr>");
			writer.write("<td>" + txtLogArray.get(i).getId().toString().substring(0, 8) + "</td>");
			writer.write("<td>" + txtLogArray.get(i).getTitle() + "</td>");
			writer.write("<td>" + txtLogArray.get(i).getContent() + "</td>");
			writer.write("<td>" + txtLogArray.get(i).getTimeStamp().toString().substring(14, 24) + "</td>");
			writer.write("<td><span>Edit</span>' '<span>Delete</span></td>");
			writer.write("</tr>");
		}
    	
    	writer.write("</table>");
    	writer.write("</body>");
    	writer.write("</html>");


		
		/*
		writer.write("<br>");
		writer.write("");
		writer.write("");
		writer.write("");
		writer.write("");
		writer.write("");
		writer.write("");
				
		
		
		writer.write("</head>");
		String htmlResponse = "<html>"
    						+ "<head>"
    						+ "<title>Log's Be Here</title>"
    						+ "</head>"    						
	    						+ "<body>"
	    							+"<h1>Log's Be Here</h1>"
	    						
		    						+ "<form method='post'>"
		    							+ "<label for='title'>Title:</label><br>"
		    							+ "<input type='text' name='title' id='title' value=''><br><br>"
		    							+ "<label for='content'>Content:</label><br>"
		    							+ "<input type='text' name='content' id='content' value=''><br><br>"
		    							+ "<input type='submit' value='Submit'>"
		    							+ "<input type='submit' value='Cancel'>"			    						
		    						+ "</form>"
			    					+ "<table>"
				    					+"<tr style='font-size: 25px;'>"
					    					+ "<th>#</th>"
					    					+ "<th>Title</th>"
					    					+ "<th>Content</th>"
					    					+ "<th>Action</th>"
					    				+"</tr>";
    	writer.write(htmlResponse);
		*/
    	

		
		
		
		/*
		String htmlResponse = "<html>"
    						+ "<head>"
    						+ "<title>Log's Be Here</title>"
    						+ "</head>"    						
	    						+ "<body>"
	    							+"<h1>Log's Be Here</h1>"
		    						+ "<form method='post'>"
		    							+ "<label for='title'>Title:</label><br>"
		    							+ "<input type='text' name='title' id='title' value=''><br><br>"
		    							+ "<label for='content'>Content:</label><br>"
		    							+ "<input type='text' name='content' id='content' value=''><br><br>"
		    							+ "<input type='submit' value='Submit'>"
		    							+ "<input type='submit' value='Cancel'>"			    						
		    						+ "</form>"
			    					+ "<table>"
				    					+"<tr style='font-size: 25px;'>"
					    					+ "<th> #</th>"
					    					+ "<th> Title</th>"
					    					+ "<th> Content</th>"
					    					+ "<th> Action</th>"
					    				+"</tr>";
					    				+"<tr>"
					    					+ "<td>654789654</td>"
					    					+ "<td>" + title + "</td>"
					    					+ "<td>" + content + "</td>"
					    					+ "<td>Hard coded Holder chahahah!</td>"
					    				+"</tr>"
					    				+"<tr>"
					    					+ "<td>" + txtLogObj.getId() + "</td>"
					    					+ "<td>" + txtLogObj.getTitle() + "</td>"
					    					+ "<td>" + txtLogObj.getContent() + "</td>"
					    					+ "<td>" + txtLogObj.getTimeStamp() + "</td>"
				    					+"</tr>"			
				    					
				    					
				    					
				    					
				    					
				    					+"<tr>"
					    					+ "<td>" + txtLogArray.get(0).getId() + "</td>"
					    					+ "<td>" + txtLogArray.get(0).getTitle() + "</td>"
					    					+ "<td>" + txtLogArray.get(0).getContent() + "</td>"
					    					+ "<td>" + txtLogArray.get(0).getTimeStamp() + "</td>"
				    					+"</tr>"			
				    					+"<tr>"
					    					+ "<td>" + txtLogArray.get(1).getId() + "</td>"
					    					+ "<td>" + txtLogArray.get(1).getTitle() + "</td>"
					    					+ "<td>" + txtLogArray.get(1).getContent() + "</td>"
					    					+ "<td>" + txtLogArray.get(1).getTimeStamp() + "</td>"
					    				+"</tr>"
			    					+ "</table>"
	    						+ "</body>"    						
	    					+ "</html>";
        
    	
        
    	writer.write(htmlResponse);
    	*/
    	
    }

    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

    	handlePost(request, response);
		
		
	}
    
    
	public LocalDateTime generateTimeStamp() {		
				
		LocalDateTime timestampe = LocalDateTime.now();
			
			return timestampe;
		}
    
    
    
}


