package main.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Birthday implements iBirthday {

	private LocalDate birthdays;
	private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Override
	public int getAlder() {
		if(birthdays == null){
			return 0;
		}

		LocalDate now = LocalDate.now();
		return Period.between(birthdays, now).getYears();
	}

	@Override
	public void setBirthdays(String birthdays) {
		this.birthdays = LocalDate.parse(birthdays, dateFormat);		
	}

	@Override
	public String getBirthdays() {
		return birthdays.format(dateFormat);
	}

	@Override
	public String toString(){
		return getBirthdays() + " (" + getAlder() + ")";
	}
}
