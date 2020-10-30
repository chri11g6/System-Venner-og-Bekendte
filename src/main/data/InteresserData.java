package main.data;

import java.util.ArrayList;
import java.util.List;

import main.dto.iInteresser;

public class InteresserData implements iInteresserData {
	private List<iInteresser> interesserList = new ArrayList<iInteresser>();

	@Override
	public void remove(int index) {
		interesserList.remove(index);
	}

	@Override
	public void clear() {
		interesserList.clear();
	}

	@Override
	public void add(iInteresser data) {
		interesserList.add(data);
	}

	@Override
	public void update(iInteresser data, int index) {
		interesserList.set(index, data);
	}

	@Override
	public void update(iInteresser data) {
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
	public void remove(iInteresser data) {
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
	public iInteresser get(int index) {
		return interesserList.get(index);
	}

	@Override
	public iInteresser[] getAll() {
		return (iInteresser[]) interesserList.toArray();
	}

	@Override
	public void addAll(List<iInteresser> datas) {
		interesserList.addAll(datas);
	}

	@Override
	public void addFresh(List<iInteresser> datas) {
		clear();
		addAll(datas);
	}

	@Override
	public List<iInteresser> getAllAsList() {
		return interesserList;
	}

	@Override
	public int size() {
		return interesserList.size();
	}
	
}
