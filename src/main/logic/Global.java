package main.logic;

import java.io.File;
import java.util.Stack;

import main.dto.iPerson;

class Global implements iGlobal{

	private iPersonLogicData personList = new PersonLogicData();
	private iInteresserLogicData interesserList = new InteresserLogicData();
	
	private iPerson personHolder;
	
	private File filePathHolder;

	public Stack<String> sti = new Stack<String>();

	public void setFilePathHolder(File filePath){
		filePathHolder = filePath;
	}

	public File getFilePathHolder(){
		return filePathHolder;
	}

	public void setPersonHolder(iPerson person) {
		personHolder = person;
	}

	public iPerson getPersonHolder() {
		return personHolder.clone();
	}

	public void saveToPersonList() {
		personList.updateOrAdd(personHolder);
	}

	public void SletFromPersonList() {
		personList.remove(personHolder);
	}

	public String getSti() {
		StringBuilder sti = new StringBuilder();

		for (int i = 0; i < this.sti.size(); i++) {
			sti.append(this.sti.get(i));
			if (i < this.sti.size() - 1) {
				sti.append("> ");
			}
		}

		return sti.toString();
	}

	@Override
	public iPersonLogicData getPersonList() {
		return personList;
	}

	@Override
	public iInteresserLogicData getInteresserList() {
		return interesserList;
	}
}
