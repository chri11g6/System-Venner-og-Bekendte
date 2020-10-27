package main.logic;

import java.util.List;

import main.dto.Interesser;

public interface iInteresserLogicData {
	public void add(Interesser data);
	public void update(Interesser data, int index);
	public void update(Interesser data);
	public void remove(Interesser data);
	public void remove(int index);
	public Interesser get(int index);
	public Interesser[] getAll();
	public List<Interesser> getAllAsList();
	public int size();
}
