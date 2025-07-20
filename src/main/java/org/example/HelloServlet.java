package org.example;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Servlet mapped to /hello
//@WebServlet("/hello") same as web.xml
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        // Set response content type
        response.setContentType("text/html");

        // Get query parameter
        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            name = "Guest";
        }

        // Print response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Hello, " + name + "!</h2>");
        out.println("<form method='post'>");
        out.println("Enter Name: <input type='text' name='txtname'/>");
        out.println("<input type='submit' value='Submit'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String txtname = request.getParameter("txtname");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>POST Response: Hello, " + name + "!</h2>");
        out.println("<h2>You entered :, " + txtname + "!</h2>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}

