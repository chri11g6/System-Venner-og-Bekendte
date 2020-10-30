package test.dto;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.dto.Person;
import main.dto.iPerson;

public class TestPerson {
	private iPerson testPerson = new Person();
	@Test
	public void testSetEmail(){
		try{
			testPerson.setEmail("chri11g6@eamv.dk");
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail("Email bliver checke for korte");
		}

		try{
			testPerson.setEmail("chri11g6eamv.dk");
			fail("Email bliver checke for korte");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testGetEmail(){
		String email = "chri11g6@eamv.dk";

		try{
			testPerson.setEmail(email);
			assertEquals(email, testPerson.getEmail());
		} catch (IllegalArgumentException e) {
			fail("Email bliver checke for korte");
		}
	}

	@Test
	public void testSetTelefon(){
		try{
			testPerson.setTelefon("12345678");
			assertTrue(true);
		} catch (IllegalArgumentException e) {
			fail("Telefon bliver checke for korte");
		}

		try{
			testPerson.setTelefon("chri11g6eamv.dk");
			fail("Telefon bliver checke for korte");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testGetTelefon(){
		String tel = "12345678";

		try{
			testPerson.setTelefon(tel);
			
			assertEquals(tel, testPerson.getTelefon());

		} catch (IllegalArgumentException e) {
			fail("Telefon bliver checke for korte");
		}

	}

	@Test
	public void testSetAndGetForNavn(){
		String forNavn = "Christian";

		testPerson.setForNavn(forNavn);

		assertEquals(forNavn, testPerson.getForNavn());

	}

	@Test
	public void testSetAndGetEfterNavn(){
		String efterNavn = "Christisenen";

		testPerson.setEfterNavn(efterNavn);

		assertEquals(efterNavn, testPerson.getEfterNavn());

	}
}
