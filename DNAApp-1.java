/**
 * @author Danni Ke
 * A program that can used to process the DNA file!!!
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jdk.management.resource.internal.ResourceNatives;

import java.awt.dnd.DnDConstants;
import java.io.*;
import java.util.*;

import javax.swing.*;
import java.lang.reflect.Array;


public class DNAApp extends Application {


    private Button compute;
    private RadioButton option1, option2, option3;
    private CheckBox sendFile;
    private Label label = new Label(null);
    private Label label1= new Label("Window will be closed after you sent the file to txt!");
    private FileChooser f;
    private File stuff;
    private String fileContent;
    private ArrayList<String> DNAsection = new ArrayList<String>();
    private ArrayList<String> header = new ArrayList<String>();
    private String result="";

    @Override
    /**
     *
     */
    public void start(Stage primaryStage) throws Exception {


        f = new FileChooser();
        stuff = f.showOpenDialog(primaryStage);
        StringCatcher();
        //Read the file in another way
        //filename = stuff.toString();//only read the path of the file
//        StringBuilder contentBuilder= new StringBuilder();
//        BufferedReader br= new BufferedReader( new FileReader(stuff.getPath()));
//        String sCurrentLine;
//        while((sCurrentLine=br.readLine())!= null)
//        {
//            contentBuilder.append(sCurrentLine);
//        }
//        fileContent=contentBuilder.toString();
        compute = new Button("COMPUTE");
        compute.setOnAction(new handler());
        option1 = new RadioButton("Protein coding regions");
        option2 = new RadioButton("Protein coding regions translated into mRNA");
        option3 = new RadioButton("Protein coding regions translated into a nucleotide sequence");
        sendFile = new CheckBox("Sent to File");
        ToggleGroup t = new ToggleGroup();
        this.option1.setToggleGroup(t);
        this.option2.setToggleGroup(t);
        this.option3.setToggleGroup(t);
        VBox v = new VBox(20,label1,option1, option2, option3, sendFile, compute, label);
        v.setPadding(new Insets(20, 20, 50, 20));
        v.setAlignment(Pos.TOP_LEFT);
        Scene s = new Scene(v);
        primaryStage.setWidth(400);
        primaryStage.setHeight(600);
        primaryStage.setScene(s);
        primaryStage.setTitle("Genetic Hero");
        primaryStage.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) { launch(args); }
    /**
     *no parameter ,the purpose of the method is to handle the read in file and break up the into several pieces
     * Also throw out exception if the file is not founded!
     */
    public void StringCatcher() {
        try {
            Scanner scanner = new Scanner(stuff);
            String s = "";
            while (scanner.hasNextLine()) {

                fileContent += scanner.nextLine();
            }
            String[] items = fileContent.split(">");

            for (String item : items) {
                String node = item.substring(item.indexOf("2004") + 4).replaceAll("N", "A").replaceAll("X", "A");
                DNAsection.add(node);
                header.add(item.substring(0, item.indexOf("2004") + 4));
            }
            DNAsection.remove(0);//remove the space
            header.remove(0);
        } catch (FileNotFoundException e) {
            label.setText("File not found");
        }
    }
    /**
     *
     * @param s string that will be processed to find out the codon region
     * @return an Arraylists
     */
    //transfor the DNA to Protein coding regions
    public ArrayList<String> findCodingRegion(String s) {
        ArrayList<String> atr = new ArrayList<>();
        if (s.length() % 3 == 1)
            s += "  ";//the size of the string will not be always the 3 times
        if (s.length() % 3 == 2)
            s += " ";
        //System.out.println(s.length());
        String string = "";
        String code = "";
        for (int i = 0; i < s.length(); i += 3) {
            string = s.substring(i, i + 3);
            if (string.equalsIgnoreCase("ATG")) {
                code = "";
                code += "ATG";
            }
            else if ((code.length()>3)&&(string.equalsIgnoreCase("TAG")) && (code.substring(0, 3).equalsIgnoreCase("ATG"))) {
                code += "TAG";
                atr.add(code);
                code = "";
            }
            else if ((code.length()>3)&&(string.equalsIgnoreCase("TGA")) && (code.substring(0, 3).equalsIgnoreCase("ATG"))) {
                code += "TGA";
                atr.add(code);
                code = "";
            }
            else if ((code.length()>3)&&(string.equalsIgnoreCase("TAA")) && (code.substring(0, 3).equalsIgnoreCase("ATG"))) {
                code += "TAA";
                atr.add(code);
                code = "";
            }
            else {
                code += string;
            }

        }

        return atr;
    }
    /**
     * @param a an ArrayList
     * @return return a String can be put into the label
     */
    public String print(ArrayList<String> a) {
        String b= new String();
        for(int i=0;i<a.size();i++) {

            b+=a.get(i);
            if(i<a.size()-1)
                b+=",";
        }
        return b;
    }

    /**
     * @param array An arraylist
     * @return output a result Arraylist
     */
    public ArrayList<String> findmRNA(ArrayList<String> array){

        ArrayList<String> RNAsection= new ArrayList<>();
        String newRNA="";
        for(int i=0;i<array.size();i++)
        {
            for(int j=0;j<array.get(i).length();j++)
            {
              if(array.get(i).charAt(j)=='A')
                  newRNA+="U";
              else if(array.get(i).charAt(j)=='T')
                    newRNA+="A";
              else if(array.get(i).charAt(j)=='C')
                    newRNA+="G";
              else if(array.get(i).charAt(j)=='G')
                    newRNA+="C";
              else if(array.get(i).charAt(j)=='X')
                  newRNA+="A";
              else if(array.get(i).charAt(j)=='N')
                  newRNA+="A";
            }
            RNAsection.add(newRNA);
            newRNA="";
        }
        return RNAsection;
    }

    /**
     *
     * @param array An arraylist
     * @return output a result Arraylist
     */
    public ArrayList<String> findNucleotideSeq(ArrayList<String> array) {
        ArrayList<String> Nucleotide= new ArrayList<>();
        String Nucleo="";
        String string="";
        DNADictionary d=new DNADictionary();
        for(int i=0;i<array.size();i++)
        {
            for(int j=0;j<array.get(i).length();j+=3) {

                string= array.get(i).substring(j,j+3);
                Nucleo+=d.getAcidThreeLetter(string);
                Nucleo+=" - ";
            }
            Nucleotide.add(Nucleo);
            Nucleo="";

        }
        return Nucleotide;

    }

    /**
     * Button listener
     */
    public class handler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if(option1.isSelected()) { result="";
                for(int i=0;i<DNAsection.size();i++)
                {
                    result+=header.get(i)+"\n"+"Output "+(i+1)+ " ("+print(findCodingRegion(DNAsection.get(i)))+ ")>\n\n";

                }
                label.setText(result);
                //System.out.println(findCodingRegion(DNAsection.get(0)).get(0).length());
            } else if(option2.isSelected()) {
                result = "";
                ArrayList<String> RNA= new ArrayList<String>();
                for (int i = 0; i < DNAsection.size(); i++) {
                    RNA=findmRNA(findCodingRegion(DNAsection.get(i)));
                    result += header.get(i) + "\n" + "Output " + (i + 1) + " (" + print(RNA) + ")>\n\n";
                }
                label.setText(result);
               // System.out.println(RNA.get(0).length());
            } else if(option3.isSelected()) {
                result="";
                ArrayList<String> Nucle= new ArrayList<String>();
                for (int i = 0; i < DNAsection.size(); i++) {
                    Nucle=findNucleotideSeq(findCodingRegion(DNAsection.get(i)));
                    result += header.get(i) + "\n" + "Output " + (i + 1) + " (" + print(Nucle) + ")>\n\n";
                }
                label.setText(result); }
            if(sendFile.isSelected())
            {
                try {
                    label.setText("File already sent to HW0 successfully!");
                    //PrintWriter out= new PrintWriter(new FileWriter("C:\\Users\\pineappleman520\\Desktop\\HW0\\output.txt"));
                    PrintWriter out= new PrintWriter(new FileWriter("output.txt"));
                    out.print(result);
                    out.close();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
