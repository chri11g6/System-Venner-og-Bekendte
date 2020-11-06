package main.view.fxml.window;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import main.dto.Address;
import main.dto.Person;
import main.dto.iAddress;
import main.dto.iInteresser;
import main.dto.iPerson;
import main.logic.Global;

public class UIController {
	private PageEnum lastePage;
	private PageEnum nowPage = PageEnum.OverView;
	public ObservableList<iPerson> personList = FXCollections.observableArrayList();
	public ObservableList<iInteresser> interesserList = FXCollections.observableArrayList();

	private Dialog<String> dialog = new Dialog();

	public AnchorPane overView;
	public AnchorPane opretPerson;
	public AnchorPane viewPerson;

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
		Global.setPersonHolder(new Person());
		goToOpretPerson();
	}

	public void openDialog(String text) {
		dialog.setContentText(text);
		dialog.showAndWait();
	}

	public void openTestDialog() {
		openDialog("Test Dialog");
	}

	public void sletPerson(){
		getSelectionFormPersonTalbe();
		Global.SletFromPersonList();
		updatePersonList();
	}

	public void savePerson() {
		try {
			iPerson person = Global.getPersonHolder();

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

			Global.setPersonHolder(person);

			Global.saveToPersonList();
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
		personList.addAll(Global.personList.getAllAsList());
	}

	public void updateInteresserList(){
		interesserList.clear();
		interesserList.addAll(Global.interesserList.getAllAsList());
	}

	private void getSelectionFormPersonTalbe() {
		Global.setPersonHolder(personTable.getSelectionModel().getSelectedItem());
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
		opretPersonGade.setText(Global.getPersonHolder().getAddress().getGade());
		opretPersonNr.setText(Global.getPersonHolder().getAddress().getNr());
		opretPersonPostNr.setText(Global.getPersonHolder().getAddress().getPostNr());
		opretPersonBy.setText(Global.getPersonHolder().getAddress().getBy());
		opretPersonLand.setText(Global.getPersonHolder().getAddress().getLand());
		opretPersonEmail.setText(Global.getPersonHolder().getEmail());
		opretPersonTelefon.setText(Global.getPersonHolder().getTelefon());
		opretPersonFornavn.setText(Global.getPersonHolder().getForNavn());
		opretPersonEfternavn.setText(Global.getPersonHolder().getEfterNavn());
		opretPersonTitle.setText(Global.getPersonHolder().getTitle());

		opretPersonBirthday.setValue(Global.getPersonHolder().getBirthday().getLocalDateBirthdays());
	}

	private void updateViewPersonPage() {
		viewPersonGade.setText(Global.getPersonHolder().getAddress().getGade());
		viewPersonNr.setText(Global.getPersonHolder().getAddress().getNr());
		viewPersonPostNr.setText(Global.getPersonHolder().getAddress().getPostNr());
		viewPersonBy.setText(Global.getPersonHolder().getAddress().getBy());
		viewPersonLand.setText(Global.getPersonHolder().getAddress().getLand());
		viewPersonEmail.setText(Global.getPersonHolder().getEmail());
		viewPersonTelefon.setText(Global.getPersonHolder().getTelefon());
		viewPersonBirthday.setText(Global.getPersonHolder().getBirthday().toString());
		viewPersonFornavn.setText(Global.getPersonHolder().getForNavn());
		viewPersonEfternavn.setText(Global.getPersonHolder().getEfterNavn());
		viewPersonTitle.setText(Global.getPersonHolder().getTitle());
	}

	public void initialize(){
		goTo(PageEnum.OverView);
		
		updateAll();

		setupDatePicker();
		setupPersonTable();
		setupInteresserTable();
		setupDialog();
	}

	private void setupDialog() {
		dialog.setTitle("Error");
		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.setContentText("Errer text");
		dialog.getDialogPane().getButtonTypes().add(type);
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
