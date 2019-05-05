/**
 * @author Danni Ke
 * A Tic Tac Toe Game between two players
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.awt.*;

/**
 *
 */
public class Board extends Application {
    private GridPane  g=new GridPane();
    //private int numCell=9;
    private int count=1;
    private Button button1= new Button();
    private Button button2=new Button();
    private Button button3=new Button();
    private Button button4=new Button();
    private Button button5=new Button();
    private Button button6=new Button();
    private Button button7=new Button();
    private Button button8=new Button();
    private Button button9=new Button();
    private Label result= new Label(null);
    private Label hint=new Label(" It's Play X's turn!");
    private Button reset = new Button("RESET");
    private String stringX="";
    private String stringO="";
    private Label label1=new Label();
    private Label label2=new Label();
    private Label label3=new Label();
    private Label label4=new Label();
    private Label label5=new Label();
    private Label label6=new Label();
    private Label label7=new Label();
    private Label label8=new Label();
    private Label label9=new Label();


    /**
     * A method to set all button
     */

    public void setButton()
    {
        button1.setText("1");
        button2.setText("2");
        button3.setText("3");
        button4.setText("4");
        button5.setText("5");
        button6.setText("6");
        button7.setText("7");
        button8.setText("8");
        button9.setText("9");
        g.add(button1,1,1);
        g.add(button2,2,1);
        g.add(button3,3,1);
        g.add(button4,1,2);
        g.add(button5,2,2);
        g.add(button6,3,2);
        g.add(button7,1,3);
        g.add(button8,2,3);
        g.add(button9,3,3);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        setButton();
        reset.setOnAction(new resetHandler());
        button1.setOnAction(new Handler());
        button2.setOnAction(new Handler());
        button3.setOnAction(new Handler());
        button4.setOnAction(new Handler());
        button5.setOnAction(new Handler());
        button6.setOnAction(new Handler());
        button7.setOnAction(new Handler());
        button8.setOnAction(new Handler());
        button9.setOnAction(new Handler());

        g.setHgap(20);
        g.setVgap(20);
        g.setAlignment(Pos.CENTER);
        VBox v= new VBox(10,hint,g,reset,result);
        v.setAlignment(Pos.CENTER);
        Scene scene= new Scene(v);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setHeight(300);
        primaryStage.setWidth(240);
        primaryStage.show();

    }

    /**
     *
     * @param args
     */
    public static void main(String [] args)
    {
        launch(args);
    }

    /**
     * A listener to handle the click of reset
     */
    class resetHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {


            reset();

        }
    }
    public void reset()
    {
        count=1;
        g.getChildren().clear();
        setButton();
        hint.setText("It's Play X's turn!");
        result.setText(null);
        stringX="";
        stringO="";
    }

    /**
     *
     * @param s
     * @param num
     */
    public void addString(String s, int num)
    {
        if(s.equalsIgnoreCase("X"))
        {
            stringX+=Integer.toString(num);
        }
        else if(s.equalsIgnoreCase("O"))
        {
            stringO+=Integer.toString(num);
    }
    }

    /**
     * check if O or X is detected
     * @param event
     * @param s
     */
    public void ifOorX(ActionEvent event,String s)
    {
        if(event.getSource()==button1) {
            g.getChildren().remove(button1);
            label1.setText(s);
            g.add(label1,1, 1);
            addString(s,1);

        }
        else if(event.getSource()==button2) {
            g.getChildren().remove(button2);
            label2.setText(s);
            g.add(label2, 2, 1);
            addString(s,2);

        }
        else if(event.getSource()==button3) {
            g.getChildren().remove(button3);
            label3.setText(s);
            g.add(label3, 3, 1);
            addString(s,3);
        }
        else if(event.getSource()==button4) {
            g.getChildren().remove(button4);
            label4.setText(s);
            g.add(label4, 1, 2);
            addString(s,4);
        }
        else if(event.getSource()==button5) {
            g.getChildren().remove(button5);
            label5.setText(s);
            g.add(label5, 2, 2);
            addString(s,5);

        }
        else if(event.getSource()==button6) {
            g.getChildren().remove(button6);
            label6.setText(s);
            g.add(label6, 3, 2);
            addString(s,6);

        }
        else if(event.getSource()==button7) {
            g.getChildren().remove(button7);
            label7.setText(s);
            g.add(label7, 1, 3);
            addString(s,7);
        }
        else if(event.getSource()==button8) {
            g.getChildren().remove(button8);
            label8.setText(s);
            g.add(label8, 2, 3);
            addString(s,8);

        }
        else if(event.getSource()==button9) {
            g.getChildren().remove(button9);
            label9.setText(s);
            g.add(label9, 3, 3);
            addString(s,9);


        }

    }

    /**
     * Check if one of the players won or it's a tie
     * @param s
     * @return
     */
    public boolean winorTie(String s)
    {

        if(s.contains("1")&&s.contains("2")&&s.contains("3"))
            return true;
        else if (s.contains("4")&&s.contains("5")&&s.contains("6"))
            return true;
        else if(s.contains("7")&&s.contains("8")&&s.contains("9"))
            return true;
        else if (s.contains("1")&&s.contains("4")&&s.contains("7"))
            return true;
        else if(s.contains("2")&&s.contains("5")&&s.contains("8"))
            return true;
        else if (s.contains("3")&&s.contains("6")&&s.contains("9"))
            return true;
        else if(s.contains("1")&&s.contains("5")&&s.contains("9"))
            return true;
        else if (s.contains("4")&&s.contains("5")&&s.contains("6"))
            return true;
        else if(s.contains("3")&&s.contains("5")&&s.contains("7"))
            return true;
        else
            return false;




    }

    /**
     * inable the button not inclued the choice by users, so that they are unable to choose it
     */
    public void inableButton()
    {

        String t=stringX+stringO;
        if(!t.contains("1"))
            g.getChildren().remove(button1);
        if(!t.contains("2"))
            g.getChildren().remove(button2);
        if(!t.contains("3"))
            g.getChildren().remove(button3);
        if(!t.contains("4"))
            g.getChildren().remove(button4);
        if(!t.contains("5"))
            g.getChildren().remove(button5);
        if(!t.contains("6"))
            g.getChildren().remove(button6);
        if(!t.contains("7"))
            g.getChildren().remove(button7);
        if(!t.contains("8"))
            g.getChildren().remove(button8);
        if(!t.contains("9"))
            g.getChildren().remove(button9);



    }

    /**
     *
     */
    class Handler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {


            if(count%2==1)
            {
                hint.setText(" It's Play O's turn!");
                ifOorX(event, "X");
                if(stringX.length()>=3) {
                    if (winorTie(stringX)) {
                        result.setText("PlayerX won!");
                        hint.setText(null);
                        inableButton();
                        //g.getChildren().clear();
                    }
                    else if(count>8) {
                        result.setText("Draw(TIE)!Please click reset to start over!");
                        hint.setText(null);
                        inableButton();
                        //g.getChildren().clear();
                    }
                }
                else
                    result.setText(null);

            }
            else
            {
                hint.setText(" It's Play X's turn!");
                ifOorX(event,"O");
                if(stringO.length()>=3) {
                    if (winorTie(stringO)) {
                        result.setText("PlayerO won!");
                        inableButton();
                        hint.setText(null);
                        //g.getChildren().clear();

                    }
                    else if(count>8) {
                        result.setText("Draw(TIE)!Please click reset to start over!");
                        hint.setText(null);
                        inableButton();
                        //g.getChildren().clear();
                    }
                }
                else
                    result.setText(null);

            }
            count++;


        }
    }

}
