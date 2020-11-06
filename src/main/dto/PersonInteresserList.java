package main.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonInteresserList implements iPersonInteresserList {
	private List<iInteresser> interesser = new ArrayList<iInteresser>();

	@Override
	public List<iInteresser> getInteresser() {
		return interesser;
	}

	@Override
	public String toString() {
		if(interesser.size() == 0){
			return "";
		}

		List<String> localList = new ArrayList<String>();

		for(iInteresser interesserData : interesser){
			localList.add(interesserData.getNavn());
		}

		return String.join(", ", localList);
	}	
}
