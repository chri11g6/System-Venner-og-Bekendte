package main.logic;

import java.util.List;
import java.util.stream.Collectors;

import main.data.DataFactory;
import main.data.iInteresserData;
import main.dto.iInteresser;

class InteresserLogicData implements iInteresserLogicData {

	private iInteresserData interesserData = DataFactory.getInteresserData();

	@Override
	public void add(iInteresser data) {
		interesserData.add(data);
	}

	@Override
	public void update(iInteresser data, int index) {
		interesserData.update(data, index);
	}

	@Override
	public void update(iInteresser data) {
		interesserData.isExists(data);
	}

	@Override
	public void updateOrAdd(iInteresser data) {
		interesserData.updateOrAdd(data);
	}

	@Override
	public void remove(iInteresser data) {
		interesserData.remove(data);
	}

	@Override
	public void remove(int index) {
		interesserData.remove(index);
	}

	@Override
	public iInteresser get(int index) {
		return interesserData.get(index);
	}

	@Override
	public iInteresser[] getAll() {
		return interesserData.getAll();
	}

	@Override
	public List<iInteresser> getAllAsList() {
		return interesserData.getAllAsList().stream().collect(Collectors.toList());
	}

	@Override
	public int size() {
		return interesserData.size();
	}

}
