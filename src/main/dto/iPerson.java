package main.dto;

import java.util.List;

public interface iPerson extends Cloneable {
	public int getId();

	public List<iInteresser> getInteresser();
	public String getInteresserToString();
	
	public String getEmail();
	public void setEmail(String email);

	public String getTelefon();
	public void setTelefon(String telefon);

	public String getForNavn();
	public void setForNavn(String forNavn);
	
	public String getEfterNavn();
	public void setEfterNavn(String efterNavn);

	public String getTitle();
	public void setTitle(String title);

	public iBirthday getBirthday();

	public iAddress getAddress();
	public void setAddress(iAddress address);

	public iPerson clone();
}
