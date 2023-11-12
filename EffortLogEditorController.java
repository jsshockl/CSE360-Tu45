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
import javafx.stage.Stage;

public class EffortLogEditorController {
	
	private Stage stage;
	private Scene scene;
	
	ObservableList<String> projectList = FXCollections.observableArrayList("Business Project","Development Project");
	ObservableList<String> effortCategory = FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others");

    @FXML
    private Button clearEffortButton;

    @FXML
    private ChoiceBox<String> effortCategoryChoiceBox;

    @FXML
    private Button proceedToEffortB;

    @FXML
    private ChoiceBox<String> selectProjectChoiceBox;

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
    void initialize() {
    	
    	selectProjectChoiceBox.setItems(projectList);
    	effortCategoryChoiceBox.setItems(effortCategory);
    	
    }

}