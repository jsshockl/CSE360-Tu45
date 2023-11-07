package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class loginController {
	
	private Database loginAttempt = new Database();

	private Stage stage;
	private Scene scene;
	
	@FXML
    private Label invalidLabel;
	
    @FXML
    private Button loginB;
    
    @FXML
    private PasswordField passField;

    @FXML
    private TextField userField;
    

    @FXML
    void loginClicked(ActionEvent event) throws IOException {
    	
    	String pass = passField.getText();
        String user = userField.getText();
    	
        if(checkCredentials(user, pass)) {
        	
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("effort.fxml"));
    		
    		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		scene = new Scene(fxmlLoader.load());
    		stage.setTitle("Effort Logger Console");
    		
    		controller control = fxmlLoader.getController();
    		//control.setTime(this);
    		stage.setScene(scene);
    		stage.show();
        	
        }
        else {
        	invalidLabel.setText("Invalid Login. Please try again");
        	invalidLabel.setTextFill(Color.RED);
        	
        	userField.setText("");
            passField.setText("");
        }

    }
    
    private boolean checkCredentials(String user, String pass) {
        // Fetch the correct password for the entered user
        String correctPassword = loginAttempt.credentials.get(user);

        // Check if the entered password is correct
        return correctPassword != null && correctPassword.equals(pass);
    }

}
