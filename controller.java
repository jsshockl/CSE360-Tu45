package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class controller {
	
	private Scene scene;
	private Stage stage;

	ObservableList<String> projectList = FXCollections.observableArrayList("Business Project","Development Project");
	ObservableList<String> lifeCycleList = FXCollections.observableArrayList("Planing", "Information Gathering","Infromation Understanding","Verifying",
			"Outlining","Drafting","Finalizing","Team Meeting","Coach Meeting","Stakeholder Meeting");
	ObservableList<String> effortCat1List = FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others");
	ObservableList<String> effortCat2List= FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan",
			"Detailed Design Plan", "Implementation Plan");

	@FXML
	private Label clockLabel;
	
	@FXML
    private Rectangle colorBox;
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> lifeB;

    @FXML
    private ChoiceBox<String> projectB;
    
    @FXML
    private ChoiceBox<String> effortCat1;

    @FXML
    private ChoiceBox<String> effortCat2;

    @FXML
    private Button startB;

    @FXML
    private Button stopB;
    
    @FXML
    private Button logManagerB;
    
    @FXML
    void logManagerClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogManager.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Log Manager");
		
		LogManagerController control = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void defectConsoleClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DefectConsole.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Defect Console");
		
		DefectConsoleManager defectControl = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void startClicked(ActionEvent event) {
    	
    	if(projectB.getValue() != "Please Select" && lifeB.getValue() != "Please Select" && effortCat1.getValue() != "Please Select" && effortCat2.getValue() != "Please Select") {
    		clockLabel.setText("Clock is running");
        	colorBox.setFill(Color.GREEN);
    	}
    }

    @FXML
    void stopClicked(ActionEvent event) {
    	
    	clockLabel.setText("Clock is stopped");
    	colorBox.setFill(Color.DARKRED);
    }

    @FXML
    void initialize() {
    	
    	projectB.setValue("Please Select");
    	lifeB.setValue("Please Select");
    	effortCat1.setValue("Please Select");
    	effortCat2.setValue("Please Select");
    	
    	projectB.setItems(projectList);
    	lifeB.setItems(lifeCycleList);
    	effortCat1.setItems(effortCat1List);
    	effortCat2.setItems(effortCat2List);
    	
    }

}
