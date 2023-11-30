package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EffortLogEditorController {
	
	private Stage stage;
	private Scene scene;
	
	ObservableList<String> projectList = FXCollections.observableArrayList("Business Project","Development Project");
	ObservableList<String> effortCategory = FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others");
	ObservableList<String> lifeCycleList = FXCollections.observableArrayList("Planing", "Information Gathering","Infromation Understanding","Verifying",
			"Outlining","Drafting","Finalizing","Team Meeting","Coach Meeting","Stakeholder Meeting");

    @FXML
    private Button clearEffortButton;
    
    @FXML
    private Button updateEntryButton;
    
    @FXML
    private Button proceedToEffortB;

    @FXML
    private ChoiceBox<String> effortCategoryChoiceBox;
    
    @FXML
    private ChoiceBox<String> lifeCycleStepChoiceBox;
    
    @FXML
    private ChoiceBox<String> selectEffortEntryChoiceBox;
    
    @FXML
    private ChoiceBox<String> selectProjectChoiceBox;
    
    @FXML
    private TextField newDate;

    @FXML
    private TextField newStartTime;

    @FXML
    private TextField newStopTime;
    

    @FXML
    void proceedToEffortClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("effort.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Effort Logger");
		
		controller control = fxmlLoader.getController();
		//control.setTime(this);
		stage.setScene(scene);
		stage.show();


    }
    
    @FXML
    void clearEffortClicked(ActionEvent event) {
    	
    	newDate.setText("");
    	newStartTime.setText("");
    	newStopTime.setText("");
    	effortCategoryChoiceBox.setValue("");
    	lifeCycleStepChoiceBox.setValue("");
    	selectProjectChoiceBox.setValue("");
    	selectEffortEntryChoiceBox.setValue("");

    }
    
    @FXML
    void updateEntryClicked(ActionEvent event) {
    	
    	String newDateValue = newDate.getText();
        String newStartTimeValue = newStartTime.getText();
        String newStopTimeValue = newStopTime.getText();
        String newLifeCycleStep = lifeCycleStepChoiceBox.getValue();
        String newEffortCategory = effortCategoryChoiceBox.getValue();
        
        if(newDateValue.isEmpty() || newStartTimeValue.isEmpty() || newStopTimeValue.isEmpty()) {
            
            return;
        }

    }
    
    @FXML
    void initialize() {
    	
    	effortCategoryChoiceBox.setItems(effortCategory);
    	lifeCycleStepChoiceBox.setItems(lifeCycleList);
    	
    }

}
