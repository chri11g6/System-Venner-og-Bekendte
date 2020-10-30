package main.logic;

import java.util.List;

import main.dto.iInteresser;

public interface iInteresserLogicData {
	public void add(iInteresser data);
	public void update(iInteresser data, int index);
	public void update(iInteresser data);
	public void remove(iInteresser data);
	public void remove(int index);
	public iInteresser get(int index);
	public iInteresser[] getAll();
	public List<iInteresser> getAllAsList();
	public int size();
}
