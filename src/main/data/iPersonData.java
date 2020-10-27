package main.data;

import java.util.List;

import main.dto.Person;

public interface iPersonData extends iDatabase {
	public void add(Person data);
	public void addAll(List<Person> datas);
	public void addFresh(List<Person> datas);
	public void update(Person data, int index);
	public void update(Person data);
	public void remove(Person data);
	public Person get(int index);
	public Person[] getAll();
	public List<Person> getAllAsList();
}
