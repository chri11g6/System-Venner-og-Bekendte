package main.logic;

import java.util.List;

import main.dto.iPerson;

public interface iPesonLogicData {
	public void add(iPerson data);
	public void update(iPerson data, int index);
	public void update(iPerson data);
	public void updateOrAdd(iPerson data);
	public void remove(iPerson data);
	public void remove(int index);
	public iPerson get(int index);
	public iPerson[] getAll();
	public List<iPerson> getAllAsList();
	public int size();
}
