package controller;

import java.io.IOException;
import java.sql.Connection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.InitialDBConnection;
import model.TimeoutTimer;

public class ViewMenuController extends Application {
	
	public static Connection con;
	
	public static void main (String[] args){
		
		InitialDBConnection idb = new InitialDBConnection();
		Thread t = new Thread(idb);
		t.start();
		launch(args);
		
	}

    @FXML
    private Button BMView;

    @FXML
    private Button RecepView;

    @FXML
    private Button DocView;

    @FXML
    void switchToBMView(ActionEvent event) {
    	try {
    		Node node = (Node) event.getSource();
			GridPane BMView = (GridPane) FXMLLoader.load(getClass().getResource("/view/BusinessManagerView.fxml"));
			Scene scene2 = new Scene(BMView, 600, 600);
			Stage primaryStage = (Stage) node.getScene().getWindow();
			primaryStage.setScene(scene2);
			primaryStage.show();
			TimeoutTimer timeout = new TimeoutTimer(BMView, primaryStage, 10); //This method is overloaded; if you only use two arguments the time defaults
			timeout.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void switchToDocView(ActionEvent event) {
    	try {
    		Node node = (Node) event.getSource();
			Stage primaryStage = (Stage) node.getScene().getWindow();
			DoctorViewController docview = new DoctorViewController();
			docview.start(primaryStage);
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void switchToRecepView(ActionEvent event) {
    	try {
    		Node node = (Node) event.getSource();
			Stage primaryStage = (Stage) node.getScene().getWindow();
			ReceptionistViewController recepview = new ReceptionistViewController();
			recepview.start(primaryStage);
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
		GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("/view/ViewMenu.fxml"));
		Scene scene = new Scene(root,600,600);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		//Set page to time out after 10 seconds
		//TimeoutTimer timeout = new TimeoutTimer(root, scene, 10); //This method is overloaded; if you only use two arguments the time defaults
		//timeout.start();                                           //to 120 seconds. I'm using 10 seconds to make it easier to demo.
				
		
		primaryStage.setScene(scene);
		primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
