package test.dto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import  org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.dto.Birthday;
import main.dto.iBirthday;

public class TestBirthday {
	private iBirthday birthday = new Birthday();
	
	@BeforeEach
	void setUp() throws Exception {
		birthday.setBirthdays("26-09-1994");
	}

	@Test
	public void testGetAlder() {
		LocalDate now = LocalDate.now();
		LocalDate TestDay = LocalDate.parse("26-09-1994", DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		assertEquals(Period.between(TestDay, now).getYears(), birthday.getAlder());
	}

	@Test
	public void testGetBirthdays() {
		assertEquals("26-09-1994", birthday.getBirthdays());
	}
}
