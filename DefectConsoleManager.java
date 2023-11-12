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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DefectConsoleManager {
	private Scene scene;
	private Stage stage;
	private EffortLog[] effortLogs;

	ObservableList<String> projectList = FXCollections.observableArrayList("Business Project","Development Project");
	ObservableList<String> injectedList = FXCollections.observableArrayList("Planning","Information Gathering", "Information Understanding", "Verifying", "Outlining");
	ObservableList<String> removedList = FXCollections.observableArrayList("Planning","Information Gathering", "Information Understanding", "Verifying", "Outlining");
	ObservableList<String> defectCategoryList = FXCollections.observableArrayList("Not specified", "10 Documentation", "20 Syntax", "30 Build Package", "40 Assignment");
	
			
	@FXML
	private ChoiceBox<String> projectType;
	
	@FXML
	private ChoiceBox<String> defectList;
	
	@FXML
	private TextField defectName;
	
	@FXML
	private Button clearLog;
	
	@FXML
	private Button newDefect;
	
	@FXML
	private TextArea defectSymptoms;
	
	@FXML
	private ChoiceBox<String> injected;
	
	@FXML
	private ChoiceBox<String> removed;
	
	@FXML
	private ChoiceBox<String> defectCategory;
	
	@FXML
	private Button updateDefect;
	
	@FXML
	private Button deleteDefect;
	
	@FXML
	private Button logConsole;
	
	//moves to log console when clicked
	@FXML
    void logConsoleClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("effort.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Log Console");
		
		controller control = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }
	
	//clear the log and replace 
	@FXML
    void clearLog(ActionEvent event) throws IOException {
		int index = EffortLog.getNumEffort();
		if (index >= 1) {
			effortLogs[index-1] = new EffortLog();
		}
		EffortLog.setNumEffort(index-1);
		projectType.setValue("Business Project");
		defectList.setValue("- no defect selected -");
		defectName.clear();
		defectSymptoms.clear();
		
	}
	
	//create a new defect
	@FXML
    void newDefect(ActionEvent event) throws IOException {
		int index = EffortLog.getNumEffort();
		effortLogs[index] = new EffortLog();
		effortLogs[index].setProject(projectType.getValue());
		EffortLog.setNumEffort(index+1);
	}
	
	@FXML
    void updateDefect(ActionEvent event) throws IOException {
		int index = EffortLog.getNumEffort() - 1;
		if (index >= 0) {
			effortLogs[index].setDefectName(defectName.getText());
			effortLogs[index].setDefectSymptoms(defectSymptoms.getText());
			effortLogs[index].setInjected(injected.getValue());
			effortLogs[index].setRemoved(removed.getValue());
			effortLogs[index].setDefectCategory(defectCategory.getValue());
			
		}
		System.out.print(effortLogs[index].toString());
	}
	
	//delete a defect
	@FXML
    void deleteDefect(ActionEvent event) throws IOException {
		int index = EffortLog.getNumEffort();
		if (index >= 1) {
			effortLogs[index-1] = null;
		}
		EffortLog.setNumEffort(index-1);
		projectType.setValue("Business Project");
		defectList.setValue("- no defect selected -");
		defectName.clear();
		defectSymptoms.clear();
		injected.setValue("Planning");
	    removed.setValue("Planning");
	}
	 @FXML
	 void initialize() {
	    projectType.setValue("Business Project");
	    defectList.setValue("- no defect selected -");
	    injected.setValue("Planning");
	    removed.setValue("Planning");
	    defectCategory.setValue("Not Specified");
	    
	    projectType.setItems(projectList);
	    injected.setItems(injectedList);
	    removed.setItems(removedList);
	    defectCategory.setItems(defectCategoryList);
	    
	    //array of effort log items
	    effortLogs = new EffortLog[995];
	    	
	  }
}
