package data;

import java.util.List;

import dto.Interesser;

public interface iInteresserData extends iDatabase {
	public void add(Interesser data);
	public void addAll(List<Interesser> datas);
	public void addFresh(List<Interesser> datas);
	public void update(Interesser data, int index);
	public void update(Interesser data);
	public void remove(Interesser data);
	public Interesser get(int index);
	public Interesser[] getAll();
	public List<Interesser> getAllAsList();
}
