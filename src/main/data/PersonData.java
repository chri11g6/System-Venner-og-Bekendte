package main.data;

import java.util.ArrayList;
import java.util.List;

import main.dto.Person;
import main.dto.iPerson;

public class PersonData implements iPersonData {
	private List<iPerson> personList = new ArrayList<iPerson>();

	@Override
	public void remove(int index) {
		personList.remove(index);
	}

	@Override
	public void remove(iPerson data) {
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
	public void add(iPerson data) {
		personList.add(data);
	}

	@Override
	public void update(iPerson data, int index) {
		personList.set(index, data);
	}

	@Override
	public void update(iPerson data) {
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
	public iPerson get(int index) {
		return personList.get(index);
	}

	@Override
	public iPerson[] getAll() {
		return (Person[]) personList.toArray();
	}

	@Override
	public void addAll(List<iPerson> datas) {
		personList.addAll(datas);
	}

	@Override
	public void addFresh(List<iPerson> datas) {
		clear();
		addAll(datas);
	}

	@Override
	public List<iPerson> getAllAsList() {
		return personList;
	}

	@Override
	public int size() {
		return personList.size();
	}
}
