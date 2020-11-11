package test.view.fxml.window.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.dto.Interesser;
import main.dto.Person;
import main.dto.iInteresser;
import main.dto.iPerson;
import main.view.fxml.window.search.SearchFactory;
import main.view.fxml.window.search.iSearch;

public class TestSearch {
	private iSearch search = SearchFactory.getSearch();

	private List<iPerson> personsList = new ArrayList<iPerson>();
	private List<iInteresser> interessersList = new ArrayList<iInteresser>();

	@BeforeEach
	void setUp() throws Exception {
		interessersList.add(new Interesser("Skak"));
		interessersList.add(new Interesser("CounterStrike"));
		interessersList.add(new Interesser("Litteratur"));
		interessersList.add(new Interesser("Natur"));

		iPerson per = new Person();
		per.setForNavn("Christian");
		per.setEfterNavn("Christensen");
		per.getBirthday().setBirthdays("26-09-1994");
		per.setTelefon("12345678");
		per.setEmail("chri11g6@eamv.dk");
		per.setTitle("Datamartiker");
		per.getAddress().setBy("Skjern");
		per.getAddress().setPostNr("6900");
		per.getAddress().setGade("Østervang");
		per.getAddress().setNr("30");
		per.getAddress().setLand("Danmark");
		per.getPersonInteresserList().getInteresser().add(new Interesser("Kage"));
		per.getPersonInteresserList().getInteresser().add(new Interesser("Game"));
		
		iPerson per1 = new Person();
		per1.setForNavn("Martin");
		per1.setEfterNavn("Christensen");
		per1.getBirthday().setBirthdays("02-04-1990");
		per1.setTelefon("12345678");
		per1.setEmail("");
		per1.getAddress().setBy("Skjern");
		per1.getAddress().setPostNr("6900");
		per1.getAddress().setGade("Østervang");
		per1.getAddress().setNr("30");
		per1.getAddress().setLand("Danmark");
		
		iPerson per2 = new Person();
		per2.setForNavn("Antia");
		per2.setEfterNavn("Christensen");
		per2.getBirthday().setBirthdays("21-10-1962");
		per2.setTelefon("12345678");
		per2.setEmail("");
		per2.getAddress().setBy("Skjern");
		per2.getAddress().setPostNr("6900");
		per2.getAddress().setGade("Østervang");
		per2.getAddress().setNr("30");
		per2.getAddress().setLand("Danmark");

		personsList.add(per);
		personsList.add(per1);
		personsList.add(per2);
	}

	@Test
	public void TestSearchInteresserSimple() {
		
		List<iInteresser> list = search.searchInteresser("Skak", interessersList);

		assertEquals(interessersList.get(0), list.get(0));
	}

	@Test
	public void TestSearchInteresserNot() {
		
		List<iInteresser> list = search.searchInteresser("not Skak", interessersList);

		assertEquals(interessersList.get(1), list.get(0));
		assertEquals(interessersList.get(2), list.get(1));
		assertEquals(interessersList.get(3), list.get(2));
	}

	@Test
	public void TestSearchPersonAlderAndFornavn() {
		
		List<iPerson> list = search.searchPerson("alder >= 30 and fornavn Antia", personsList);

		assertEquals(personsList.get(2), list.get(0));
	}
	@Test
	public void TestSearchPersonFornavn() {
		
		List<iPerson> list = search.searchPerson("fornavn Antia", personsList);

		assertEquals(personsList.get(2), list.get(0));
	}

	@Test
	public void TestSearchPersonSimple() {
		
		List<iPerson> list = search.searchPerson("Christian", personsList);

		assertEquals(personsList.get(0), list.get(0));
	}

	@Test
	public void TestSearchPersonNotFornavn() {
		
		List<iPerson> list = search.searchPerson("not fornavn Antia", personsList);

		assertEquals(personsList.get(0), list.get(0));
		assertEquals(personsList.get(1), list.get(1));
	}
}
