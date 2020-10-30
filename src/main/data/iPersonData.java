package main.data;

import java.util.List;

import main.dto.iPerson;

public interface iPersonData extends iDatabase {
	public void add(iPerson data);
	public void addAll(List<iPerson> datas);
	public void addFresh(List<iPerson> datas);
	public void update(iPerson data, int index);
	public void update(iPerson data);
	public void remove(iPerson data);
	public iPerson get(int index);
	public iPerson[] getAll();
	public List<iPerson> getAllAsList();
}
