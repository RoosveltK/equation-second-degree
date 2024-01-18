package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 2161581691453946987L;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        try {
            /* ServletContext interface methods application */

            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String c = request.getParameter("c");

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            ServletContext context = getServletContext();
            // String path =
            // context.getRealPath("/WEB-INF/classes/com/equation/EquationSolver.class");
            // System.out.println(path);

        } catch (Exception e) {
            // RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        } finally {
            out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
