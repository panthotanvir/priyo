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
        log.debug("form paise", req.getParameter("email"));
        createRegistration(req);
        log.debug("dekhi ", user.getUser_name());
        userDao.register(user);


    }
    private void createRegistration(HttpServletRequest req) throws IOException, ServletException {
        user = new User();
        log.debug("akhne ki dhukse",req.getParameter("user_name"));
        user.setUser_name(req.getParameter("user_name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setPhoneNo(req.getParameter("phone"));
        user.setDob(req.getParameter("date"));
        log.debug("jdi dhuke tahole ", user.getUser_name());

    }
}
