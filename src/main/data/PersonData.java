package main.data;

import java.util.ArrayList;
import java.util.List;

import main.dto.Person;

public class PersonData implements iPersonData {
	private List<Person> personList = new ArrayList<Person>();

	@Override
	public void remove(int index) {
		personList.remove(index);
	}

	@Override
	public void remove(Person data) {
		if(data == null){
			return;
		}

		for(int i = 0; i < personList.size(); i++){
			if(data.getId() == personList.get(i).getId()){
				personList.remove(i);				
				break;
			}
		}
	}

	@Override
	public void clear() {
		personList.clear();
	}

	@Override
	public void add(Person data) {
		personList.add(data);
	}

	@Override
	public void update(Person data, int index) {
		personList.set(index, data);
	}

	@Override
	public void update(Person data) {
		if(data == null){
			return;
		}

		for(int i = 0; i < personList.size(); i++){
			if(data.getId() == personList.get(i).getId()){
				personList.set(i, data);				
				break;
			}
		}
	}

	@Override
	public Person get(int index) {
		return personList.get(index);
	}

	@Override
	public Person[] getAll() {
		return (Person[]) personList.toArray();
	}

	@Override
	public void addAll(List<Person> datas) {
		personList.addAll(datas);
	}

	@Override
	public void addFresh(List<Person> datas) {
		clear();
		addAll(datas);
	}

	@Override
	public List<Person> getAllAsList() {
		return personList;
	}

	@Override
	public int size() {
		return personList.size();
	}
}
