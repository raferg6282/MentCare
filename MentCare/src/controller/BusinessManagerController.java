package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BusinessManagerController {
	
	@FXML
    private Button LogOutButton;

    @FXML
    private Button MissedAppointmentButton;

    @FXML
    private Button StatButton;

    @FXML
    private Button ForecastButton;

    @FXML
    void LogOut(ActionEvent event) {
    	Node node = (Node) event.getSource();
    	Stage primaryStage = (Stage) node.getScene().getWindow();
    	ViewMenuController vmc = new ViewMenuController();
    	try {
			vmc.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void viewMissedReport(ActionEvent event) {

    }

    @FXML
    void viewStatReport(ActionEvent event) {

    }

}
