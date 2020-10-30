package main.logic;

import java.util.List;

import main.data.HoldData;
import main.data.iInteresserData;
import main.dto.iInteresser;

public class InteresserLogicData implements iInteresserLogicData {

	private iInteresserData interesserData = HoldData.getInteresserData();

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
		interesserData.update(data);
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
		return interesserData.getAllAsList();
	}

	@Override
	public int size() {
		return interesserData.size();
	}
	
}
