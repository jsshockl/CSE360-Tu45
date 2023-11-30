//Author: Raneem Youssef

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
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DefectConsoleManager {
	private Scene scene;
	private Stage stage;
	private int index;

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
	private Button closeButton;
	
	@FXML
	private Button openButton;
	
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
	
	@FXML
	private Label status;
	
	@FXML
	private Label isSaved;
	
	
	boolean isOpen = false;
	
	//moves to log console when clicked
	@FXML
    void logConsoleClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EffortLoggerConsole.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Log Console");
		
		ConsoleController control = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }
	
	//clear the log and replace 
	@FXML
    void clearLog(ActionEvent event) throws IOException {
		if (index >= 1) {
			EffortLog.logs[index-1] = new DefectObj();
		}
		projectType.setValue("Business Project");
		defectList.setValue("- no defect selected -");
		defectName.clear();
		defectSymptoms.clear();
		
	}
	
	//create a new defect
	@FXML
    void newDefect(ActionEvent event) throws IOException {
		index = EffortLog.getTotalLogs();
    	if (index <= 0) {
    		EffortLog.logs[0] = new DefectObj();
    		index = 0;
    	}
    	else {
    		EffortLog.logs[index] = new DefectObj();
    	}
    	//update project type and index
    	((DefectObj)(EffortLog.logs[index])).setProject(projectType.getValue());
    	index++;
    	EffortLog.setTotalLogs(index);
    	isOpen = true;

	}
	
	@FXML
    void updateDefect(ActionEvent event) throws IOException {
		//int index = DefectObj.getNumEffort() - 1;
		if (isOpen == true) { //only if the defect object is open
			if (index >= 0) {
			((DefectObj)(EffortLog.logs[index - 1])).setDefectName(defectName.getText());
			((DefectObj)(EffortLog.logs[index - 1])).setDefectSymptoms(defectSymptoms.getText());
			((DefectObj)(EffortLog.logs[index - 1])).setInjected(injected.getValue());
			((DefectObj)(EffortLog.logs[index - 1])).setRemoved(removed.getValue());
			((DefectObj)(EffortLog.logs[index - 1])).setDefectCategory(defectCategory.getValue());
			
			}
			for (int i = 0; i < EffortLog.getTotalLogs(); i++) {
	        	System.out.print(EffortLog.getTotalLogs() + "\n" + EffortLog.logs[i].toString() + "\n\n");
	        }
		}
		
	}
	
	//delete a defect
	@FXML
    void deleteDefect(ActionEvent event) throws IOException {
		if (isOpen == true) {
			if (index >= 1) {
				EffortLog.logs[index-1] = null;
			}
			
			//update index and total logs
			index--;
			EffortLog.setTotalLogs(index);
			projectType.setValue("Business Project");
			defectList.setValue("- no defect selected -");
			defectName.clear();
			defectSymptoms.clear();
			injected.setValue("Planning");
		    removed.setValue("Planning");
		}
		
	}
	
	@FXML
    void close(ActionEvent event) throws IOException {
		status.setText("Status: Closed");
		isOpen = false;
	}
	
	@FXML
    void reopen(ActionEvent event) throws IOException {
		status.setText("Status: Open");
		isOpen = true;
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

	  }
	 
}
