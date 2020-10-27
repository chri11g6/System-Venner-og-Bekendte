package main.logic;

import java.util.List;

import main.data.HoldData;
import main.data.iInteresserData;
import main.dto.Interesser;

public class InteresserLogicData implements iInteresserLogicData {

	private iInteresserData interesserData = HoldData.getInteresserData();

	@Override
	public void add(Interesser data) {
		interesserData.add(data);
	}

	@Override
	public void update(Interesser data, int index) {
		interesserData.update(data, index);
	}

	@Override
	public void update(Interesser data) {
		interesserData.update(data);
	}

	@Override
	public void remove(Interesser data) {
		interesserData.remove(data);
	}

	@Override
	public void remove(int index) {
		interesserData.remove(index);
	}

	@Override
	public Interesser get(int index) {
		return interesserData.get(index);
	}

	@Override
	public Interesser[] getAll() {
		return interesserData.getAll();
	}

	@Override
	public List<Interesser> getAllAsList() {
		return interesserData.getAllAsList();
	}

	@Override
	public int size() {
		return interesserData.size();
	}
	
}
