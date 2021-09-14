//questioon4.class

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Scanner;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;


public class Ques5 extends Application{

	@Override
	 public void start(Stage stage) {
		
Label labelresponse= new Label();
Button button= new Button("Submit");
ListView<String> listview= new ListView<>();
listview.getItems().addAll("Delhi", "Gujarat", "Maharashtra","Assam", "Orissa","Tamil Nadu", "Karnataka", "Sikkim", "Goa","Nagaland","Arunachal Pradesh","Meghalaya","Tripura","Uttrakhand", "Bihar", "Jharkhand", "Manipur");
listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//all the components
	 Label text1= new Label("Select state:");
	 TextField state = new TextField();
	 Button btn2 = new Button("Get Data");
         
	 
	 Label  text3= new Label("No. of men:");
         Label text4 = new Label("Percentage of men:");
	 Label text5 = new Label("No. of women:");
         Label text6 = new Label("Percentage of women:");
         Label text7 = new Label("No. of children:");
         Label text8 = new Label("Percentage of children:");
         
	 TextField men = new TextField();
	 TextField permen = new TextField();
         TextField women= new TextField();
         TextField perwomen = new TextField();
         TextField child = new TextField();
         TextField perchild = new TextField();
	
	 	//adding the components to the grid
	 GridPane grid = new GridPane();
         
	 grid.setMinSize(800, 600);
	 grid.setVgap(5);
	 grid.setHgap(5);
	 grid.setAlignment(Pos.CENTER);
         grid.add(listview,1,0);
         grid.add(button, 1, 2);
         grid.add(labelresponse, 0, 18);
         
	 grid.add(text1, 0, 0);
	 grid.add(text3, 0, 3);
	 grid.add(men, 1, 3);
         grid.add(text4, 0, 5);
	 grid.add(permen, 1, 5);
         grid.add(text5, 0, 7);
	 grid.add(women, 1, 7);
	 grid.add(text6, 0,9);
         grid.add(perwomen, 1, 9);
         grid.add(text7, 0, 11);
	 grid.add(child, 1, 11);
         grid.add(text8, 0, 13);
	 grid.add(perchild, 1, 13);
	 

	 /*btn2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
	{
	 public void handle(ActionEvent event) {
		 states md = new states("" ,0, 0, 0);
		 
		 try {
			md.addData(Integer.parseInt(houseNo.getText()),Integer.parseInt(meterReading.getText()));
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Label value = new Label("Values inserted! ");
	 value.setStyle("-fx-font: normal bold 20px 'Times New Roman' ");
	 grid.add(value,1,3);
	 }
	 });*/
	 button.setOnAction(e -> 
{
  ObservableList<String> topics;
    String list= "";
    topics = listview.getSelectionModel().getSelectedItems();

for (String m : topics)
{
    list += m + ", ";
} 
int pos= list.lastIndexOf(",");
String selection= list.substring(0, pos);
states md = new states("", 0, 0, 0);
			 
			 try {
				ArrayList<Object> value=md.getData(selection);
				men.setText(""+value.get(0));
                                permen.setText(""+value.get(1));
                                women.setText(""+value.get(2));
                                perwomen.setText(""+value.get(3));
                                child.setText(""+value.get(4));
                                perchild.setText(""+value.get(5));
                                
				
			} catch (ClassNotFoundException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			} catch (SQLException a) {
				// TODO Auto-generated catch block
				a.printStackTrace();
			}
});
	 /*btn2.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
                    
		 public void handle(ActionEvent event) {
			 states md = new states("", 0, 0, 0);
			 
			 try {
				ArrayList<Object> value=md.getData(selection);
				men.setText(""+value.get(0));
                                permen.setText(""+value.get(1));
                                women.setText(""+value.get(2));
                                perwomen.setText(""+value.get(3));
                                child.setText(""+value.get(4));
                                perchild.setText(""+value.get(5));
                                
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 });*/

	 text1.setStyle("-fx-font: normal bold 20px 'Times New Roman' ");
	 button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
         
	 Scene scene = new Scene(grid);
	 stage.setTitle("Question 5");
	 stage.setScene(scene);
	 stage.show();
	 }
	
	public static void main(String[] args) {
		launch(args);
	}
	
}

























	
	

