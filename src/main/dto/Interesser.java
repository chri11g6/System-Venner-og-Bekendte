package main.dto;

public class Interesser implements iInteresser {
	private String navn;
	private int id;
	private static int counter = 0;

	public int getId() {
		return this.id;
	}

	public Interesser(String navn) {
		this.navn = navn;
		this.id = counter;
		counter++;
	}

	@Override
	public String getNavn() {
		return navn;
	}

	@Override
	public void setNavn(String navn) {
		this.navn = navn;
	}
}
