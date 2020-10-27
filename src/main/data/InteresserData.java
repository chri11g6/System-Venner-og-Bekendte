package main.data;

import java.util.ArrayList;
import java.util.List;

import main.dto.Interesser;

public class InteresserData implements iInteresserData {
	private List<Interesser> interesserList = new ArrayList<Interesser>();

	@Override
	public void remove(int index) {
		interesserList.remove(index);
	}

	@Override
	public void clear() {
		interesserList.clear();
	}

	@Override
	public void add(Interesser data) {
		interesserList.add(data);
	}

	@Override
	public void update(Interesser data, int index) {
		interesserList.set(index, data);
	}

	@Override
	public void update(Interesser data) {
		if(data == null){
			return;
		}

		for(int i = 0; i < interesserList.size(); i++){
			if(data.getId() == interesserList.get(i).getId()){
				interesserList.set(i, data);				
				break;
			}
		}
	}

	@Override
	public void remove(Interesser data) {
		if(data == null){
			return;
		}

		for(int i = 0; i < interesserList.size(); i++){
			if(data.getId() == interesserList.get(i).getId()){
				interesserList.remove(i);				
				break;
			}
		}
	}

	@Override
	public Interesser get(int index) {
		return interesserList.get(index);
	}

	@Override
	public Interesser[] getAll() {
		return (Interesser[]) interesserList.toArray();
	}

	@Override
	public void addAll(List<Interesser> datas) {
		interesserList.addAll(datas);
	}

	@Override
	public void addFresh(List<Interesser> datas) {
		clear();
		addAll(datas);
	}

	@Override
	public List<Interesser> getAllAsList() {
		return interesserList;
	}

	@Override
	public int size() {
		return interesserList.size();
	}
	
}
