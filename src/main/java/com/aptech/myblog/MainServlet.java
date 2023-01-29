package com.aptech.myblog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "*.do"}, name = "Main"
        // , initParams = {@WebInitParam(name = "productName", value = "My New Blog")}
)


public class MainServlet extends HttpServlet {
    String product = "My Blog";
    String connectionString = "";

    @Override
    public void init() throws ServletException {

        product = getInitParameter("productName");
        connectionString = getServletContext().getInitParameter("connStr");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/xml");
        if (name != null) {
            resp.getWriter().write(String.format("<application>" +
                    "<msg>Hello, %s</msg>" +
                    "<product>%s</product>" +
                    "<connectionStr>%s</connectionStr>" +
                    "</application>", name, product,connectionString));
        } else {
            resp.getWriter().write(String.format("<msg>Please enter your name</msg>"));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/xml");
        if (name != null && !name.equals("")) {
            resp.getWriter().write(String.format("<msg>Hello, %s</msg>", name));
        } else {
            resp.sendRedirect("index.html");
        }
    }
}
