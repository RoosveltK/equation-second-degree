package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.equation.EquationSolver;

public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 2161581691453946987L;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        try {
            /* ServletContext interface methods application */

            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String c = request.getParameter("c");

            Double aDouble = Double.parseDouble(a);
            Double bDouble = Double.parseDouble(b);
            Double cDouble = Double.parseDouble(c);

            EquationSolver solver = new EquationSolver();

            double[] roots = solver.solve(aDouble, bDouble, cDouble);

            request.setAttribute("roots", roots);

            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
