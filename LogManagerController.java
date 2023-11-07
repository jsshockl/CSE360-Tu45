package application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LogManagerController {
	
	private Stage stage;
	private Scene scene;
	
	@FXML
    private Button backConsole;

    @FXML
    void backToConsoleClicked(ActionEvent event) throws IOException {
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("effort.fxml"));
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Effort Logger Console");
		
		controller control = fxmlLoader.getController();
		//control.setTime(this);
		stage.setScene(scene);
		stage.show();
    	
    }

}
