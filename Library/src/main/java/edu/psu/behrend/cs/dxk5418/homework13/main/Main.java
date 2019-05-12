package edu.psu.behrend.cs.txr185.main;

import java.sql.*;

public class Main
{
    private static Connection connection;

    public static void main(String[] args)
    {
        String sql = "SELECT * FROM Country WHERE Name = ?";

        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/trossi/Documents/Penn State/Spring 2018/CMPSC 221/Week 13/Lecture/jdbcDemo/src/main/resources/World");

            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setString( 1,"Netherlands" );

            ResultSet rset = pstmt.executeQuery();

            while ( rset.next() )
            {
                System.out.println( rset.getString( "Name" ) + ": " + rset.getInt( "Population" ) );
            }

            rset.close();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }

        
    }
}
