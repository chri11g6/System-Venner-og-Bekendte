package main.logic;

import java.util.List;
import java.util.stream.Collectors;

import main.data.DataFactory;
import main.data.iPersonData;
import main.dto.iPerson;

public class PesonLogicData implements iPesonLogicData {

	private iPersonData personData = DataFactory.getPersonData();

	@Override
	public void add(iPerson data) {
		personData.add(data);
	}

	@Override
	public void update(iPerson data, int index) {
		personData.update(data, index);
	}

	@Override
	public void update(iPerson data) {
		personData.update(data);
	}

	@Override
	public void updateOrAdd(iPerson data) {
		personData.updateOrAdd(data);
	}

	@Override
	public void remove(iPerson data) {
		personData.remove(data);
	}

	@Override
	public void remove(int index) {
		personData.remove(index);
	}

	@Override
	public iPerson get(int index) {
		return personData.get(index);
	}

	@Override
	public iPerson[] getAll() {
		return personData.getAll();
	}

	@Override
	public List<iPerson> getAllAsList() {
		return personData.getAllAsList().stream().collect(Collectors.toList());
	}

	@Override
	public int size() {
		return personData.size();
	}

}
