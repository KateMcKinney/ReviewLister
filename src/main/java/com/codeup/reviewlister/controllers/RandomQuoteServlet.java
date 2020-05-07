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

// ------------------  SERVLET FOR GETTING A RANDOM QUOTE  ------------------- //

// Only needs the "/quotes/random"
@WebServlet(name="RandomQuoteServlet", urlPatterns = "/quotes/random")
public class RandomQuoteServlet extends HttpServlet {

    // The doGet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Instantiate new Config object from our imported Config class (that we made)
        Config config = new Config();

        // Instantiate a new QuotesDao object (from our QuotesDao class/file?) using the Config object from above
        QuotesDao quotesDao = new QuotesDao(config);

        // gets a random quote using the random() method defined in our QuotesDao.java class
        Quote quote = quotesDao.random();

        // Bind the quote to the request object as "quote"
        request.setAttribute("quote", quote);

        // send the response along w/ the data to the show.jsp
        request.getRequestDispatcher("/WEB-INF/quotes/show.jsp").forward(request, response);

    }
}
