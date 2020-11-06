package main.dto;

import java.time.LocalDate;

public interface iBirthday {
	public int getAlder();

	public void setBirthdays(String birthdays);
	public void setBirthdays(LocalDate birthdays);
	public String getBirthdays();
	public LocalDate getLocalDateBirthdays();
}
