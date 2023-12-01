package application;

import java.io.IOException;
import java.net.URL;
import javafx.scene.Node;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class DefinitionsController implements Initializable	{
	//test objects
	public class Table	{	//table object
		String index, name;
		public Table(String index, String name)	{
			this.index = index;
			this.name = name;
		}
		public String getIndex() {
			return index;
		}
		public String getName() {
			return name;
		}
		public void setIndex(String index) {
			this.index = index;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	public class LifeCycleSteps {	//table object
		private String stepName, EC, D, stepIndex;
		
		public LifeCycleSteps(String stepIndex, String EC, String D, String stepName)		{
			this.stepIndex = stepIndex;
			this.EC = EC;
			this.D = D;
			this.stepName = stepName;
		}
		public String getStepIndex() {
			return stepIndex;
		}
		public String getEC() {
			return EC;
		}
		public String getD() {
			return D;
		}
		public String getStepName() {
			return stepName;
		}
		public void setStepIndex(String stepIndex) {
			this.stepIndex = stepIndex;
		}
		public void setEC(String eC) {
			EC = eC;
		}
		public void setD(String d) {
			D = d;
		}
		public void setStepName(String stepName) {
			this.stepName = stepName;
		}
	}
	
	TestObj presetOne = new TestObj("Business Project","17","18","19","20","21","22","23","24","25","26"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ");
	TestObj presetTwo = new TestObj("Development","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"," "," "," "," "," "," "," "," "," ");
	private Stage stage;
	private Scene scene;
	@FXML private Button button;
	//create tables
	@FXML private TableView<TestObj> nameTable;
	@FXML private TableView<LifeCycleSteps> lifeCycleTable;
	@FXML private TableView<Table> effortTable;
	@FXML private TableView<Table> delTable;

	//Name table columns
	@FXML private TableColumn<TestObj, String> nameColumn;
	@FXML private TableColumn<TestObj, String> oneColumn;
	@FXML private TableColumn<TestObj, String> twoColumn;
	@FXML private TableColumn<TestObj, String> threeColumn;
	@FXML private TableColumn<TestObj, String> fourColumn;
	@FXML private TableColumn<TestObj, String> fiveColumn;
	@FXML private TableColumn<TestObj, String> sixColumn;
	@FXML private TableColumn<TestObj, String> sevenColumn;
	@FXML private TableColumn<TestObj, String> eightColumn;
	@FXML private TableColumn<TestObj, String> nineColumn;
	@FXML private TableColumn<TestObj, String> tenColumn;
	@FXML private TableColumn<TestObj, String> elevenColumn;
	@FXML private TableColumn<TestObj, String> twelveColumn;
	@FXML private TableColumn<TestObj, String> thirteenColumn;
	@FXML private TableColumn<TestObj, String> fourteenColumn;
	@FXML private TableColumn<TestObj, String> fifteenColumn;
	@FXML private TableColumn<TestObj, String> sixteenColumn;
	@FXML private TableColumn<TestObj, String> seventeenColumn;
	@FXML private TableColumn<TestObj, String> eighteenColumn;
	@FXML private TableColumn<TestObj, String> nineteenColumn;
	@FXML private TableColumn<TestObj, String> twentyColumn;
	@FXML private TableColumn<TestObj, String> twentyoneColumn;
	@FXML private TableColumn<TestObj, String> twentytwoColumn;
	@FXML private TableColumn<TestObj, String> twentythreeColumn;
	@FXML private TableColumn<TestObj, String> twentyfourColumn;
	@FXML private TableColumn<TestObj, String> twentyfiveColumn;
	
	//Life Cycle table columns
	@FXML private TableColumn<LifeCycleSteps, String> indexColumn;
	@FXML private TableColumn<LifeCycleSteps, String> stepNameColumn;
	@FXML private TableColumn<LifeCycleSteps, String> DColumn;
	@FXML private TableColumn<LifeCycleSteps, String> ECColumn;
	
	//Effort columns
	@FXML private TableColumn<Table, String> effortindexColumn;
	@FXML private TableColumn<Table, String> effortNameColumn;
	
	//Deliverables columns
	@FXML private TableColumn<Table, String> delindexColumn;
	@FXML private TableColumn<Table, String> delNameColumn;
	
	//change name table values
	public void changeName(CellEditEvent edittedCell)	{	
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setName(edittedCell.getNewValue().toString());
	}
	public void changeoneColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcone(edittedCell.getNewValue().toString());
	}
	public void changetwoColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwo(edittedCell.getNewValue().toString());
	}
	public void changethreeColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcthree(edittedCell.getNewValue().toString());
	}
	public void changefourColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcfour(edittedCell.getNewValue().toString());
	}
	public void changefiveColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcfive(edittedCell.getNewValue().toString());
	}
	public void changesixColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcsix(edittedCell.getNewValue().toString());
	}
	public void changesevenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcseven(edittedCell.getNewValue().toString());
	}
	public void changeeightColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLceight(edittedCell.getNewValue().toString());
	}
	public void changenineColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcnine(edittedCell.getNewValue().toString());
	}
	public void changetenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcten(edittedCell.getNewValue().toString());
	}
	public void changeelevenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLceleven(edittedCell.getNewValue().toString());
	}
	public void changetwelveColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwelve(edittedCell.getNewValue().toString());
	}
	public void changethirteenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcthirteen(edittedCell.getNewValue().toString());
	}
	public void changefourteenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcfourteen(edittedCell.getNewValue().toString());
	}
	public void changefifteenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcfifteen(edittedCell.getNewValue().toString());
	}
	public void changesixteenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcsixteen(edittedCell.getNewValue().toString());
	}
	public void changeseventeenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcseventeen(edittedCell.getNewValue().toString());
	}
	public void changeeighteenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLceighteen(edittedCell.getNewValue().toString());
	}
	public void changenineteenColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLcnineteen(edittedCell.getNewValue().toString());
	}
	public void changetwentyColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwenty(edittedCell.getNewValue().toString());
	}
	public void changetwentyoneColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwentyone(edittedCell.getNewValue().toString());
	}
	public void changetwentytwoColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwentytwo(edittedCell.getNewValue().toString());
	}
	public void changetwentythreeColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwentythree(edittedCell.getNewValue().toString());
	}
	public void changetwentyfourColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwentyfour(edittedCell.getNewValue().toString());
	}
	public void changetwentyfiveColumn(CellEditEvent edittedCell)	{
		TestObj temp = nameTable.getSelectionModel().getSelectedItem();
		temp.setLctwentyfive(edittedCell.getNewValue().toString());
	}
	
	//change cycle table values
	public void changestepIndex(CellEditEvent edittedCell)	{	
		LifeCycleSteps temp = lifeCycleTable.getSelectionModel().getSelectedItem();
		temp.setStepIndex(edittedCell.getNewValue().toString());
	}
	public void changestepNameColumn(CellEditEvent edittedCell)	{	
		LifeCycleSteps temp = lifeCycleTable.getSelectionModel().getSelectedItem();
		temp.setStepName(edittedCell.getNewValue().toString());
	}
	public void changeECColumn(CellEditEvent edittedCell)	{	
		LifeCycleSteps temp = lifeCycleTable.getSelectionModel().getSelectedItem();
		temp.setEC(edittedCell.getNewValue().toString());
	}
	public void changeDColumn(CellEditEvent edittedCell)	{	
		LifeCycleSteps temp = lifeCycleTable.getSelectionModel().getSelectedItem();
		temp.setD(edittedCell.getNewValue().toString());
	}
	//change effort values
	public void changeeffortIndex(CellEditEvent edittedCell)	{	
		Table temp = effortTable.getSelectionModel().getSelectedItem();
		temp.setIndex(edittedCell.getNewValue().toString());
	}
	public void changeeffortpNameColumn(CellEditEvent edittedCell)	{	
		Table temp = effortTable.getSelectionModel().getSelectedItem();
		temp.setName(edittedCell.getNewValue().toString());
	}
	//change deliverables values
	public void changedelIndex(CellEditEvent edittedCell)	{	
		Table temp = delTable.getSelectionModel().getSelectedItem();
		temp.setIndex(edittedCell.getNewValue().toString());
	}
	public void changedelNameColumn(CellEditEvent edittedCell)	{	
		Table temp = delTable.getSelectionModel().getSelectedItem();
		temp.setName(edittedCell.getNewValue().toString());
	}
	public void proceedToEffortClicked(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("effort.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(fxmlLoader.load());
		stage.setTitle("Effort Logger");
		
		controller control = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
    }
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//fill name table
		nameColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("name"));
		oneColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcone"));
		twoColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwo"));
		threeColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcthree"));
		fourColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcfour"));
		fiveColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcfive"));
		sixColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcsix"));
		sevenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcseven"));
		eightColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lceight"));
		nineColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcnine"));
		tenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcten"));
		elevenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lceleven"));
		twelveColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwelve"));
		thirteenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcthirteen"));
		fourteenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcfourteen"));
		fifteenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcfifteen"));
		sixteenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcsixteen"));
		seventeenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcseventeen"));
		eighteenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lceighteen"));
		nineteenColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lcnineteen"));
		twentyColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwenty"));
		twentyoneColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwentyone"));
		twentytwoColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwentytwo"));
		twentythreeColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwentythree"));
		twentyfourColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwentyfour"));
		twentyfiveColumn.setCellValueFactory(new PropertyValueFactory<TestObj, String>("lctwentyfive"));
		//fill life cycle table
		indexColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleSteps, String>("stepIndex"));
		stepNameColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleSteps, String>("stepName"));
		DColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleSteps, String>("D"));
		ECColumn.setCellValueFactory(new PropertyValueFactory<LifeCycleSteps, String>("EC"));
		//fill effort table
		effortindexColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("index"));
		effortNameColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
		//fill deliverables table
		delindexColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("index"));
		delNameColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("name"));
		
		//call methods to add data
		nameTable.setItems(getPeople());
		lifeCycleTable.setItems(getData());
		effortTable.setItems(getEffort());
		delTable.setItems(getDel());
		
		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		oneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		threeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		fourColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		fiveColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		sixColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		sevenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		eightColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nineColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		tenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		elevenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twelveColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		thirteenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		fourteenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		fifteenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		sixteenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		seventeenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		eighteenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nineteenColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twentyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twentyoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twentytwoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twentythreeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twentyfourColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		twentyfiveColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		indexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		stepNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		DColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		ECColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		effortindexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		effortNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		delindexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		delNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	public ObservableList<TestObj> getPeople()	{
		ObservableList<TestObj> list = FXCollections.observableArrayList();
				//name table data
				list.add(presetOne);
				list.add(presetTwo);
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				list.add(new TestObj(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "));
				return list;
	}
	public ObservableList<LifeCycleSteps> getData()	{
		ObservableList<LifeCycleSteps> list = FXCollections.observableArrayList();
				//life cycle table data
				list.add(new LifeCycleSteps ("1","2","1","Problem Understanding"));
				list.add(new LifeCycleSteps ("2","1","3","Conceptual Desgin Plan"));
				list.add(new LifeCycleSteps ("3","2","1","Requirements"));
				list.add(new LifeCycleSteps ("4","2","1","Conceptual Design"));
				list.add(new LifeCycleSteps ("5","2","1","Conceptual Design Review"));
				list.add(new LifeCycleSteps ("6","1","4","Detailed Design Plan"));
				list.add(new LifeCycleSteps ("7","2","2","Detailed Design/Prototype"));
				list.add(new LifeCycleSteps ("8","2","2","Detailed Design/Review"));
				list.add(new LifeCycleSteps ("9","1","5","Implementation Plan"));
				
				return list;
	}
	public ObservableList<Table> getEffort()	{
		ObservableList<Table> list = FXCollections.observableArrayList();
				//effort table data
				list.add(new Table ("1","Plans"));
				list.add(new Table ("2","Deliverables"));
				list.add(new Table ("3","Interruptions"));
				list.add(new Table ("4","Defects"));
				list.add(new Table ("5","Others"));
				return list;
	}
	public ObservableList<Table> getDel()	{
		ObservableList<Table> list = FXCollections.observableArrayList();
				//del table data
				list.add(new Table ("1","Conceptual Design"));
				list.add(new Table ("2","Detailed Design"));
				list.add(new Table ("3","Test Cases"));
				list.add(new Table ("4","Solution"));
				list.add(new Table ("5","Reflection"));
				list.add(new Table ("6","Outline"));
				list.add(new Table ("7","Draft"));
				list.add(new Table ("8","Report"));
				list.add(new Table ("9","User Defined"));
				list.add(new Table ("10","Others"));
				return list;
	}
}
