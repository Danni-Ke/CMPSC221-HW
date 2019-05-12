/**
 * @author Danni Ke
 * Homework13
 * a Lib Gui allow users to search and change the data of books inside
 */
package edu.psu.behrend.cs.dxk5418.homework13.main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

/**
 * GU
 */
public class Library extends Application {

    private int count=0;
    private ArrayList<String> forTitle= new ArrayList<String>();
    private ArrayList<String> forFirstName= new ArrayList<String>();
    private ArrayList<String> forLastName= new ArrayList<String>();
    private ArrayList<String> forPrice = new ArrayList<String>();
    private ArrayList<String> forNote=new ArrayList<String>();
    private ArrayList<String> forPublisher=new ArrayList<String>();
    private static Connection connection;
    //Button
//    private Button Save = new Button("Save");

    private Button Search = new Button("Search");
    private Button Next = new Button("Next");
    private Button Previous = new Button("Previous");
    //Top Section
    private Label enter = new Label("Enter Author name of Title to start search!");
    private TextField searchBytitle = new TextField();
    private TextField searchByauthor = new TextField();
    private Label top = new Label("Top Section");
    private Label Bytitle = new Label("Title :");
    private Label Byauthor = new Label("Author name :");
    //Bottom Section
    private Label result = new Label("RESULT(click NEXT or PREVIOUS to save the change of last/first term)");
    private static TextField title = new TextField();
    private Label Title = new Label("Title");
    private static TextField firstName = new TextField();
    private Label FirstName = new Label("First name");
    private static TextField lastName = new TextField();
    private Label LastName = new Label("Last name");
    private static TextField price = new TextField();
    private Label Price = new Label("Price");
    private static TextField note = new TextField();
    private Label Note = new Label("Note");
    private static TextField publisher= new TextField();
    private Label Publisher= new Label("Publisher");

    public void start(Stage primaryStage) throws Exception {


        //Top Section
        HBox TopSection1 = new HBox(60, Bytitle, searchBytitle);
        HBox TopSection2 = new HBox(10, Byauthor, searchByauthor);
        VBox TopSection3 = new VBox(10, enter, TopSection1, TopSection2);
        TopSection3.setAlignment(Pos.CENTER);
        //Bottom Section
        HBox BottonSection1 = new HBox(40, Title, title);
        HBox BottonSection2 = new HBox(10, FirstName, firstName);
        HBox BottonSection3 = new HBox(10, LastName, lastName);
        HBox BottonSection4 = new HBox(40, Price, price);
        HBox BottonSection5 = new HBox(40, Note, note);
        HBox BottonSection7 = new HBox(20,Publisher,publisher);
        VBox BottonSextion6 = new VBox(10, BottonSection1, BottonSection2, BottonSection3, BottonSection4, BottonSection5,BottonSection7);
        BottonSextion6.setAlignment(Pos.CENTER_LEFT);
        //Button

        HBox button = new HBox(20, Previous, Next);
        button.setAlignment(Pos.CENTER);
        VBox all = new VBox(20, TopSection3,Search, result, BottonSextion6, button);//save
        all.setAlignment(Pos.CENTER);
        all.setPadding(new Insets(20, 20, 20, 20));
        Scene s = new Scene(all);
        //button action
       // Save.setOnAction(new handlerforsave());

        Search.setOnAction(new handler1());
        Next.setOnAction(new handlerfornextandprevious());
        Previous.setOnAction(new handlerfornextandprevious());
        primaryStage.setTitle("Library");
        primaryStage.setHeight(550);
        primaryStage.setWidth(450);
        primaryStage.setScene(s);
        primaryStage.show();
    }


//    public class handlerforsave implements EventHandler<ActionEvent>
//    {
//        public void handle(ActionEvent event)
//        {
//            String sql1="UPDATE authors SET au_fname=?,au_lname=? WHERE au_fname=?";
//            String sql2="UPDATE titles SET price=?,notes=?,title=? WHERE title=?";
//            String sql3="UPDATE publishers SET pub_name=? WHERE pub_name=?";
//            try {
//                connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\pineappleman520\\Desktop\\homework13\\src\\main\\resources\\mybookstore");
//                PreparedStatement pps=connection.prepareStatement(sql1);
//                pps.setString(1,firstName.getText());
//                pps.setString(2,lastName.getText());
//                pps.setString(3,forFirstName.get(count));
//                pps.executeUpdate();
//                PreparedStatement pps2=connection.prepareStatement(sql2);
//                pps2.setString(1,price.getText());
//                pps2.setString(2,note.getText());
//                pps2.setString(3,title.getText());
//                pps2.setString(4,forTitle.get(count));
//                pps2.executeUpdate();
//                PreparedStatement pps3=connection.prepareStatement(sql3);
//                pps3.setString(1,publisher.getText());
//                pps3.setString(2,forPublisher.get(count));
//                pps3.executeUpdate();
//
//                System.out.println("Database updated successfully ");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

    /**
     * handler for next and previous
     */

    public class handlerfornextandprevious implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
                String sql1="UPDATE authors SET au_fname=?,au_lname=? WHERE au_fname=?";
                String sql2="UPDATE titles SET price=?,notes=?,title=? WHERE title=?";
                String sql3="UPDATE publishers SET pub_name=? WHERE pub_name=?";
//                if(count==-1)
//                    count=0;
//                if(count>=forTitle.size())
//                    count=forTitle.size()-1;
                if (event.getSource() == Next) {
                    try {
                        connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\pineappleman520\\Desktop\\homework13\\src\\main\\resources\\mybookstore");
                        PreparedStatement pps=connection.prepareStatement(sql1);
                        pps.setString(1,firstName.getText());
                        pps.setString(2,lastName.getText());
                        pps.setString(3,forFirstName.get(count));
                        pps.executeUpdate();
                        PreparedStatement pps2=connection.prepareStatement(sql2);
                        pps2.setString(1,price.getText());
                        pps2.setString(2,note.getText());
                        pps2.setString(3,title.getText());
                        pps2.setString(4,forTitle.get(count));
                        pps2.executeUpdate();
                        PreparedStatement pps3=connection.prepareStatement(sql3);
                        pps3.setString(1,publisher.getText());
                        pps3.setString(2,forPublisher.get(count));
                        pps3.executeUpdate();
                        connection.close();
                        if(connection.isClosed())
                            System.out.println("Connection Closed");
                        forTitle.set(count,title.getText());
                        forLastName.set(count,lastName.getText());
                        forFirstName.set(count,firstName.getText());
                        forPrice.set(count,price.getText());
                        forNote.set(count,note.getText());
                        forPublisher.set(count,publisher.getText());

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    count++;
                    if (count < forTitle.size())
                    {
                        title.setText(forTitle.get(count));
                        firstName.setText(forFirstName.get(count));
                        lastName.setText(forLastName.get(count));
                        price.setText(forPrice.get(count));
                        note.setText(forNote.get(count));
                        publisher.setText(forPublisher.get(count));

                    }
                    else {
                        count=forTitle.size()-1;
                    }
                }
                if(event.getSource()==Previous)
                {
                    try {
                    connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\pineappleman520\\Desktop\\homework13\\src\\main\\resources\\mybookstore");
                    PreparedStatement pps=connection.prepareStatement(sql1);
                    pps.setString(1,firstName.getText());
                    pps.setString(2,lastName.getText());
                    pps.setString(3,forFirstName.get(count));
                    pps.executeUpdate();
                    PreparedStatement pps2=connection.prepareStatement(sql2);
                    pps2.setString(1,price.getText());
                    pps2.setString(2,note.getText());
                    pps2.setString(3,title.getText());
                    pps2.setString(4,forTitle.get(count));
                    pps2.executeUpdate();
                    PreparedStatement pps3=connection.prepareStatement(sql3);
                    pps3.setString(1,publisher.getText());
                    pps3.setString(2,forPublisher.get(count));
                    pps3.executeUpdate();
                    connection.close();
                    if(connection.isClosed())
                            System.out.println("Connection Closed");
                    forTitle.set(count,title.getText());
                    forLastName.set(count,lastName.getText());
                    forFirstName.set(count,firstName.getText());
                    forPrice.set(count,price.getText());
                    forNote.set(count,note.getText());
                    forPublisher.set(count,publisher.getText());

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                    count--;
                    if(count>=0)
                    {
                        title.setText(forTitle.get(count));
                        firstName.setText(forFirstName.get(count));
                        lastName.setText(forLastName.get(count));
                        price.setText(forPrice.get(count));
                        note.setText(forNote.get(count));
                        publisher.setText(forPublisher.get(count));
                        System.out.println(count);

                    }
                    else
                    {
                        count=0;
                    }
                }

        }
    }
    public class handler1 implements EventHandler<ActionEvent>
    {

        public void handle(ActionEvent event) {
            String titleS=null;
            String fnameS=null;
            String lnameS=null;
            String sql="SELECT title,au_fname,au_lname,price,notes,pub_name FROM titles INNER JOIN authors ON titles.au_id=authors.au_id INNER JOIN publishers ON titles.pub_id=publishers.pub_id WHERE au_fname=? OR au_lname=? OR titles.title=? ";
            String sql1="UPDATE authors SET au_fname=?,au_lname=? WHERE au_fname=?";
            String sql2="UPDATE titles SET price=?,notes=?,title=? WHERE title=?";
            try {
                //Store data in to sql
                connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\pineappleman520\\Desktop\\homework13\\src\\main\\resources\\mybookstore");
                //initial all the used object and arraylist
                forTitle.clear();
                forLastName.clear();
                forFirstName.clear();
                forPrice.clear();
                forNote.clear();
                forPublisher.clear();
                count=0;
                String fullname= searchByauthor.getText();
                if(fullname.contains(" "))
                {
                    titleS=searchBytitle.getText();
                    fnameS=fullname.substring(0,fullname.indexOf(" "));
                    lnameS=fullname.substring(fullname.indexOf(" ")+1);
                }
                else {
                    titleS = searchBytitle.getText();
                    fnameS = searchByauthor.getText();
                    lnameS = searchByauthor.getText();
                }

                PreparedStatement pstmt= connection.prepareStatement(sql);
                pstmt.setString(1,fnameS);// the parameter is the number of keyword we are going to search
                pstmt.setString(2,lnameS);
                pstmt.setString(3,titleS);

                ResultSet resultSet=pstmt.executeQuery();
                while(resultSet.next())
                {
                    forTitle.add(resultSet.getString("title"));
                    forFirstName.add(resultSet.getString("au_fname"));
                    forLastName.add(resultSet.getString("au_lname"));
                    forPrice.add(resultSet.getString("price"));
                    forNote.add(resultSet.getString("notes"));
                    forPublisher.add(resultSet.getString("pub_name"));
                }
                resultSet.close();
                connection.close();
                if(connection.isClosed())
                    System.out.println("Connection Closed");
                title.setText(forTitle.get(count));
                firstName.setText(forFirstName.get(count));
                lastName.setText(forLastName.get(count));
                price.setText(forPrice.get(count));
                note.setText(forNote.get(count));
                publisher.setText(forPublisher.get(count));
                //test bench
                searchByauthor.setText("");
                searchBytitle.setText("");

            } catch (SQLException e1) { e1.printStackTrace(); }

        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
