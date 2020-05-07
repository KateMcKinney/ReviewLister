package com.codeup.reviewlister.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

// ------------------  SERVLET DISPLAYING "HELLO WORLD"  ------------------- //

// really only needs the "/" part
@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/")
// Each servlet needs a doGet at LEAST so that it can send the user to a particular jsp
public class HelloWorldServlet extends HttpServlet {

    //the doGet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // uses the response to print Hello World on the jsp, in the future this is bad practice
            // because it mixes the Control and View (of MVC)
        response.getWriter().println("<h1>Hello, World!</h1>");
    }
}
