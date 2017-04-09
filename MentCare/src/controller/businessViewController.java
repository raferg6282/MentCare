package controller;

import application.MainFXApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.MissedAppointmentReportView;
import controller.addUserController;

public class businessViewController {

	Stage stage;
	Scene scene;
	Parent root;
	// always reference main method, and build constructor
	private MainFXApp main;

	public void setMain(MainFXApp mainIn) {
		main = mainIn;
	}

    @FXML
    private Button bizHistoryButton;

    @FXML
    private Button bizPredictionButton;

    @FXML
    private Button missedAppointReportButton;
    
    //added by butterscotch
    @FXML
    private Button userButton;

    @FXML
    void ClickButton(ActionEvent event) {
    	try {
			// finds what stage the button is in
			stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			// this gets the name of button
			String temp = ((Node) event.getSource()).getId().toString();
			// debugging
			System.out.println("(Node) event.getSource()).getId().toString() = " + temp);
			// this will allow for all buttons to go through one method, loading
			// the
			// right fxml file

			switch (temp) {
			case "missedAppointReportButton":
				MissedAppointmentReportView.MissedAppointmentReport(stage);
				break;
			case "userButton":
				//added by butterscotch*********************
				root = FXMLLoader.load(getClass().getResource("/view/addUserView.fxml"));
				addUserController con2=new addUserController();
				con2.setMain(main);
				break;

			}
			//added by butterscotch*********************************
			// sets fxml file as a scene
			scene = new Scene(root);
			// loads the scene on top of whatever stage the button is in
			stage.setScene(scene);
			//******************************************************
    	}catch (Exception e) {
			e.printStackTrace();
		}

    }
}