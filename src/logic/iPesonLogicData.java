package logic;

import java.util.List;

import dto.Person;

public interface iPesonLogicData {
	public void add(Person data);
	public void update(Person data, int index);
	public void update(Person data);
	public void remove(Person data);
	public void remove(int index);
	public Person get(int index);
	public Person[] getAll();
	public List<Person> getAllAsList();
	public int size();
}
