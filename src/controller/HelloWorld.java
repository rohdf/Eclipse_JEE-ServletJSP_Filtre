package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWord
 */

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		System.out.println(request.getRequestURL().toString());
//    	  response.setContentType("text/html");
//    	  PrintWriter out =response.getWriter();
//    	  out.println("<HTML>");
//    	  out.println("<HEAD><TITLE>Hello</TITLE></HEAD>");
//    	  out.println("<BODY>");
//    	  out.println("<BIG>Hello Word</BIG>");
//    	  out.println("</BODY><HTML>");
    		this.CreateJsp(request, response);
    		  
    	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.CreateJsp(request, response);
	}
	
	
	private void CreateJsp(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  
		  String nom = request.getParameter("nom");
		  String prenom = request.getParameter("prenom");
		  String genre = request.getParameter("genre");
		  
		  out.println("<!DOCTYPE html>");
		  out.println("<HTML>");
		  out.println("<HEAD> <meta charset='utf-8'> <TITLE>Bonjour vous</TITLE></HEAD>");
		  out.println("<BODY>");
		  out.println("<BIG>Bonjour, " + nom +" "+ prenom   + "</BIG>");
		  out.println("<h1>Vous êtes");
		  
		  
		  String article = ("fille".equals(genre)) ? "une " : "un ";
		  
		  out.println(article);
		  
		  out.println( genre +" </h1>");
		  
		  out.println("</BODY></HTML>");
	}

}
