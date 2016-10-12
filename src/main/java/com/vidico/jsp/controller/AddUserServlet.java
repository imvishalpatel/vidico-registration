/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidico.jsp.controller;

import com.mongodb.MongoClient;
import com.vidico.jsp.dao.UserDAO;
import com.vidico.jsp.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vishal
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("") || username == null || password.equals("") || password == null) {
            request.setAttribute("error", "Mandatory Parameters Missing");
            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/signup.jsp");
            rd.forward(request, response);
        } else {
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");

            UserDAO userDao = new UserDAO(mongo);
            userDao.creatUser(u);
            System.out.println("User created successfully with id=" + u.getId());
            request.setAttribute("success", "Person Added Successfully");

            RequestDispatcher rd = getServletContext().getRequestDispatcher(
                    "/login.jsp");
            rd.forward(request, response);
        }
    }
}
