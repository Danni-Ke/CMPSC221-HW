package edu.psu.behrend.cs.dxk5418.lab12.main;

import java.sql.*;
import java.util.Scanner;

public class lab12 {

    private static Connection connection;
    public static void main(String[] args) {
        String sql = "SELECT city.Name FROM Country INNER JOIN City ON City.CountryCode=Country.Code WHERE Country.Name= ? ;";
        String answer = "";
        Scanner s = new Scanner(System.in);
        answer = s.nextLine();
        while (!answer.equalsIgnoreCase("quit"))
            {
                try
                {
                    //get connection to the datasSources by left click to copy the path
                    connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\DXK5418.PSU-ERIE.000\\Desktop\\src\\main\\resources\\World");

                    PreparedStatement pstmt = connection.prepareStatement( sql );
                    pstmt.setString( 1,answer );// start with 1

                    ResultSet rset = pstmt.executeQuery();

                    while ( rset.next() )
                    {
                        System.out.println( rset.getString( "Name" ));
                    }

                    rset.close();
                }
                catch ( SQLException e )
                {
                    e.printStackTrace();
                }
                answer=s.nextLine();

            }


        }


    }
