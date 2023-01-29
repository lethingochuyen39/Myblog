package com.aptech.myblog;

import com.aptech.models.ApplicationSettings;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "*.do"}, name = "Main")


public class MainServlet extends HttpServlet {
    String product = "My Blog";

    @Override
    public void init() throws ServletException {

        product = getServletContext().getInitParameter("productName");
        var applicationSettings = new ApplicationSettings();
        getServletContext().setAttribute("app", applicationSettings);
        if (product == null || product.isEmpty()) {
            throw new ServletException("unable to initialize the application");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setupData(req,ApplicationSettings.topic, ApplicationSettings.all);
        var requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void setupData(HttpServletRequest request, String type, String detail) {
        ApplicationSettings applicationSettings = (ApplicationSettings) getServletContext().getAttribute("app");
        var data = applicationSettings.setupData(type, detail);
        request.setAttribute("items", data);
    }


}
