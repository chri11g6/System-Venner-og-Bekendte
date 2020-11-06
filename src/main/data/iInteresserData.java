package main.data;

import java.util.List;

import main.dto.iInteresser;

public interface iInteresserData extends iDatabase {
	public void add(iInteresser data);
	public void addAll(List<iInteresser> datas);
	public void addFresh(List<iInteresser> datas);
	public void update(iInteresser data, int index);
	public boolean update(iInteresser data);
	public void updateOrAdd(iInteresser data);
	public void remove(iInteresser data);
	public iInteresser get(int index);
	public iInteresser[] getAll();
	public List<iInteresser> getAllAsList();
}
