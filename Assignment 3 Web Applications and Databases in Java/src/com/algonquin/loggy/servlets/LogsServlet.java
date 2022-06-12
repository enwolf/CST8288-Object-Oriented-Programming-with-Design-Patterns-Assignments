package com.algonquin.loggy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogsServlet
 */
//@WebServlet(description = "Loggy Logs", urlPatterns = { "/LogsServlet" })
public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogsServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String value = request.getParameter("name");
        String htmlResponse = "<html><head><title>Example</title></head><body>Hello world from Java Servlet.</p></body></html>";
        PrintWriter writer = response.getWriter();
        writer.write(htmlResponse + " " + value);
    }
}
