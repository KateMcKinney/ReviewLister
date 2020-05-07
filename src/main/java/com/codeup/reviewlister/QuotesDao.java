package com.codeup.reviewlister;
import com.codeup.reviewlister.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

// ------------------  THE DAO  (there doesn't appear to be a DAO Interface) ------------------- //

public class QuotesDao {
    // Database driver connection object
    private Connection connection = null;

    // Database driver using Config info to access the data
    public QuotesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    // Info from Config file
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    // ----------------------  Method that returns all the quotes
    public List<Quote> all() {
        //ArrayList of Quotes (initially empty)
        List<Quote> quotes = new ArrayList<>();

        // MySQL query to select all quotes from the quotes table
        String query = "SELECT * FROM quotes";

        try {
            // Statement object using connection object from line 13
            Statement st = connection.createStatement();

            // ResultSet object using Statement object "st" from above to execute the query on line 36
                // and store the fetched data inside the "rs" object
            ResultSet rs = st.executeQuery(query);

            // Loop going through each returned result from the ResultSet object from above
            while (rs.next()) {
                // adding each rs line to the previously empty quotes ArrayList<Quote> from line 33
                quotes.add(
                    // each new rs line is translated into a Quote object to be put in the ArrayList<Quote> by extracting the info
                    new Quote(
                        // extracts the info from the column labeled "id" of type long
                        rs.getLong("id"),
                        // extracts the info from the column labeled "author" of type String
                        rs.getString("author"),
                        // extracts the info from the column labeled "quote" of type String
                        rs.getString("quote")
                    )
                );
            }
        // If it fucks up it'll print the stack trace
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returns the ArrayList<Quote> that now has all the Quote objects that we built on line 47 in it
        return quotes;
    }


    // ----------------------  Method that returns a random quote
    public Quote random() {
        // calls the above method to store the ArrayList<Quote> named quotes into another ArrayList<Quote> also named quotes
        List<Quote> quotes = all();
        // Generates a random int between 0 and quotes.size (length of quotes ArrayList)
        int randomIndex = (int) Math.floor(Math.random() * quotes.size());
        // returns the Quote from the quotes ArrayList at the randomly selected index made on line 75
        return quotes.get(randomIndex);
    }
}
