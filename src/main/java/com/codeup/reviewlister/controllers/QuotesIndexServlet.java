package com.codeup.reviewlister.controllers;

import com.codeup.reviewlister.Config;
import com.codeup.reviewlister.Quote;
import com.codeup.reviewlister.QuotesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// ------------------  SERVLET FOR GETTING ALL THE QUOTES  ------------------- //

// really only need "/quotes"
@WebServlet(name="QuotesIndexServlet", urlPatterns = "/quotes")
public class QuotesIndexServlet extends HttpServlet {

    //The doGet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Instantiate new Config object from our imported Config class (that we made)
        Config config = new Config();

        // Instantiate a new QuotesDao object (from our QuotesDao class/file?) using the Config object from above
        QuotesDao quotesDao = new QuotesDao(config);

        // gets all the quotes using the all() method defined in our QuotesDao.java class
        List<Quote> quotes = quotesDao.all();

        // Bind the quotes ArrayList<Quote> to the request object as "quotes"
        request.setAttribute("quotes", quotes);

        // send the response along w/ the data to the index.jsp
        request.getRequestDispatcher("/WEB-INF/quotes/index.jsp").forward(request, response);

    }
}