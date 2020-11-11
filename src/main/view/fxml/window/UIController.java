package main.view.fxml.window;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import main.dto.Address;
import main.dto.Person;
import main.dto.iAddress;
import main.dto.iInteresser;
import main.dto.iPerson;
import main.logic.LogicFactory;
import main.logic.iGlobal;
import main.logic.iSaveAndLoadLogic;
import main.view.fxml.window.search.SearchFactory;
import main.view.fxml.window.search.iSearch;

public class UIController {
	private PageEnum lastePage;
	private PageEnum nowPage = PageEnum.OverView;

	private iSaveAndLoadLogic saveAndLoadLogic = LogicFactory.getSaveAndLoadLogic();
	private iGlobal global = LogicFactory.getGlobal();
	private iSearch searchFunction = SearchFactory.getSearch();

	public ObservableList<iPerson> personList = FXCollections.observableArrayList();
	public ObservableList<iInteresser> interesserList = FXCollections.observableArrayList();

	public ObservableList<String> viewPersonInteresserOb = FXCollections.observableArrayList();

	private Dialog<String> dialog = new Dialog<String>();

	public VBox root;

	public AnchorPane overView;
	public AnchorPane opretPerson;
	public AnchorPane viewPerson;

	public ListView<String> viewPersonInteresserList;

	public TableView<iPerson> personTable;
	public TableView<iInteresser> interesserTable;

	public TableColumn<iPerson, String> personFornavn;
	public TableColumn<iPerson, String> personEfternavn;
	public TableColumn<iPerson, String> personTitle;
	public TableColumn<iPerson, String> personBirthday;
	public TableColumn<iPerson, String> personEmail;
	public TableColumn<iPerson, String> personTelefon;
	public TableColumn<iPerson, String> personAddress;
	public TableColumn<iPerson, String> personInteresser;

	public TableColumn<iInteresser, Integer> interesserId;
	public TableColumn<iInteresser, String> interesserNavn;

	public Text viewPersonGade;
	public Text viewPersonNr;
	public Text viewPersonPostNr;
	public Text viewPersonBy;
	public Text viewPersonLand;
	public Text viewPersonEmail;
	public Text viewPersonTelefon;
	public Text viewPersonBirthday;
	public Text viewPersonFornavn;
	public Text viewPersonEfternavn;
	public Text viewPersonTitle;

	public TextField opretPersonFornavn;
	public TextField opretPersonEfternavn;
	public TextField opretPersonTelefon;
	public TextField opretPersonEmail;
	public TextField opretPersonTitle;
	public TextField opretPersonGade;
	public TextField opretPersonNr;
	public TextField opretPersonPostNr;
	public TextField opretPersonLand;
	public TextField opretPersonBy;

	public TextField overViewPersonSearch;
	public TextField overViewInteresserSearch;

	public DatePicker opretPersonBirthday;

	public void goToViewPerson() {
		goTo(PageEnum.ViewPerson);
	}

	public void goToOpretPerson() {
		updateOpretPersonPage();
		goTo(PageEnum.OpretPerson);
	}

	public void goToOverView() {
		goTo(PageEnum.OverView);
	}

	public void goBack() {
		goTo(lastePage);
	}

	public void menuItemClickPersonTableSeMere() {
		getSelectionFormPersonTalbe();
		updateViewPersonPage();
		goTo(PageEnum.ViewPerson);
	}

	public void menuItemClickPersonTableEdit() {
		getSelectionFormPersonTalbe();
		updateOpretPersonPage();
		goTo(PageEnum.OpretPerson);
	}

	public void opretNewPerson() {
		clearOpretPersonInput();
		global.setPersonHolder(new Person());
		goToOpretPerson();
	}

	public void openDialog(String text) {
		dialog.setContentText(text);
		dialog.showAndWait();
	}

	public void openFile() {
		openFileDialog();
	}

	public void searchPersonTextField(){
		searchForPersen();
	}

	public void searchInteresserTextField(){
		searchForInteresser();
	}

	public void saveFile() {
		if (global.getFilePathHolder() == null) {
			saveFileDialog();
		}
	}

	public void saveAsFile() {
		saveFileDialog();
	}

	public void openTestDialog() {
		openDialog("Test Dialog");
		// openFileDialog();
	}

	public void funPage() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("./src/main/view/fxml/window/Warning.exe");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void sletPerson(){
		getSelectionFormPersonTalbe();
		global.SletFromPersonList();
		updatePersonList();
	}

	public void savePerson() {
		try {
			iPerson person = global.getPersonHolder();

			person.setForNavn(opretPersonFornavn.getText());
			person.setEfterNavn(opretPersonEfternavn.getText());
			person.setEmail(opretPersonEmail.getText());
			person.setTelefon(opretPersonTelefon.getText());
			person.setTitle(opretPersonTitle.getText());

			person.getBirthday().setBirthdays(opretPersonBirthday.getValue());
			
			iAddress address = new Address();
			address.setBy(opretPersonBy.getText());
			address.setGade(opretPersonGade.getText());
			address.setLand(opretPersonLand.getText());
			address.setNr(opretPersonNr.getText());
			address.setPostNr(opretPersonPostNr.getText());

			person.setAddress(address);

			global.setPersonHolder(person);

			global.saveToPersonList();
			updateAll();

		} catch (Exception e) {
			openDialog(e.getMessage());
		}

	}

	public void updateAll(){
		updatePersonList();
		updateInteresserList();
	}

	public void updatePersonList(){
		personList.clear();
		personList.addAll(global.getPersonList().getAllAsList());
	}

	public void updateInteresserList(){
		interesserList.clear();
		interesserList.addAll(global.getInteresserList().getAllAsList());
	}

	public void updateviewPersonInteresserOb(){
		viewPersonInteresserOb.clear();

		for(iInteresser interesser : global.getPersonHolder().getPersonInteresserList().getInteresser()){
			viewPersonInteresserOb.add(interesser.getNavn());
		}
	}

	private void searchForPersen(){
		if(overViewPersonSearch.getText().equalsIgnoreCase("")){
			updatePersonList();
		}else{
			personList.clear();
			personList.addAll(searchFunction.searchPerson(overViewPersonSearch.getText(), global.getPersonList().getAllAsList()));
		}
	}

	private void searchForInteresser(){
		if(overViewInteresserSearch.getText().equalsIgnoreCase("")){
			updatePersonList();
		} else {
			interesserList.clear();
			interesserList.addAll(searchFunction.searchInteresser(overViewPersonSearch.getText(), global.getInteresserList().getAllAsList()));
		}
	}

	private void getSelectionFormPersonTalbe() {
		global.setPersonHolder(personTable.getSelectionModel().getSelectedItem());
	}

	private void goTo(PageEnum page) {
		if (page == nowPage){
			return;
		}

		lastePage = nowPage;
		nowPage = page;

		overView.setVisible(false);
		opretPerson.setVisible(false);
		viewPerson.setVisible(false);

		switch (page) {
			case OpretPerson:
				opretPerson.setVisible(true);
				break;
			case OverView:
				overView.setVisible(true);
				break;
			case ViewPerson:
				viewPerson.setVisible(true);
				break;
		}
	}

	private void openFileDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open JSON file");
		Stage stage = (Stage)root.getScene().getWindow();

		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));

		File file = fileChooser.showOpenDialog(stage);

		if(file != null){
			global.setFilePathHolder(file);
			saveAndLoadLogic.loadAllFromGlobal();
		}
	}

	private void saveFileDialog() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save as JSON file");
		Stage stage = (Stage)root.getScene().getWindow();

		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All files (*.*)", "*.*"));

		File file = fileChooser.showSaveDialog(stage);

		if(file != null){
			global.setFilePathHolder(file);
			saveAndLoadLogic.saveAllFromGlobal();
		}
	}

	private void clearOpretPersonInput() {
		opretPersonGade.setText("");
		opretPersonNr.setText("");
		opretPersonPostNr.setText("");
		opretPersonBy.setText("");
		opretPersonLand.setText("");
		opretPersonEmail.setText("");
		opretPersonTelefon.setText("");
		opretPersonFornavn.setText("");
		opretPersonEfternavn.setText("");
		opretPersonTitle.setText("");

		opretPersonBirthday.getEditor().clear();
	}

	private void updateOpretPersonPage() {
		opretPersonGade.setText(global.getPersonHolder().getAddress().getGade());
		opretPersonNr.setText(global.getPersonHolder().getAddress().getNr());
		opretPersonPostNr.setText(global.getPersonHolder().getAddress().getPostNr());
		opretPersonBy.setText(global.getPersonHolder().getAddress().getBy());
		opretPersonLand.setText(global.getPersonHolder().getAddress().getLand());
		opretPersonEmail.setText(global.getPersonHolder().getEmail());
		opretPersonTelefon.setText(global.getPersonHolder().getTelefon());
		opretPersonFornavn.setText(global.getPersonHolder().getForNavn());
		opretPersonEfternavn.setText(global.getPersonHolder().getEfterNavn());
		opretPersonTitle.setText(global.getPersonHolder().getTitle());

		opretPersonBirthday.setValue(global.getPersonHolder().getBirthday().getLocalDateBirthdays());
	}

	private void updateViewPersonPage() {
		viewPersonGade.setText(global.getPersonHolder().getAddress().getGade());
		viewPersonNr.setText(global.getPersonHolder().getAddress().getNr());
		viewPersonPostNr.setText(global.getPersonHolder().getAddress().getPostNr());
		viewPersonBy.setText(global.getPersonHolder().getAddress().getBy());
		viewPersonLand.setText(global.getPersonHolder().getAddress().getLand());
		viewPersonEmail.setText(global.getPersonHolder().getEmail());
		viewPersonTelefon.setText(global.getPersonHolder().getTelefon());
		viewPersonBirthday.setText(global.getPersonHolder().getBirthday().toString());
		viewPersonFornavn.setText(global.getPersonHolder().getForNavn());
		viewPersonEfternavn.setText(global.getPersonHolder().getEfterNavn());
		viewPersonTitle.setText(global.getPersonHolder().getTitle());

		updateviewPersonInteresserOb();
	}

	public void initialize(){
		goTo(PageEnum.OverView);
		
		updateAll();

		setupDatePicker();
		setupPersonTable();
		setupInteresserTable();
		setupDialog();
		setupViewPersonInteresserList();
	}

	private void setupDialog() {
		dialog.setTitle("Error");
		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.setContentText("Errer text");
		dialog.getDialogPane().getButtonTypes().add(type);
	}

	private void setupViewPersonInteresserList() {
		viewPersonInteresserList.setItems(viewPersonInteresserOb);
	}

	private void setupPersonTable(){
		personFornavn.setCellValueFactory(new PropertyValueFactory<iPerson,String>("forNavn"));
		personEfternavn.setCellValueFactory(new PropertyValueFactory<iPerson,String>("efterNavn"));
		personTitle.setCellValueFactory(new PropertyValueFactory<iPerson,String>("title"));
		personBirthday.setCellValueFactory(new PropertyValueFactory<iPerson,String>("birthday"));
		personEmail.setCellValueFactory(new PropertyValueFactory<iPerson,String>("email"));
		personTelefon.setCellValueFactory(new PropertyValueFactory<iPerson,String>("telefon"));
		personAddress.setCellValueFactory(new PropertyValueFactory<iPerson,String>("address"));
		personInteresser.setCellValueFactory(new PropertyValueFactory<iPerson,String>("personInteresserList"));

		personTable.setItems(personList);
	}

	private void setupInteresserTable(){
		interesserId.setCellValueFactory(new PropertyValueFactory<iInteresser,Integer>("id"));
		interesserNavn.setCellValueFactory(new PropertyValueFactory<iInteresser,String>("navn"));

		interesserTable.setItems(interesserList);
	}

	private void setupDatePicker(){
		opretPersonBirthday.setConverter(new StringConverter<LocalDate>() {
			private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

			@Override
			public String toString(LocalDate localDate)
			{
				if(localDate==null)
					return "";
				return dateTimeFormatter.format(localDate);
			}

			@Override
			public LocalDate fromString(String dateString)
			{
				if(dateString==null || dateString.trim().isEmpty())
				{
					return null;
				}
				return LocalDate.parse(dateString,dateTimeFormatter);
			}
		});
	}

}
