package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
	private int index;

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
    private Button defectConsoleB;
    
    @FXML
    private Button effortLogEditorB;
    
    @FXML
    private Button effortAndDefectB;
    
    @FXML
    private Button definitionsB;
    
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
    void definitionsClicked(ActionEvent event) throws IOException {

    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Definitions.fxml"));

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Definitions");

		DefinitionsController definitionsController = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void effortLogEditorClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EffortLogEditor.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Effort Logger Editor");
		
		EffortLogEditorController control = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();

    }
    
    @FXML
    void logManagerClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogManager.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Effort Logger");
		
		LogManagerController control = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void startClicked(ActionEvent event) {
    	index = EffortLog.getTotalLogs();
    	if (index <= 0) {
    		EffortLog.logs[0] = new EffortObj();
    		index = 0;
    	}
    	else {
    		EffortLog.logs[index] = new EffortObj();
    	}
    	
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Format the date and time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = currentDate.format(dateFormatter);
        String formattedTime = currentTime.format(timeFormatter);
    	
        //update effort object and label
        ((EffortObj)(EffortLog.logs[index])).setStartDate(formattedDate);
        ((EffortObj)(EffortLog.logs[index])).setStartTime(formattedTime);
    	clockLabel.setText("Clock is running");
        colorBox.setFill(Color.GREEN);

    }

    @FXML
    void stopClicked(ActionEvent event) {
    	if(projectB.getValue() != "Please Select" && lifeB.getValue() != "Please Select" && effortCat1.getValue() != "Please Select" && effortCat2.getValue() != "Please Select") {
	    	LocalDate endDate = LocalDate.now();
	
	        // Get the current time
	        LocalTime endTime = LocalTime.now();
	
	        // Format the date and time
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	        String formattedDate = endDate.format(dateFormatter);
	        String formattedTime = endTime.format(timeFormatter);
	        
	        //System.out.print(formattedDate + "\n" + formattedTime + "\n");
	        
	    	clockLabel.setText("Clock is stopped");
	    	colorBox.setFill(Color.DARKRED);
	    	
	    	//update effort log object
	    	((EffortObj)(EffortLog.logs[index])).setEndDate(formattedDate);
	        ((EffortObj)(EffortLog.logs[index])).setEndTime(formattedTime);
	        ((EffortObj)(EffortLog.logs[index])).setProject(projectB.getValue());
	        ((EffortObj)(EffortLog.logs[index])).setLifeCycle(lifeB.getValue());
	        ((EffortObj)(EffortLog.logs[index])).setCategory1(effortCat1.getValue());
	        ((EffortObj)(EffortLog.logs[index])).setCategory2(effortCat2.getValue());
	        
	        EffortLog.setTotalLogs(index + 1);}
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
