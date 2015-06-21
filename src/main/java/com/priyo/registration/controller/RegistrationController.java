package com.priyo.registration.controller;

import com.priyo.registration.dao.UserDao;
import com.priyo.registration.dao.UserDaoImp;
import com.priyo.registration.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by panthotanvir on 6/20/15.
 */
@WebServlet(name = "RegistrationController", urlPatterns = "/register")
public class RegistrationController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private User user;
    private UserDao userDao;

    public RegistrationController(){
        userDao = new UserDaoImp();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("RegistrationController is called");
        createRegistration(req);

        userDao.register(user);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/success.jsp");
        requestDispatcher.forward(req, resp);

    }
    private void createRegistration(HttpServletRequest req) throws IOException, ServletException {
        user = new User();

        user.setUser_name(req.getParameter("user_name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setPhoneNo(req.getParameter("phone"));
        user.setDob(req.getParameter("date"));


    }
}
