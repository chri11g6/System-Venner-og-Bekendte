package main.logic;

import java.util.List;

import main.data.HoldData;
import main.data.iPersonData;
import main.dto.Person;

public class PesonLogicData implements iPesonLogicData {

	private iPersonData personData = HoldData.getPersonData();

	@Override
	public void add(Person data) {
		personData.add(data);
	}

	@Override
	public void update(Person data, int index) {
		personData.update(data, index);
	}

	@Override
	public void update(Person data) {
		personData.update(data);
	}

	@Override
	public void remove(Person data) {
		personData.remove(data);
	}

	@Override
	public void remove(int index) {
		personData.remove(index);
	}

	@Override
	public Person get(int index) {
		return personData.get(index);
	}

	@Override
	public Person[] getAll() {
		return personData.getAll();
	}

	@Override
	public List<Person> getAllAsList() {
		return personData.getAllAsList();
	}

	@Override
	public int size() {
		return personData.size();
	}
	
}
