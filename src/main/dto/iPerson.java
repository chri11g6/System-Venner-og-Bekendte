package main.dto;

import java.util.List;

public interface iPerson {
	public int getId();

	public List<iInteresser> getInteresser();
	
	public String getEmail();
	public void setEmail(String email);

	public String getTelefon();
	public void setTelefon(String telefon);

	public String getForNavn();
	public void setForNavn(String forNavn);
	
	public String getEfterNavn();
	public void setEfterNavn(String efterNavn);

	public iBirthday getBirthday();
}
