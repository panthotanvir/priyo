package com.priyo.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by panthotanvir on 6/20/15.
 */
@WebServlet(name = "HomeController", urlPatterns = "/home")
public class HomeController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Home Controller is requested ");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/user_registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }
}
