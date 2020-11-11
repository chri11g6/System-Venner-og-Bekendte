package main.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.dto.iInteresser;

class InteresserData implements iInteresserData {
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
	public boolean isExists(iInteresser data) {
		//TODO skal lave det til private eller om omdøbe til isExits
		boolean isUpdate = false;
		if(data == null){
			return isUpdate;
		}

		for(int i = 0; i < interesserList.size(); i++){
			if(data.getId() == interesserList.get(i).getId()){
				interesserList.set(i, data);
				isUpdate = true;
				break;
			}
		}

		return isUpdate;
	}

	@Override
	public void updateOrAdd(iInteresser data) {
		if(!isExists(data)){
			add(data);
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
		return interesserList.stream().collect(Collectors.toList());
	}

	@Override
	public int size() {
		return interesserList.size();
	}
}
