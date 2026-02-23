package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form values
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String rating = request.getParameter("rating");
        String comments = request.getParameter("comments");

        // Print feedback in server console
        System.out.println("----- Feedback Received -----");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
        System.out.println("-----------------------------");

        // Send response to browser
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Thank you, " + name + "!</h2>");
        out.println("</body></html>");
    }
}

