package test.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.dto.Address;
import main.dto.iAddress;

public class TestAddress {
	private iAddress address = new Address();

	@Test
	public void testGetAndSetGade() {
		String data = "kk";

		address.setGade(data);

		assertEquals(data, address.getGade());
	}

	@Test
	public void testGetAndSetNr() {
		String data = "kk";

		address.setNr(data);

		assertEquals(data, address.getNr());
	}
	
	@Test
	public void testGetAndSetBy() {
		String data = "kk";

		address.setBy(data);

		assertEquals(data, address.getBy());
	}

	@Test
	public void testGetAndSetLand() {
		String data = "kk";

		address.setLand(data);

		assertEquals(data, address.getLand());
	}
	
	@Test
	public void testGetAndSetPostNr() {
		String data = "kk";

		address.setPostNr(data);

		assertEquals(data, address.getPostNr());
	}
}
