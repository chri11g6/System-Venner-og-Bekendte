package main.dto;

public interface iInteresser extends Cloneable {
	public int getId();

	public String getNavn();
	public void setNavn(String navn);

	public iInteresser clone();
}
